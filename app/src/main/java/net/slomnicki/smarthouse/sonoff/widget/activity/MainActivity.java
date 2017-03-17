package net.slomnicki.smarthouse.sonoff.widget.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import net.slomnicki.smarthouse.sonoff.widget.R;
import net.slomnicki.smarthouse.sonoff.widget.SonoffWidgetApplication;
import net.slomnicki.smarthouse.sonoff.widget.api.ApplicationApi;
import net.slomnicki.smarthouse.sonoff.widget.api.RelayStatus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApplicationApi mApi;

    @BindView(R.id.toggle_button)
    protected Button mToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mApi = SonoffWidgetApplication.getApi(this);
    }

    public void toggleButtonClick(View view) {
        mApi.toggleRelay().enqueue(new Callback<RelayStatus>() {
            @Override
            public void onResponse(Call<RelayStatus> call, Response<RelayStatus> response) {
                Toast.makeText(MainActivity.this, "Relay status: " + response.body().getRelay(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RelayStatus> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

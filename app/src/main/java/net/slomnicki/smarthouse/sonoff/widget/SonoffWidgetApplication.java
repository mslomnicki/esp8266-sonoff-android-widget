package net.slomnicki.smarthouse.sonoff.widget;

import android.app.Application;
import android.content.Context;
import net.slomnicki.smarthouse.sonoff.widget.api.ApiProvider;
import net.slomnicki.smarthouse.sonoff.widget.api.ApplicationApi;
import retrofit2.Retrofit;

public class SonoffWidgetApplication extends Application {
    private ApplicationApi mApi;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = ApiProvider.getRetrofit();
        mApi = ApiProvider.getApi(mRetrofit);
    }

    public ApplicationApi getApi() {
        return mApi;
    }

    public static ApplicationApi getApi(Context context) {
        SonoffWidgetApplication application = (SonoffWidgetApplication) context.getApplicationContext();
        return application.getApi();
    }
}


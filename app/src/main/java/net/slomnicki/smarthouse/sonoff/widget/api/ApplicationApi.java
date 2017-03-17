package net.slomnicki.smarthouse.sonoff.widget.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApplicationApi {
    @GET("/relay")
    Call<RelayStatus> getRelayStatus();

    @POST("/relay/TOGGLE")
    Call<RelayStatus> toggleRelay();
}

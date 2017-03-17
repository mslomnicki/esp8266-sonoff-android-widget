package net.slomnicki.smarthouse.sonoff.widget.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    private static final String BASE_URL = "http://10.20.30.10";

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static ApplicationApi getApi(Retrofit retrofit) {
        return retrofit.create(ApplicationApi.class);
    }
}

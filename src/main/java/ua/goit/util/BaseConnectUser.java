package ua.goit.util;

import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.service.retrofit.RetrofitClientUser;

public class BaseConnectUser {
    private static final RetrofitClientUser retrofitClient;
    private static final String BASE_URL = PropertiesLoader.getProperty("db.url");

    static {
        retrofitClient = RetrofitConfig.createClient(BASE_URL,
                GsonConverterFactory.create(), RetrofitClientUser.class);
    }

    public static RetrofitClientUser getClient() {
        return retrofitClient;
    }
}

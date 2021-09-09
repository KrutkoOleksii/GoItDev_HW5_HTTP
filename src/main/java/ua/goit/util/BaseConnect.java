package ua.goit.util;

import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.service.retrofit.RetrofitClient;

public class BaseConnect {
    private static final RetrofitClient retrofitClient;
    private static final String BASE_URL = PropertiesLoader.getProperty("db.url");

    static {
        retrofitClient = RetrofitConfig.createClient(BASE_URL,
                GsonConverterFactory.create(), RetrofitClient.class);
    }

    public static RetrofitClient getClient() {
        return retrofitClient;
    }
}

package ua.goit.util;

import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.service.retrofit.RetrofitClientPet;

public class BaseConnectPet {
    private static final RetrofitClientPet retrofitClient;
    private static final String BASE_URL = PropertiesLoader.getProperty("db.url");

    static {
        retrofitClient = RetrofitConfig.createClient(BASE_URL,
                GsonConverterFactory.create(), RetrofitClientPet.class);
    }

    public static RetrofitClientPet getClient() {
        return retrofitClient;
    }
}

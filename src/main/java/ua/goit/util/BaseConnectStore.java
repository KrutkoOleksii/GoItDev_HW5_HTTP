package ua.goit.util;

import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.service.retrofit.RetrofitClientStore;

public class BaseConnectStore {
    private static final RetrofitClientStore retrofitClient;
    private static final String BASE_URL = PropertiesLoader.getProperty("db.url");

    static {
        retrofitClient = RetrofitConfig.createClient(BASE_URL,
                GsonConverterFactory.create(), RetrofitClientStore.class);
    }

    public static RetrofitClientStore getClient() {
        return retrofitClient;
    }
}

package ua.goit.util;

import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.service.RetrofitClient;

public class BaseConnect {

    private static final RetrofitClient retrofitClient;
    //private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    private static final String BASE_URL = PropertiesLoader.getProperty("db.url");

    static {
        retrofitClient = RetrofitConfig.createClient(BASE_URL,
                GsonConverterFactory.create(), RetrofitClient.class);
    }

    public static RetrofitClient getClient() {
        return retrofitClient;
    }
}

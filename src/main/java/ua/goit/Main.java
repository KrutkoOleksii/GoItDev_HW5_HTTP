package ua.goit;

import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.model.Category;
import ua.goit.model.Pet;
import ua.goit.model.Tag;
import ua.goit.service.RetrofitClient;
import ua.goit.util.RetrofitConfig;

import java.io.IOException;

public class Main {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    public static void main(String[] args) throws IOException {
        RetrofitClient retrofitClient = RetrofitConfig.createClient(BASE_URL,
                GsonConverterFactory.create(), RetrofitClient.class);

        Pet pet = RetrofitConfig.execute(retrofitClient.getToModel(10));
        System.out.println(pet.toString());

//        Pet responseAdd = RetrofitConfig.execute(retrofitClient.addObject(new Pet(10,
//                new Category(),
//                "cat",
//                new String[2]{"new","old"},
//                new Tag(),
//                "available"
//        )));



    }
}

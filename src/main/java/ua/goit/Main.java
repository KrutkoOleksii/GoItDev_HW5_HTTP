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

        Pet pet = RetrofitConfig.execute(retrofitClient.getToModel(2));
        System.out.println(pet.toString());

        Pet cat = RetrofitConfig.execute(retrofitClient.addPet(new Pet(10,
                new Category(1,"Cats"),
                "cat Tom",
                new String[2],
                new Tag[1],
                "available"
        )));
        System.out.println(cat.toString());

        Pet mouse = RetrofitConfig.execute(retrofitClient.addPet(new Pet(11,
                new Category(7,"mice"),
                "mouse Jerry",
                new String[2],
                new Tag[1],
                "available"
        )));
        System.out.println(mouse.toString());

    }
}

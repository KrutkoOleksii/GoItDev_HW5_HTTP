package ua.goit;


import okhttp3.ResponseBody;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.model.Category;
import ua.goit.model.Pet;
import ua.goit.model.Tag;
import ua.goit.service.RetrofitClient;
import ua.goit.util.PropertiesLoader;
import ua.goit.util.RetrofitConfig;

import java.util.List;

public class Main {
    private static final String BASE_URL = PropertiesLoader.getProperty("db.url");

    public static void main(String[] args) {
        // pet
        // store
        // returns pet inventories by status
        // place an order for a pet
        // get an order by id
        // delete an order by id
        System.out.println(new StringBuilder()
                .append("Select the query and print it with the parameters:\n")
                // pet
                .append("   post|pet|{petId}|uploadImage\n")
                .append("   post|pet\n")
                .append("   post|pet|{petId}\n")
                .append("   put|pet\n")
                .append("   get|pet|{petId}\n")
                .append("   get|pet|findByStatus\n")
                .append("   delete|pet|{petId}\n")
                // store
                .append("   get|store|inventory\n")
                .append("   post|store|order\n")
                .append("   get|store|order|{orderId}\n")
                .append("   delete|store|order|{orderId}\n")
                // user
                .append("   post|user\n")
                .append("   post|user|createWithArray\n")
                .append("   post|user|createWithList\n")
                .append("   get|user|{username}\n")
                .append("   get|user|login\n")
                .append("   get|user|logout\n")
                .append("   put|user|{username}\n")
                .append("   delete|user|{username}\n")
                .toString()
        );

        RetrofitClient retrofitClient = RetrofitConfig.createClient(BASE_URL,
                GsonConverterFactory.create(), RetrofitClient.class);

//        Pet pet = RetrofitConfig.execute(retrofitClient.getPet(2));
//        System.out.println(pet.toString());

        Pet cat = RetrofitConfig.execute(retrofitClient.addPet(new Pet(1,
                new Category(5,"Cats"),
                "cat tom",
                new String[]{"http://pics.pets.ua/cat1.png","http://pics.pets.ua/cat2.png"},
                new Tag[]{new Tag(1,"cat"),new Tag(2,"tom")},
                "available"
        )));
        System.out.println("addPet:\n"+RetrofitConfig.execute(retrofitClient.getPet(1)));

        RetrofitConfig.execute(retrofitClient.updatePet(new Pet(5,
                new Category(1,"Cats"),
                "cat Tom",
                new String[]{"http://pics.pets.ua/cat3.png","http://pics.pets.ua/cat4.png"},
                new Tag[]{new Tag(1,"cat"),new Tag(2,"Tom")},
                "sold"
        )));
        System.out.println("updatePet:\n"+RetrofitConfig.execute(retrofitClient.getPet(1)));

//        RetrofitConfig.execute(retrofitClient.addPetById(1,"cat Tom1","sold"));
//        System.out.println("addPetById:\n"+RetrofitConfig.execute(retrofitClient.getPet(1)));

        ResponseBody response = RetrofitConfig.execute(retrofitClient.getPetByStatus(new String[]{"available", "sold"}));
        System.out.println("getPetByStatus:\n"+response.toString());

        Pet mouse = RetrofitConfig.execute(retrofitClient.addPet(new Pet(2,
                new Category(7,"mice"),
                "mouse Jerry",
                new String[]{"http://pics.pets.ua/mouse1.png","http://pics.pets.ua/mouse2.png"},
                new Tag[]{new Tag(1,"mouse"),new Tag(2,"Jerry")},
                "available"
        )));
        System.out.println("addPet:\n"+RetrofitConfig.execute(retrofitClient.getPet(2)));

    }
}

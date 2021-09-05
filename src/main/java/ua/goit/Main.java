package ua.goit;

import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import ua.goit.model.*;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.OrderRepository;
import ua.goit.repository.PetRepository;
import ua.goit.repository.UserRepository;
import ua.goit.util.BaseConnect;
import ua.goit.service.RetrofitClient;
import ua.goit.util.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //private static final String BASE_URL = PropertiesLoader.getProperty("db.url");
    //private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    private static final BaseRepository petRepository = new PetRepository();
    private static final BaseRepository orderRepository = new OrderRepository();
    private static final BaseRepository userRepository = new UserRepository();

    public static void main(String[] args) {
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
        );

        System.out.println("************************************");

        RetrofitClient retrofitClient = BaseConnect.getClient();

//        Pet pet = RetrofitConfig.execute(retrofitClient.getPet(2));
//        System.out.println(pet.toString());

        // 1. POST
        //

        // 2. POST
        Pet newPet = (Pet) petRepository.createEntity(
                new Pet(1,
                new Category(1,"Cats"),
                "cat tom",
                new String[]{"http://pics.pets.ua/cat1.png","http://pics.pets.ua/cat2.png"},
                new Tag[]{new Tag(1,"cat"),new Tag(2,"tom")},
                "available"
        ));
        System.out.println("2. add Pet:\n"+newPet.toString());

        // 3. PUT
        Pet updatePet = (Pet) petRepository.updateEntity(
                new Pet(1,
                new Category(1, "Cats"),
                "cat Tom",
                new String[]{"http://pics.pets.ua/cat3.png", "http://pics.pets.ua/cat4.png"},
                new Tag[]{new Tag(1, "cat"), new Tag(2, "Tom")},
                "sold"
        ));
        System.out.println("3. update Pet:\n"+updatePet.toString());

        // ****** getByParam
        // 4. GET (https://petstore.swagger.io/v2/pet/findByStatus?status=available&status=sold)
        String[] statuses = {"available", "sold"};
        ResponseBody response = RetrofitConfig.execute(retrofitClient.getPetByStatus(statuses));
        System.out.println("4. get Pet By Status:\n"+response.toString());

        // ****** updateEntity
        // 5. PUT (https://petstore.swagger.io/v2/pet/{petId})
//        RequestBody nameCat = RequestBody.create(MediaType.parse("string"), "cat Tom1");
//        RequestBody status = RequestBody.create(MediaType.parse("string"), "sold");
//        petRepository.updateEntity()
//        Call<Pet> petCall = retrofitClient.updatePetById(1, nameCat, status);
//        Pet petById = RetrofitConfig.execute(petCall);
//        System.out.println("5. add Pet By Id:\n"+petById.toString());

        Pet mouse = (Pet) petRepository.createEntity(
                new Pet(2,
                new Category(7,"mice"),
                "mouse Jerry",
                new String[]{"http://pics.pets.ua/mouse1.png","http://pics.pets.ua/mouse2.png"},
                new Tag[]{new Tag(1,"mouse"),new Tag(2,"Jerry")},
                "available"
        ));
        System.out.println("-. add Pet:\n"+mouse.toString());

        Pet getPet = (Pet) petRepository.getEntity(1);
        System.out.println("6.1 get Pet By Id:\n"+getPet.toString());

        // 6. DELETE
        ResponseBody body = petRepository.deleteEntity(2);
        System.out.println("6.2 delete Pet By Id:\n"+body.toString());

        // STORE

        // ****** getCollection
        // 7. GET (https://petstore.swagger.io/v2/store/inventory)
        Call callInventory = retrofitClient.getInventory();
        Object inventory = RetrofitConfig.execute(callInventory);
        //ResponseBody body = inventory.body();
        System.out.println("7. get Inventory:\n"+inventory.toString());

        // 8. POST
        Order newOrder = (Order) orderRepository.createEntity(
                new Order(4, 1, 1, "2021-09-01", "order", true));
        System.out.println("8. add Order:\n"+newOrder.toString());

        // 9. GET
        Order orderById = (Order) orderRepository.getEntity(4);
        System.out.println("9. get Order By Id:\n" + orderById.toString());

        // 10. DELETE
        ResponseBody deletedOrder = orderRepository.deleteEntity(4);
        System.out.println("10. delete Order By Id:\n" + deletedOrder);

        // USER
        User user1 = new User(7, "Admin", "Ivan", "Iurko",
                "ivan@mail.goit.com", "12345", "+38012345678", 1);
        User user2 = new User(8, "Manager","Taras","Manevskij",
                "taras@mail.goit.com","54321","+380117654321", 1);
        User user3 = new User(7, "Director", "Anton", "Borenko",
                "antin@mail.goit.com", "77777", "+380777777777", 1);
        List users = new ArrayList();
        users.add(user1);
        users.add(user2);
        User[] usersArray = {user1, user2};

        // ****** saveAll
        // 11. POST (https://petstore.swagger.io/v2/user/createWithList)
        Call userWithList = retrofitClient.createUserWithList(users);
        Object responseUserList = RetrofitConfig.execute(userWithList);
        System.out.println("11. create User With List:\n" + responseUserList);

        // 12. GET
        User getUser = (User) userRepository.getEntity("Admin");
        System.out.println("12. get User By User Name:\n" + getUser);

        // 13. PUT
        User updateUser = new User(7, "Admin", "Ivan", "Sirko",
                "ivansirko@mail.goit.com", "12345678", "+38012345678", 1);
        User newUser = (User) userRepository.updateEntity(updateUser);
        System.out.println("13. update User By User Name:\n" + newUser.toString());

        // 14. DELETE
        ResponseBody deletedUser = userRepository.deleteEntity("Admin");
        System.out.println("14. delete User By User Name:\n" + deletedUser.toString());

        // ****** !!!
        // 15. GET (https://petstore.swagger.io/v2/user/login?username={username}&password={password})
        Call<User> managerLogin = retrofitClient.userLogin("Manager", "54321");
        User userLogin = RetrofitConfig.execute(managerLogin);
        System.out.println("15. User login:\n" + userLogin.toString());

        // ****** !!!
        // 16. GET (https://petstore.swagger.io/v2/user/logout)
        Call<User> managerLogout = retrofitClient.userLogout();
        User userLogout = RetrofitConfig.execute(managerLogout);
        System.out.println("16. User logout:\n" + userLogout.toString());

        // ****** saveAll
        // 17. POST (https://petstore.swagger.io/v2/user/createWithArray)
        Call usersWithArray = retrofitClient.createUserWithArray(usersArray);
        Object execute = RetrofitConfig.execute(usersWithArray);
        System.out.println("17. create User With Array:\n" + execute.toString());

        // 18. POST
//        Call addUser = retrofitClient.addUser(user3);
//        Object responseUser = RetrofitConfig.execute(addUser);
        BaseEntity responseUser = userRepository.createEntity(user3);
        System.out.println("18. add User:\n" + responseUser.toString());
    }
}

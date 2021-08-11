package ua.goit.service;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.model.*;

import java.util.List;

public interface RetrofitClient {

    @POST("pet/{petId}/uploadImage")
    @Headers({"Content-Type: application/json"})
    Call<Pet> uploadImage(@Path("petId") Integer id); ////
    //additionalMetadata=dog
    //'file=@dog_noun_001_04904.jpg;type=image/jpeg'

    @POST("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> addPet(@Body Pet pet); ////

    @PUT("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> updatePet(@Body Pet pet); ////

    @GET("pet/findByStatus")
    @Headers({"Content-Type: application/json"})
    Call<List<Pet>> findByStatus(); ////

    @GET("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> getToModel(@Path("petId") Integer id); ////

    @POST("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> updateObject(@Body Pet pet); ////

    @DELETE("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> deletePet(@Path("petId") Integer id); ////

    // STORE
    @GET("store/inventory")
    @Headers({"Content-Type: application/json"})
    Call<Store> getInventory();

    @POST("store/order")
    @Headers({"Content-Type: application/json"})
    Call<Store> addOrder(@Body Store store);

    @GET("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<Store> getOrderById(@Body Store store, @Path("orderId") Integer orderId);

    @DELETE("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<Store> deleteOrderById(@Path("orderId") Integer orderId);

    // USER
    @POST("user/createWithList")
    @Headers({"Content-Type: application/json"})
    Call<List<User>> createUserWithList(@Body List<User> users);

    @GET("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<User> getUserByUserName(@Path("userName") String userName);

    @PUT("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<User> updateUserByUserName(@Body User user, @Path("userName") String userName);

    @DELETE("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<User> deleteUserById(@Path("userName") String userName);

    @GET("user/login")
    @Headers({"Content-Type: application/json"})
    Call<User> userLogin(@Body String username, String password);

    @GET("user/logout")
    @Headers({"Content-Type: application/json"})
    Call<User> userLogout();

    @POST("user/createWithArray")
    @Headers({"Content-Type: application/json"})
    Call createUserWithArray(@Body User[] users);

    @POST("user")
    @Headers({"Content-Type: application/json"})
    Call addUser(@Body User user);

//    @GET("users")
//    @Headers({"Content-Type: application/json"})
//    Call<List<User>> getUserByID(@Query("id") Integer id);
//
//    @GET("users")
//    @Headers({"Content-Type: application/json"})
//    Call<List<User>> getUserByUserName(@Query("username") String userName);
//
//    @GET("users/{userID}/posts")
//    @Headers({"Content-Type: application/json"})
//    Call<List<UserPost>> getUserPosts(@Path("userID") String userID);
//
//    @GET("posts/{postID}/comments")
//    Call<List<Comment>> getComments(@Path("postID") String userID);
//
//    @GET("users/{userID}/todos")
//    Call<List<ToDo>> getTodos(@Path("userID") String userID, @Query("completed") boolean completed);

}

package ua.goit.service;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.model.*;

import java.util.List;

public interface RetrofitClient {

    @Multipart
    @POST("pet/{petId}/uploadImage")
    @Headers({"Content-Type: application/json"})
    //Call<ResponseBody> uploadPetImage(@Path("petId") Integer id, @Part("additionalMetadata") String additionalMetadata, @Part("file") RequestBody image);
    Call<ResponseBody> uploadPetImage(@Path("petId") Integer id, @Part MultipartBody.Part additionalMetadata, @Part MultipartBody.Part filePart);

    @POST("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> addPet(@Body Pet pet);

    @PUT("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> updatePet(@Body Pet pet);

    @GET("pet/findByStatus")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> getPetByStatus(@Query("status") String[] status);

    @GET("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> getPet(@Path("petId") Integer id);

    @Multipart
    @POST("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> updatePetById(@Path("petId") Integer id, @Part("name") RequestBody name, @Part("status") RequestBody status);

    @DELETE("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> deletePetById(@Path("petId") Integer id);

    // STORE
    @GET("store/inventory")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> getInventory();

    @POST("store/order")
    @Headers({"Content-Type: application/json"})
    Call<Order> addOrder(@Body Order order);

    @GET("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<Order> getOrderById(@Path("orderId") Integer orderId);

    @DELETE("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> deleteOrderById(@Path("orderId") Integer orderId);

    // USER
    @POST("user/createWithList")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> createUserWithList(@Body List<User> users);

    @GET("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<User> getUserByUserName(@Path("userName") String userName);

    @PUT("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<User> updateUserByUserName(@Body User user, @Path("userName") String userName);

    @DELETE("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> deleteUserById(@Path("userName") String userName);

    @GET("user/login")
    @Headers({"Content-Type: application/json"})
    Call<User> userLogin(@Query("username") String username, @Query("password") String password);

    @GET("user/logout")
    @Headers({"Content-Type: application/json"})
    Call<User> userLogout();

    @POST("user/createWithArray")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> createUserWithArray(@Body User[] users);

    @POST("user")
    @Headers({"Content-Type: application/json"})
    Call<User>  addUser(@Body User user);

//    @GET("users")
//    @Headers({"Content-Type: application/json"})
//    Call<List<User>> getUserByID(@Query("id") Integer id);
//
//    @GET("users")
//    @Headers({"Content-Type: application/json"})
//    Call<List<User>> getUserByUserName(@Query("username") String userName);

}

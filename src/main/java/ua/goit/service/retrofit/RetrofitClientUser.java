package ua.goit.service.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.model.*;

import java.util.List;

public interface RetrofitClientUser extends RetrofitClient<String, User>{

    @POST("user/createWithList")
    @Headers({"Content-Type: application/json"})
    Call<List<User>> createUserWithList(@Body List<User> users);

    @Override
    @GET("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<User> getEntity (@Path("userName") String userName);

    @PUT("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<User> updateUserByUserName(@Body User user, @Path("userName") String userName);

    @Override
    @DELETE("user/{userName}")
    @Headers({"Content-Type: application/json"})
    Call<User> deleteEntity(@Path("userName") String userName);

    @GET("user/login")
    @Headers({"Content-Type: application/json"})
    Call<User> userLogin(@Query("username") String username, @Query("password") String password);

    @GET("user/logout")
    @Headers({"Content-Type: application/json"})
    Call<User> userLogout();

    @POST("user/createWithArray")
    @Headers({"Content-Type: application/json"})
    Call<List<User>> createUserWithArray(@Body User[] users);

    @Override
    @POST("user")
    @Headers({"Content-Type: application/json"})
    Call<User> addEntity(@Body User user);

}

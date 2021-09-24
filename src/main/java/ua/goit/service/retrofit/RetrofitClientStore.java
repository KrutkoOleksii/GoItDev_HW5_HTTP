package ua.goit.service.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.model.ApiResponse;
import ua.goit.model.Order;

import java.util.Map;

public interface RetrofitClientStore {

    @GET("store/inventory")
    @Headers({"Content-Type: application/json"})
    Call<Map<String,Integer>> getInventory();

    @POST("store/order")
    @Headers({"Content-Type: application/json"})
    Call<Order> addEntity(@Body Order order);

    @GET("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<Order> getEntity(@Path("orderId") Long orderId);

    @DELETE("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<ApiResponse> deleteEntity(@Path("orderId") Long orderId);
}

package ua.goit.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.model.Order;

import java.util.Map;

public interface RetrofitClientStore {

    @GET("store/inventory")
    @Headers({"Content-Type: application/json"})
    Call<Map<String,Integer>> getInventory();

    @POST("store/order")
    @Headers({"Content-Type: application/json"})
    Call<Order> addOrder(@Body Order order);

    @GET("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<Order> getOrderById(@Path("orderId") Long orderId);

    @DELETE("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> deleteOrderById(@Path("orderId") Long orderId);
}

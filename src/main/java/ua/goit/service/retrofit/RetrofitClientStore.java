package ua.goit.service.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.model.Order;

import java.util.Map;

public interface RetrofitClientStore extends RetrofitClient<Long,Order>{

    @GET("store/inventory")
    @Headers({"Content-Type: application/json"})
    Call<Map<String,Integer>> getInventory();

    @Override
    @POST("store/order")
    @Headers({"Content-Type: application/json"})
    Call<Order> addEntity(@Body Order order);

    @Override
    @GET("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<Order> getEntity(@Path("orderId") Long orderId);

    @Override
    @DELETE("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<Order> deleteEntity(@Path("orderId") Long orderId);
}

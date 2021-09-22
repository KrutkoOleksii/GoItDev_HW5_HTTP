package ua.goit.service;

import retrofit2.Call;
import ua.goit.model.Order;
import ua.goit.service.retrofit.RetrofitClientStore;
import ua.goit.util.BaseConnectStore;
import ua.goit.util.RetrofitConfig;

import java.util.Map;

public class OrderService implements BaseService<Long, Order> {

    RetrofitClientStore retrofitClient = BaseConnectStore.getClient();

    @Override
    public Order createEntity(Order order) {
        return RetrofitConfig.execute(retrofitClient.addEntity(order));
    }

    @Override
    public Order updateEntity(Order order) {
        return null;
    }

    @Override
    public Order getEntity(Long id) {
        return RetrofitConfig.execute(retrofitClient.getEntity(id));
    }

    @Override
    public Order deleteEntity(Long id) {
        return RetrofitConfig.execute(retrofitClient.deleteEntity(id));
    }

    public String  getInventory(){
        Call<Map<String, Integer>> callInventory = retrofitClient.getInventory();
        return RetrofitConfig.execute(callInventory).toString();
    }

}

package ua.goit.service;

import okhttp3.ResponseBody;
import ua.goit.model.Order;
import ua.goit.service.retrofit.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class OrderService implements BaseService<Long, Order> {

    RetrofitClient retrofitClient = BaseConnect.getClient();

    @Override
    public Order createEntity(Order order) {
        return RetrofitConfig.execute(retrofitClient.addOrder(order));
    }

    @Override
    public Order updateEntity(Order order) {
        return null;
    }

    @Override
    public Order getEntity(Long id) {
        return RetrofitConfig.execute(retrofitClient.getOrderById(id));
    }

    @Override
    public ResponseBody deleteEntity(Long id) {
        return null;
    }

}

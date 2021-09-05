package ua.goit.repository;

import okhttp3.ResponseBody;
import ua.goit.model.Order;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class OrderRepository implements BaseRepository<Integer, Order>{

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
    public Order getEntity(Integer id) {
        return RetrofitConfig.execute(retrofitClient.getOrderById(id));
    }

    @Override
    public ResponseBody deleteEntity(Integer id) {
        return null;
    }

    @Override
    public void saveAll(Iterable itrbl) {

    }
}

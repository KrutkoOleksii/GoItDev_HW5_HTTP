package ua.goit.service.handler;

import okhttp3.ResponseBody;
import ua.goit.model.Order;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.OrderRepository;

public class HandlerStoreDelete extends HandlerMenu {

    public HandlerStoreDelete(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<Integer, Order> orderRepository = new OrderRepository();
        ResponseBody deletedOrder = orderRepository.deleteEntity(Integer.valueOf(command[3]));
        System.out.println("delete Order By Id:\n" + deletedOrder);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "delete".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
    }

}

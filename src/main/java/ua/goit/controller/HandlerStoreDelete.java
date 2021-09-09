package ua.goit.controller;

import okhttp3.ResponseBody;
import ua.goit.model.Order;
import ua.goit.service.BaseService;
import ua.goit.service.OrderService;

public class HandlerStoreDelete extends HandlerMenu {

    public HandlerStoreDelete(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseService<Long, Order> orderRepository = new OrderService();
        ResponseBody deletedOrder = orderRepository.deleteEntity(Long.valueOf(command[3]));
        System.out.println("delete Order By Id:\n" + deletedOrder);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==4) return "delete".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
        return false;
    }

}

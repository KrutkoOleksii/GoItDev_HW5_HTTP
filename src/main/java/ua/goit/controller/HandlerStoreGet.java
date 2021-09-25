package ua.goit.controller;

import ua.goit.model.Order;
import ua.goit.service.BaseService;
import ua.goit.service.OrderService;

public class HandlerStoreGet extends HandlerMenu {

    public HandlerStoreGet(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseService<Long, Order> orderRepository = new OrderService();
        Order orderById = orderRepository.getEntity(getLong(command[3]));
        System.out.println("get Order By Id '"+getLong(command[3])+"':\n" + orderById);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==4) return "get".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
        return false;
    }

}

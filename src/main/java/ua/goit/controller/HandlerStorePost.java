package ua.goit.controller;

import ua.goit.model.Order;
import ua.goit.service.BaseService;
import ua.goit.service.OrderService;

public class HandlerStorePost extends HandlerMenu {

    public HandlerStorePost(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseService<Long, Order> orderRepository = new OrderService();
        Order newOrder = orderRepository.createEntity(getOrderFromConsole());
        System.out.println("add Order:\n" + newOrder.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
        return false;
    }

}

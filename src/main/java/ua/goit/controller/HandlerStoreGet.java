package ua.goit.controller;

import ua.goit.model.Order;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.OrderRepository;

public class HandlerStoreGet extends HandlerMenu {

    public HandlerStoreGet(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<Long, Order> orderRepository = new OrderRepository();
        Order orderById = orderRepository.getEntity(Long.valueOf(command[3]));
        System.out.println("get Order By Id:\n" + orderById.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==4) return "get".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
        return false;
    }

}

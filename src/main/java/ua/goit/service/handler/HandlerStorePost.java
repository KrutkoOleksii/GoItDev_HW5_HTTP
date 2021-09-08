package ua.goit.service.handler;

import ua.goit.model.Order;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.OrderRepository;

public class HandlerStorePost extends HandlerMenu {

    public HandlerStorePost(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<Long, Order> orderRepository = new OrderRepository();
        Order newOrder = orderRepository.createEntity(getOrderFromConsole());
        System.out.println("add Order:\n" + newOrder.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
        return false;
    }

}

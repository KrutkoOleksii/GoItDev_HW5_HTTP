package ua.goit.controller;

import ua.goit.service.OrderService;

public class HandlerStoreGetInventory extends HandlerMenu {

    public HandlerStoreGetInventory(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        OrderService orderRepository = new OrderService();
        String inventory = orderRepository.getInventory();
        System.out.println("get Inventory:\n" + inventory);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "get".equals(command[0]) & "store".equals(command[1]) & "inventory".equals(command[2]);
        return false;
    }

}

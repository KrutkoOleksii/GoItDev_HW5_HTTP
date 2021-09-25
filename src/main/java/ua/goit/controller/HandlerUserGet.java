package ua.goit.controller;

import ua.goit.model.User;
import ua.goit.service.BaseService;
import ua.goit.service.UserService;

public class HandlerUserGet extends HandlerMenu {

    public HandlerUserGet(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseService<String, User> userRepository = new UserService();
        User getUser = userRepository.getEntity(command[2]);
        System.out.println("get User By User Name '" + command[2] + "':\n" + getUser);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "get".equals(command[0]) & "user".equals(command[1])
                & !"login".equals(command[2]) & !"logout".equals(command[2]);
        return false;
    }

}

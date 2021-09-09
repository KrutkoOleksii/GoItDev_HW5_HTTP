package ua.goit.controller;

import ua.goit.model.User;
import ua.goit.service.BaseService;
import ua.goit.service.UserService;

public class HandlerUserPut extends HandlerMenu {

    public HandlerUserPut(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseService<String, User> userRepository = new UserService();
        User newUser = userRepository.updateEntity(getUserFromConsole());
        System.out.println("update User By User Name:\n" + newUser.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "put".equals(command[0]) & "user".equals(command[1]);
        return false;
    }

}

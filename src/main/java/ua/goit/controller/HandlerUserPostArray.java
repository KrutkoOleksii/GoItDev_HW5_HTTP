package ua.goit.controller;

import ua.goit.model.User;
import ua.goit.service.UserService;

public class HandlerUserPostArray extends HandlerMenu {

    public HandlerUserPostArray(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        UserService userRepository = new UserService();
        User[] usersArray = {getUserFromConsole(), getUserFromConsole()};
        System.out.println("create User With Array:\n" + userRepository.createUserWithArray(usersArray));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "user".equals(command[1])
                & "createWithArray".equals(command[2]);
        return false;
    }

}

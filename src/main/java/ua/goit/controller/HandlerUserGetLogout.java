package ua.goit.controller;

import ua.goit.service.UserService;

public class HandlerUserGetLogout extends HandlerMenu {

    public HandlerUserGetLogout(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        UserService userRepository = new UserService();
        System.out.println("User logout:\n" + userRepository.userLogout());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "get".equals(command[0]) & "user".equals(command[1])
                & "logout".equals(command[2]);
        return false;
    }

}

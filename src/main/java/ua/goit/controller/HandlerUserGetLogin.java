package ua.goit.controller;

import ua.goit.service.UserService;

public class HandlerUserGetLogin extends HandlerMenu {

    public HandlerUserGetLogin(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("Enter Username:");
        String username = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();
        UserService userRepository = new UserService();
        System.out.println("User login:\n" + userRepository.userLogin(username,password));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "get".equals(command[0]) & "user".equals(command[1])
                & "login".equals(command[2]);
        return false;
    }
}

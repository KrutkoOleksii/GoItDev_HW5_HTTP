package ua.goit.controller;

import ua.goit.model.User;
import ua.goit.service.BaseService;
import ua.goit.service.UserService;

public class HandlerUserPost extends HandlerMenu {

    public HandlerUserPost(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseService<String, User> userRepository = new UserService();
        User user = userRepository.createEntity(getUserFromConsole());
        System.out.println("add User:\n" + user.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==2) return "post".equals(command[0]) & "user".equals(command[1]);
        return false;
    }

}

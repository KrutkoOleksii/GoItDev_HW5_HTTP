package ua.goit.controller;

import ua.goit.model.User;
import ua.goit.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class HandlerUserPostList extends HandlerMenu {

    public HandlerUserPostList(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        UserService userRepository = new UserService();
        List<User> users = new ArrayList();
        users.add(getUserFromConsole());
        users.add(getUserFromConsole());
        System.out.println("create User With List:\n" + userRepository.createUserWithList(users));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "user".equals(command[1])
                & "createWithList".equals(command[2]);
        return false;
    }

}

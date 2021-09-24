package ua.goit.controller;

import lombok.SneakyThrows;
import ua.goit.model.User;
import ua.goit.service.BaseService;
import ua.goit.service.UserService;

public class HandlerUserDelete extends HandlerMenu {

    public HandlerUserDelete(HandlerMenu handler){
        super(handler);
    }

    @SneakyThrows
    @Override
    protected void apply(String[] command) {
        BaseService<String, User> userRepository = new UserService();
        System.out.println("delete User By User Name:\n" + userRepository.deleteEntity(command[2]));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "delete".equals(command[0]) & "user".equals(command[1]);
        return false;
    }

}

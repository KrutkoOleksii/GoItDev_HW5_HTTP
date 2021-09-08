package ua.goit.service.handler;

import ua.goit.model.User;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.UserRepository;

public class HandlerUserGet extends HandlerMenu {

    public HandlerUserGet(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<String, User> userRepository = new UserRepository();
        User getUser = userRepository.getEntity(command[2]);
        System.out.println("get User By User Name:\n" + getUser);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "get".equals(command[0]) & "user".equals(command[1])
                & !"login".equals(command[2]) & !"logout".equals(command[2]);
        return false;
    }

}

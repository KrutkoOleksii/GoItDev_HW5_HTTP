package ua.goit.service.handler;

import ua.goit.model.BaseEntity;
import ua.goit.model.User;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.UserRepository;

public class HandlerUserPost extends HandlerMenu {

    public HandlerUserPost(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<String, User> userRepository = new UserRepository();
        BaseEntity responseUser = userRepository.createEntity(getUserFromConsole());
        System.out.println("add User:\n" + responseUser.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==2) return "post".equals(command[0]) & "user".equals(command[1]);
        return false;
    }

}

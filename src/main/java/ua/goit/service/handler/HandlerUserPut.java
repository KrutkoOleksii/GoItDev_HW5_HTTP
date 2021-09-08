package ua.goit.service.handler;

import ua.goit.model.User;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.UserRepository;

public class HandlerUserPut extends HandlerMenu {

    public HandlerUserPut(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<String, User> userRepository = new UserRepository();
        User newUser = userRepository.updateEntity(getUserFromConsole());
        System.out.println("update User By User Name:\n" + newUser.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "put".equals(command[0]) & "user".equals(command[1]);
        return false;
    }

}

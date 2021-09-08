package ua.goit.service.handler;

import retrofit2.Call;
import ua.goit.model.User;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class HandlerUserPostArray extends HandlerMenu {

    public HandlerUserPostArray(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        User[] usersArray = {getUserFromConsole(), getUserFromConsole()};

        RetrofitClient retrofitClient = BaseConnect.getClient();
        Call usersWithArray = retrofitClient.createUserWithArray(usersArray);
        Object execute = RetrofitConfig.execute(usersWithArray);
        System.out.println("create User With Array:\n" + execute.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return command.length==3 & "post".equals(command[0]) & "user".equals(command[1])
                & "createWithArray".equals(command[2]);
    }

}

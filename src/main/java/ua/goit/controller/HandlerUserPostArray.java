package ua.goit.controller;

import retrofit2.Call;
import ua.goit.model.User;
import ua.goit.service.retrofit.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

import java.util.List;

public class HandlerUserPostArray extends HandlerMenu {

    public HandlerUserPostArray(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        User[] usersArray = {getUserFromConsole(), getUserFromConsole()};
        RetrofitClient retrofitClient = BaseConnect.getClient();
        Call<List<User>> usersWithArray = retrofitClient.createUserWithArray(usersArray);
        List<User> userList = RetrofitConfig.execute(usersWithArray);
        System.out.println("create User With Array:\n" + userList.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "user".equals(command[1])
                & "createWithArray".equals(command[2]);
        return false;
    }

}

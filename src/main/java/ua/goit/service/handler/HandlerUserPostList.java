package ua.goit.service.handler;

import retrofit2.Call;
import ua.goit.model.User;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

public class HandlerUserPostList extends HandlerMenu {

    public HandlerUserPostList(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        List<User> users = new ArrayList();
        users.add(getUserFromConsole());
        users.add(getUserFromConsole());

        RetrofitClient retrofitClient = BaseConnect.getClient();
        Call userWithList = retrofitClient.createUserWithList(users);
        Object responseUserList = RetrofitConfig.execute(userWithList);
        System.out.println("11. create User With List:\n" + responseUserList);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "user".equals(command[1])
                & "createWithList".equals(command[2]);
        return false;
    }

}

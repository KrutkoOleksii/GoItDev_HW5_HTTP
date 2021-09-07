package ua.goit.service.handler;

import retrofit2.Call;
import ua.goit.model.User;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class HandlerUserGetLogout extends HandlerMenu {

    public HandlerUserGetLogout(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        RetrofitClient retrofitClient = BaseConnect.getClient();
        Call<User> managerLogout = retrofitClient.userLogout();
        User userLogout = RetrofitConfig.execute(managerLogout);
        System.out.println("User logout:\n" + userLogout.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "get".equals(command[0]) & "user".equals(command[1])
                & "logout".equals(command[2]);
    }

}

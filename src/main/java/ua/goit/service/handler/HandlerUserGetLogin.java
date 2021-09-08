package ua.goit.service.handler;

import retrofit2.Call;
import ua.goit.model.User;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class HandlerUserGetLogin extends HandlerMenu {

    public HandlerUserGetLogin(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        System.out.println("Enter Username:");
        String username = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();

        RetrofitClient retrofitClient = BaseConnect.getClient();
        Call<User> managerLogin = retrofitClient.userLogin(username, password);
        User userLogin = RetrofitConfig.execute(managerLogin);
        System.out.println("User login:\n" + userLogin.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "get".equals(command[0]) & "user".equals(command[1])
                & "login".equals(command[2]);
        return false;
    }
}

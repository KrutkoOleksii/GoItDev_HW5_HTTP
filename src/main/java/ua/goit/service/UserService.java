package ua.goit.service;

import retrofit2.Call;
import ua.goit.model.User;
import ua.goit.service.retrofit.RetrofitClientUser;
import ua.goit.util.BaseConnectUser;
import ua.goit.util.RetrofitConfig;

import java.util.List;

public class UserService implements BaseService<String, User> {

    RetrofitClientUser retrofitClient = BaseConnectUser.getClient();

    @Override
    public User createEntity(User user) {
        return RetrofitConfig.execute(retrofitClient.addEntity(user));
    }

    @Override
    public User updateEntity(User user) {
        return RetrofitConfig.execute(retrofitClient.updateUserByUserName(user, user.getId()));
    }

    @Override
    public User getEntity(String username) {
        return RetrofitConfig.execute(retrofitClient.getEntity(username));
    }

    @Override
    public User deleteEntity(String username) {
        return RetrofitConfig.execute(retrofitClient.deleteEntity(username));
    }

    public String userLogin(String username, String password) {
        Call<User> managerLogin = retrofitClient.userLogin(username, password);
        return RetrofitConfig.execute(managerLogin).toString();
    }

    public String userLogout() {
        Call<User> managerLogout = retrofitClient.userLogout();
        return RetrofitConfig.execute(managerLogout).toString();
    }

    public String createUserWithArray(User[] usersArray) {
        RetrofitClientUser retrofitClient = BaseConnectUser.getClient();
        Call<List<User>> usersWithArray = retrofitClient.createUserWithArray(usersArray);
        return RetrofitConfig.execute(usersWithArray).toString();
    }

    public String createUserWithList(List<User> users) {
        RetrofitClientUser retrofitClient = BaseConnectUser.getClient();
        Call<List<User>> userWithList = retrofitClient.createUserWithList(users);
        return RetrofitConfig.execute(userWithList).toString();
    }
}

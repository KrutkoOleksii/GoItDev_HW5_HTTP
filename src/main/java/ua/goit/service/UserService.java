package ua.goit.service;

import lombok.SneakyThrows;
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
    public String deleteEntity(String username) {
        return RetrofitConfig.execute(retrofitClient.deleteEntity(username)).toString();
    }

    @SneakyThrows
    public String userLogin(String username, String password) {
        return RetrofitConfig.execute(retrofitClient.userLogin(username, password)).toString();
    }

    @SneakyThrows
    public String userLogout() {
        return RetrofitConfig.execute(retrofitClient.userLogout()).toString();
    }

    public String createUserWithArray(User[] usersArray) {
        return RetrofitConfig.execute(retrofitClient.createUserWithArray(usersArray)).toString();
    }

    public String createUserWithList(List<User> users) {
        return RetrofitConfig.execute(retrofitClient.createUserWithList(users)).toString();
    }
}

package ua.goit.service;

import ua.goit.model.User;
import ua.goit.service.retrofit.RetrofitClientUser;
import ua.goit.util.BaseConnectUser;
import ua.goit.util.RetrofitConfig;

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

}

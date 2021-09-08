package ua.goit.repository;

import okhttp3.ResponseBody;
import ua.goit.model.User;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class UserRepository implements BaseRepository<String, User>{

    RetrofitClient retrofitClient = BaseConnect.getClient();

    @Override
    public User createEntity(User user) {
        return RetrofitConfig.execute(retrofitClient.addUser(user));
    }

    @Override
    public User updateEntity(User user) {
        return RetrofitConfig.execute(retrofitClient.updateUserByUserName(user, user.getId()));
    }

    @Override
    public User getEntity(String username) {
        return RetrofitConfig.execute(retrofitClient.getUserByUserName(username));
    }

    @Override
    public ResponseBody deleteEntity(String username) {
        return RetrofitConfig.execute(retrofitClient.deleteUserById(username));
    }

}

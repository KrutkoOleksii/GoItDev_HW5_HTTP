package ua.goit.repository;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import ua.goit.model.Pet;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class PetRepository implements BaseRepository<Integer, Pet>{

    RetrofitClient retrofitClient = BaseConnect.getClient();

    @Override
    public Pet createEntity(Pet pet) {
        return RetrofitConfig.execute(retrofitClient.addPet(pet));
    }

    @Override
    public Pet updateEntity(Pet pet) {
        return RetrofitConfig.execute(retrofitClient.updatePet(pet));
    }

    @Override
    public Pet getEntity(Integer id) {
        return RetrofitConfig.execute(retrofitClient.getPet(id));
    }

    @Override
    public ResponseBody deleteEntity(Integer id) {
        Call<ResponseBody> responseCall = retrofitClient.deletePetById(id);
        ResponseBody responseBody = RetrofitConfig.execute(responseCall);
        return responseBody;
    }

    @Override
    public void saveAll(Iterable itrbl) {

    }

    public ResponseBody getPetByStatus(String[] status){
        return RetrofitConfig.execute(retrofitClient.getPetByStatus(status));
    }

}

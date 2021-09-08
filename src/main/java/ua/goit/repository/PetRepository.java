package ua.goit.repository;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import ua.goit.model.Pet;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

import java.util.List;

public class PetRepository implements BaseRepository<Long, Pet>{

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
    public Pet getEntity(Long id) {
        return RetrofitConfig.execute(retrofitClient.getPet(id));
    }

    @Override
    public ResponseBody deleteEntity(Long id) {
        Call<ResponseBody> responseCall = retrofitClient.deletePetById(id);
        ResponseBody responseBody = RetrofitConfig.execute(responseCall);
        return responseBody;
    }

    @Override
    public void saveAll(Iterable itrbl) {

    }

    public List<Pet> getPetByStatus(String[] status){
        return RetrofitConfig.execute(retrofitClient.getPetByStatus(status));
    }

}

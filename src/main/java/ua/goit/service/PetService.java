package ua.goit.service;

import retrofit2.Call;
import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitClientPet;
import ua.goit.util.BaseConnectPet;
import ua.goit.util.RetrofitConfig;

import java.util.List;

public class PetService implements BaseService<Long, Pet> {

    RetrofitClientPet retrofitClient = BaseConnectPet.getClient();

    @Override
    public Pet createEntity(Pet pet) {
        return RetrofitConfig.execute(retrofitClient.addEntity(pet));
    }

    @Override
    public Pet updateEntity(Pet pet) {
        return RetrofitConfig.execute(retrofitClient.updateEntity(pet));
    }

    @Override
    public Pet getEntity(Long id) {
        return RetrofitConfig.execute(retrofitClient.getEntity(id));
    }

    @Override
    public Pet deleteEntity(Long id) {
        Call<Pet> responseCall = retrofitClient.deleteEntity(id);
        Pet pet = RetrofitConfig.execute(responseCall);
        return pet;
    }

    public List<Pet> getPetByStatus(String[] status){
        return RetrofitConfig.execute(retrofitClient.getPetByStatus(status));
    }

}

package ua.goit.service;

import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitClientPet;
import ua.goit.util.BaseConnectPet;
import ua.goit.util.RetrofitConfig;

import java.io.File;
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

    @SneakyThrows
    public String uploadPetImage(String[] command, String fileName, String additionalMetadata){
        File file = new File(fileName);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                "file",
                file.getName(),
                RequestBody.create(file, MediaType.parse("image/*")));
        MultipartBody.Part addMetadata = MultipartBody.Part.createFormData("additionalMetadata", additionalMetadata);
        Call<ResponseBody> uploadPetImage = retrofitClient.uploadPetImage(Long.valueOf(command[2]), filePart, addMetadata);
        return RetrofitConfig.execute(uploadPetImage).string();
    }

    @SneakyThrows
    public String updatePetById(String[] command, String namePet, String statusPet){
        Call<ResponseBody> call = retrofitClient.updatePetById(Long.valueOf(command[2]), namePet, statusPet);
        return RetrofitConfig.execute(call).string();
    }
}

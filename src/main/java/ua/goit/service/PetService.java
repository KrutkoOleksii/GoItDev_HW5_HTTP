package ua.goit.service;

import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import ua.goit.model.ApiResponse;
import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitClientPet;
import ua.goit.util.BaseConnectPet;
import ua.goit.util.RetrofitConfig;

import java.io.File;

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
    public String deleteEntity(Long id) {
        return RetrofitConfig.execute(retrofitClient.deleteEntity(id)).toString();
    }

    public String getPetByStatus(String[] status){
        return RetrofitConfig.execute(retrofitClient.getPetByStatus(status)).toString();
    }

    @SneakyThrows
    public String uploadPetImage(String[] command, String fileName, String additionalMetadata){
        File file = new File(fileName);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                "file",
                file.getName(),
                RequestBody.create(file, MediaType.parse("image/*")));
        MultipartBody.Part addMetadata = MultipartBody.Part.createFormData("additionalMetadata", additionalMetadata);
        Call<ApiResponse> uploadPetImage = retrofitClient.uploadPetImage(Long.valueOf(command[2]), filePart, addMetadata);
        return RetrofitConfig.execute(uploadPetImage).toString();
    }

    @SneakyThrows
    public String updatePetById(String[] command, String namePet, String statusPet){
        Call<ApiResponse> call = retrofitClient.updatePetById(Long.valueOf(command[2]), namePet, statusPet);
        return RetrofitConfig.execute(call).toString();
    }
}

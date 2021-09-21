package ua.goit.controller;

import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import ua.goit.service.retrofit.RetrofitClientPet;
import ua.goit.util.BaseConnectPet;
import ua.goit.util.RetrofitConfig;

import java.io.File;

public class HandlerPetPostUploadImage extends HandlerMenu {

    public HandlerPetPostUploadImage(HandlerMenu handler){
        super(handler);
    }

    @SneakyThrows
    @Override
    protected void apply(String[] command) {
        RetrofitClientPet retrofitClient = BaseConnectPet.getClient();
        System.out.println("enter the path of image with pet:");
        File file = new File(scanner.next());
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                "file",
                file.getName(),
                RequestBody.create(file,MediaType.parse("image/*")));
        //System.out.println("please enter additional metadata for image:");
        //MultipartBody.Part addMetadata = MultipartBody.Part.createFormData("additionalMetadata", scanner.next());
        //Call<ResponseBody> uploadPetImage = retrofitClient.uploadPetImage(Long.valueOf(command[2]), filePart, addMetadata);
        Call<ResponseBody> uploadPetImage = retrofitClient.uploadPetImage(Long.valueOf(command[2]), filePart);
        ResponseBody execute = RetrofitConfig.execute(uploadPetImage);
        System.out.println("Response Body: " + execute.string());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==4) return  "post".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

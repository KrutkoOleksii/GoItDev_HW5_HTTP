package ua.goit.controller;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import ua.goit.service.retrofit.RetrofitClientPet;
import ua.goit.service.retrofit.RetrofitClientUser;
import ua.goit.util.BaseConnectPet;
import ua.goit.util.BaseConnectUser;
import ua.goit.util.RetrofitConfig;

import java.io.File;

public class HandlerPetPostImage extends HandlerMenu {

    public HandlerPetPostImage(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
//        Reflections reflections = new Reflections("resources", new ResourcesScanner());
//        Set<String> resources = reflections.getResources(Pattern.compile(".*\\.ipg"));
//        RequestBody file = RequestBody.create(MediaType.parse("image"),new File("dog2.jpg"));
//        String addMetadata = "pet's image";
        RetrofitClientPet retrofitClient = BaseConnectPet.getClient();
        System.out.println("enter the path of image with pet");
        File file = new File(scanner.next());
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                "file",
                "dog1.jpg",
                RequestBody.create(MediaType.parse("file"), file));
        System.out.println("please enter additional metadata for image");
        MultipartBody.Part addMetadata = MultipartBody.Part.createFormData("additionalMetadata", scanner.next());
        ResponseBody execute = RetrofitConfig.execute(retrofitClient.uploadPetImage(Long.valueOf(command[2]), addMetadata, filePart));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==4) return  "post".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

package ua.goit.service.handler;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import ua.goit.model.Pet;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class HandlerPetPostFormdata extends HandlerMenu {

    public HandlerPetPostFormdata(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        RetrofitClient retrofitClient = BaseConnect.getClient();
        System.out.println("please enter name of pet:");
        RequestBody nameCat = RequestBody.create(MediaType.parse("string"), scanner.next());
        System.out.println("please enter pet status:");
        RequestBody status = RequestBody.create(MediaType.parse("string"), scanner.next());
        Call<Pet> petCall = retrofitClient.updatePetById(Long.valueOf(command[2]), nameCat, status);
        Pet petById = RetrofitConfig.execute(petCall);
        System.out.println("add Pet By Id:\n"+petById.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

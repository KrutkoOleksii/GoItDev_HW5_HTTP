package ua.goit.controller;

import retrofit2.Call;
import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitClientPet;
import ua.goit.util.BaseConnectPet;
import ua.goit.util.RetrofitConfig;

public class HandlerPetUpdateNameStatus extends HandlerMenu {

    public HandlerPetUpdateNameStatus(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        RetrofitClientPet retrofitClient = BaseConnectPet.getClient();
        System.out.println("please enter name of pet:");
        String namePet = scanner.next();
        System.out.println("please enter pet status:");
        String statusPet = scanner.next();
        Call<Pet> petCall = retrofitClient.updatePetById(Long.valueOf(command[2]), namePet, statusPet);
        Pet petById = RetrofitConfig.execute(petCall);
        System.out.println("update Pet By Id:\n"+petById.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

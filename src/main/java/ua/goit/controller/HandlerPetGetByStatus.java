package ua.goit.controller;

import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitClientPet;
import ua.goit.service.retrofit.RetrofitClientUser;
import ua.goit.util.BaseConnectPet;
import ua.goit.util.BaseConnectUser;
import ua.goit.util.RetrofitConfig;

import java.util.List;

public class HandlerPetGetByStatus extends HandlerMenu {

    public HandlerPetGetByStatus(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        System.out.println("please enter two status of pets (available, sold, etc.)");
        String[] status = {scanner.next(), scanner.next()};

        RetrofitClientPet retrofitClient = BaseConnectPet.getClient();
        List<Pet> response = RetrofitConfig.execute(retrofitClient.getPetByStatus(status));
        System.out.println("get Pet By Status:\n" + response.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return  "get".equals(command[0]) & "pet".equals(command[1]) & "findByStatus".equals(command[2]);
        return false;
    }

}

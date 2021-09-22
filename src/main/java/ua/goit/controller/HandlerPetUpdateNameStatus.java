package ua.goit.controller;

import lombok.SneakyThrows;
import ua.goit.service.PetService;

public class HandlerPetUpdateNameStatus extends HandlerMenu {

    public HandlerPetUpdateNameStatus(HandlerMenu handler){
        super(handler);
    }

    @SneakyThrows
    @Override
    protected void apply(String[] command) {
        PetService petService = new PetService();
        System.out.println("please enter name of pet:");
        String namePet = scanner.next();
        System.out.println("please enter pet status:");
        String statusPet = scanner.next();
        String response = petService.updatePetById(command, namePet, statusPet);
        System.out.println("update Pet By Id:\n"+response);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "post".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

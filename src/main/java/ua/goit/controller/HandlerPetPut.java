package ua.goit.controller;

import ua.goit.model.Pet;
import ua.goit.service.BaseService;
import ua.goit.service.PetService;

public class HandlerPetPut extends HandlerMenu {

    public HandlerPetPut(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseService<Long, Pet> petRepository = new PetService();
        Pet updatePet = petRepository.updateEntity(getPetFromConsole());
        System.out.println("update Pet:\n" + updatePet.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==2) return "put".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

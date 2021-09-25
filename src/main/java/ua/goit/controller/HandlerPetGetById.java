package ua.goit.controller;

import ua.goit.model.Pet;
import ua.goit.service.BaseService;
import ua.goit.service.PetService;

public class HandlerPetGetById extends HandlerMenu {

    public HandlerPetGetById(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseService<Long, Pet> petRepository = new PetService();
        Pet getPet = petRepository.getEntity(getLong(command[2]));
        System.out.println("get Pet By Id '" + getLong(command[2]) + "':\n" + getPet);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "get".equals(command[0]) & "pet".equals(command[1]) & !"findByStatus".equals(command[2]);
        return false;
    }

}

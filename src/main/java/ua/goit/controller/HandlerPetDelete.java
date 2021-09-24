package ua.goit.controller;

import lombok.SneakyThrows;
import ua.goit.model.Pet;
import ua.goit.service.BaseService;
import ua.goit.service.PetService;

public class HandlerPetDelete extends HandlerMenu {

    public HandlerPetDelete(HandlerMenu handler){
        super(handler);
    }

    @SneakyThrows
    @Override
    protected void apply(String[] command) {
        BaseService<Long, Pet> petService = new PetService();
        System.out.println("delete Pet By Id:\n" + petService.deleteEntity(Long.valueOf(command[2])));
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return  "delete".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

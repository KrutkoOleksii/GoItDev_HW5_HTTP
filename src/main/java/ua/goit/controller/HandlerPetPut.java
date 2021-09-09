package ua.goit.controller;

import ua.goit.model.Pet;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.PetRepository;

public class HandlerPetPut extends HandlerMenu {

    public HandlerPetPut(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<Long, Pet> petRepository = new PetRepository();
        Pet updatePet = petRepository.updateEntity(getPetFromConsole());
        System.out.println("update Pet:\n" + updatePet.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==2) return "post".equals(command[0]) & "put".equals(command[1]);
        return false;
    }

}

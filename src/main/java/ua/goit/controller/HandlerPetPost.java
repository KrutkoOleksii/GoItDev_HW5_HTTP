package ua.goit.controller;

import ua.goit.model.Pet;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.PetRepository;

public class HandlerPetPost extends HandlerMenu {

    public HandlerPetPost(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<Long, Pet> petRepository = new PetRepository();
        Pet newPet = petRepository.createEntity(getPetFromConsole());
        System.out.println("add Pet:\n" + newPet.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==2) return "post".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

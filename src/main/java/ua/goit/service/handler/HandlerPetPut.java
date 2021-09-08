package ua.goit.service.handler;

import ua.goit.model.Pet;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.PetRepository;

public class HandlerPetPut extends HandlerMenu {

    public HandlerPetPut(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<Integer, Pet> petRepository = new PetRepository();
        Pet updatePet = petRepository.updateEntity(getPetFromConsole());
        System.out.println("update Pet:\n" + updatePet.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return command.length==2 & "post".equals(command[0]) & "put".equals(command[1]);
    }

}

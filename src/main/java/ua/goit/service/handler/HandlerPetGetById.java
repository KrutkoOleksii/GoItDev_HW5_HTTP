package ua.goit.service.handler;

import ua.goit.model.Pet;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.PetRepository;

public class HandlerPetGetById extends HandlerMenu {

    public HandlerPetGetById(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<Integer, Pet> petRepository = new PetRepository();
        Pet getPet = petRepository.getEntity(Integer.valueOf(command[2]));
        System.out.println("get Pet By Id:\n" + getPet.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return command.length==3 & "get".equals(command[0]) & "pet".equals(command[1]);
    }

}

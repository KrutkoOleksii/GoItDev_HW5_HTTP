package ua.goit.service.handler;

import ua.goit.model.Pet;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.PetRepository;

public class HandlerPetPost extends HandlerMenu {

    public HandlerPetPost(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository<Integer, Pet> petRepository = new PetRepository();
        Pet newPet = petRepository.createEntity(getPetFromConsole());
//        Pet newPet = (Pet) petRepository.createEntity(
//                new Pet(1,
//                        new Category(1, "Cats"),
//                        "cat tom",
//                        new String[]{"http://pics.pets.ua/cat1.png", "http://pics.pets.ua/cat2.png"},
//                        new Tag[]{new Tag(1, "cat"), new Tag(2, "tom")},
//                        "available"
//                ));
        System.out.println("2. add Pet:\n" + newPet.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "post".equals(command[0]) & "pet".equals(command[1]) & command.length==2;
    }

}

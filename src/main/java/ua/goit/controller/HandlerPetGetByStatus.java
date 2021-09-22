package ua.goit.controller;

import ua.goit.service.PetService;

public class HandlerPetGetByStatus extends HandlerMenu {

    public HandlerPetGetByStatus(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("please enter two status of pets (available, sold, etc.)");
        String[] status = {scanner.next(), scanner.next()};
        PetService petService = new PetService();
        String petByStatus = petService.getPetByStatus(status);
        System.out.println("get Pet By Status:\n" + petByStatus);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return  "get".equals(command[0]) & "pet".equals(command[1]) & "findByStatus".equals(command[2]);
        return false;
    }

}

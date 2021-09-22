package ua.goit.controller;

import lombok.SneakyThrows;
import ua.goit.service.PetService;

public class HandlerPetPostUploadImage extends HandlerMenu {

    public HandlerPetPostUploadImage(HandlerMenu handler){
        super(handler);
    }

    @SneakyThrows
    @Override
    protected void apply(String[] command) {
        PetService petService = new PetService();
        System.out.println("enter the path of image with pet:");
        String fileName = scanner.next();
        System.out.println("please enter additional metadata for image:");
        String additionalMetadata = scanner.next();
        String responseBody = petService.uploadPetImage(command, fileName, additionalMetadata);
        System.out.println("Response Body: " + responseBody);
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==4) return  "post".equals(command[0]) & "pet".equals(command[1]);
        return false;
    }

}

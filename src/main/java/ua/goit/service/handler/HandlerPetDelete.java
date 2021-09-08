package ua.goit.service.handler;

import okhttp3.ResponseBody;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.PetRepository;

public class HandlerPetDelete extends HandlerMenu {

    public HandlerPetDelete(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        BaseRepository petRepository = new PetRepository();
        ResponseBody body = petRepository.deleteEntity(Long.valueOf(command[2]));
        System.out.println("delete Pet By Id:\n" + body.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return  "post".equals(command[0]) & "delete".equals(command[1]);
        return false;
    }

}

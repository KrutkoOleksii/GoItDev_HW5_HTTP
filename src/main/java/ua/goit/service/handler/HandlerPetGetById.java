package ua.goit.service.handler;

public class HandlerPetGetById extends HandlerMenu {

    public HandlerPetGetById(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "get".equals(command[0]) & "pet".equals(command[1]);
    }

}

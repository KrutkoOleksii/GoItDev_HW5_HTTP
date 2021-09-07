package ua.goit.service.handler;

public class HandlerPetDelete extends HandlerMenu {

    public HandlerPetDelete(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "post".equals(command[0]) & "delete".equals(command[1]);
    }

}

package ua.goit.service.handler;

public class HandlerPetPut extends HandlerMenu {

    public HandlerPetPut(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "post".equals(command[0]) & "put".equals(command[1]);
    }

}

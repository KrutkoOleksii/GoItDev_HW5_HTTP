package ua.goit.service.handler;

public class HandlerPetPostFormdata extends HandlerMenu {

    public HandlerPetPostFormdata(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return command.length==3 & "post".equals(command[0]) & "pet".equals(command[1]);
    }

}

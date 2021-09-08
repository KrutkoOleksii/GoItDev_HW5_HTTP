package ua.goit.service.handler;

public class HandlerPetPostImage extends HandlerMenu {

    public HandlerPetPostImage(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return command.length==4 & "post".equals(command[0]) & "pet".equals(command[1]);
    }

}

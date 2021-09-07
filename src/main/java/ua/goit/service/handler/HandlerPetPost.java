package ua.goit.service.handler;

public class HandlerPetPost extends HandlerMenu {

    public HandlerPetPost(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "post".equals(command[0]) & "pet".equals(command[1]) & command.length==2;
    }

}

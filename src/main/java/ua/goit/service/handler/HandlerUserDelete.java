package ua.goit.service.handler;

public class HandlerUserDelete extends HandlerMenu {

    public HandlerUserDelete(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "delete".equals(command[0]) & "user".equals(command[1]);
    }

}

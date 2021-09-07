package ua.goit.service.handler;

public class HandlerUserPut extends HandlerMenu {

    public HandlerUserPut(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "put".equals(command[0]) & "user".equals(command[1]);
    }

}

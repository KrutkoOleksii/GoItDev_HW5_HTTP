package ua.goit.service.handler;

public class HandlerUserPostArray extends HandlerMenu {

    public HandlerUserPostArray(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "post".equals(command[0]) & "user".equals(command[1])
                & "createWithArray".equals(command[2]);
    }

}

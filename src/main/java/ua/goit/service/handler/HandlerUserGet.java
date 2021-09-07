package ua.goit.service.handler;

public class HandlerUserGet extends HandlerMenu {

    public HandlerUserGet(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "get".equals(command[0]) & "user".equals(command[1])
                & !"login".equals(command[2]) & !"logout".equals(command[2]);
    }

}

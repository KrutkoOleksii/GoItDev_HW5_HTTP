package ua.goit.service.handler;

public class HandlerStoreGet extends HandlerMenu {

    public HandlerStoreGet(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "get".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
    }

}

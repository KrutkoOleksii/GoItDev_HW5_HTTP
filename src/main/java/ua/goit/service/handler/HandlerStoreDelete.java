package ua.goit.service.handler;

public class HandlerStoreDelete extends HandlerMenu {

    public HandlerStoreDelete(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "delete".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
    }

}

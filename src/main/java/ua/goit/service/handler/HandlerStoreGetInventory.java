package ua.goit.service.handler;

public class HandlerStoreGetInventory extends HandlerMenu {

    public HandlerStoreGetInventory(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "get".equals(command[0]) & "store".equals(command[1]) & "inventory".equals(command[2]);
    }

}

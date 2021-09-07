package ua.goit.service.handler;

public class HandlerStorePost extends HandlerMenu {

    public HandlerStorePost(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "post".equals(command[0]) & "store".equals(command[1]) & "order".equals(command[2]);
    }

}

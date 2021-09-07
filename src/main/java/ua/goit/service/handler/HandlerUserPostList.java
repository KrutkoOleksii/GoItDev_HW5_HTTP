package ua.goit.service.handler;

public class HandlerUserPostList extends HandlerMenu {

    public HandlerUserPostList(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "post".equals(command[0]) & "user".equals(command[1])
                & "createWithList".equals(command[2]);
    }

}

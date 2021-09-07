package ua.goit.service.handler;

public class HandlerException extends HandlerMenu{

    public HandlerException() {
        super(null);
    }

    @Override
    public void apply(String[] command) {
        throw new RuntimeException("Command '" + command + "' not found");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return true;
    }
}

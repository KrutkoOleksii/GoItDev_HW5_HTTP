package ua.goit.controller;

public class HandlerException extends HandlerMenu{

    public HandlerException() {
        super(null);
    }

    @Override
    public void apply(String[] command) {
        //throw new RuntimeException("Command '"+command[0]+"' for entity '"+command[1]+"' not found");
        System.out.println("Command '"+command[0]+"' for entity '"+command[1]+"' not found");
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return true;
    }
}

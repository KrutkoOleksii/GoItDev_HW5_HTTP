package ua.goit.service.handler;

import retrofit2.Call;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class HandlerStoreGetInventory extends HandlerMenu {

    public HandlerStoreGetInventory(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        RetrofitClient retrofitClient = BaseConnect.getClient();
        Call callInventory = retrofitClient.getInventory();
        Object inventory = RetrofitConfig.execute(callInventory);
        System.out.println("get Inventory:\n" + inventory.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return "get".equals(command[0]) & "store".equals(command[1]) & "inventory".equals(command[2]);
    }

}

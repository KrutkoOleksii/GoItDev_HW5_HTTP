package ua.goit.controller;

import retrofit2.Call;
import ua.goit.service.retrofit.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

import java.util.Map;

public class HandlerStoreGetInventory extends HandlerMenu {

    public HandlerStoreGetInventory(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        RetrofitClient retrofitClient = BaseConnect.getClient();
        Call<Map<String, Integer>> callInventory = retrofitClient.getInventory();
        Map<String,Integer> inventory = RetrofitConfig.execute(callInventory);
        System.out.println("get Inventory:\n" + inventory.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        if (command.length==3) return "get".equals(command[0]) & "store".equals(command[1]) & "inventory".equals(command[2]);
        return false;
    }

}

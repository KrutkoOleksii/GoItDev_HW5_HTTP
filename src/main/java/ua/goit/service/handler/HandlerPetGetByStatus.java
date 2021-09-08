package ua.goit.service.handler;

import okhttp3.ResponseBody;
import ua.goit.service.RetrofitClient;
import ua.goit.util.BaseConnect;
import ua.goit.util.RetrofitConfig;

public class HandlerPetGetByStatus extends HandlerMenu {

    public HandlerPetGetByStatus(HandlerMenu handler){
        super(handler);
    }

    @Override
    protected void apply(String[] command) {
        //TODO
        System.out.println("please enter two status of pets (available, sold, etc.)");
        String[] status = {scanner.next(), scanner.next()};

        RetrofitClient retrofitClient = BaseConnect.getClient();
        ResponseBody response = RetrofitConfig.execute(retrofitClient.getPetByStatus(status));
        System.out.println("get Pet By Status:\n" + response.toString());
    }

    @Override
    protected boolean isApplicable(String[] command) {
        return command.length==3 & "get".equals(command[0]) & "pet".equals(command[1]) & "findByStatus".equals(command[2]);
    }

}

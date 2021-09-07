package ua.goit;

public class MenuHandler {

    public void stringHandler(String[] command) {
        if (command.length<2){
            System.out.println("Bad command");
            return;
        }
        if ("pet".equals(command[1])){
            if ("get".equals(command[0])){
                if ("findByStatus".equals(command[2])){
                    Integer id = Integer.valueOf(command[2]);
                    //findByStatus
                } else {
                    Integer id = Integer.valueOf(command[2]);
                }
            } else if ("post".equals(command[0])){
                if (command.length==2){
                    // save(e);
                } else if (command.length==3){
                    // update a pet with formdata
                } if (command.length==4){
                    Integer id = Integer.valueOf(command[2]);
                    // upload Image
                }
            } else if ("put".equals(command[0])){
                // update
            } else if ("delete".equals(command[0])){
                Integer id = Integer.valueOf(command[2]);
                // delete
            }
        } else if ("store".equals(command[1])){
            if ("get".equals(command[0])){
                if (command.length==3){
                    // inventory
                } else if (command.length==3){
                    Integer id = Integer.valueOf(command[3]);
                    // get order by id
                }
            } else if ("post".equals(command[0])){
                // post
            } else if ("delete".equals(command[0])){
                Integer id = Integer.valueOf(command[2]);
                // delete
            }
        } else if ("user".equals(command[1])){
            if ("get".equals(command[0])){
                if ("login".equals(command[2])){
                    // login
                } else if ("logout".equals(command[2])){
                    //  logout
                } else {
                    String username = command[2];
                }
            } else if ("post".equals(command[0])){
                if ("createWithList".equals(command[2])){

                } else if ("createWithArray".equals(command[2])){

                }
            } else if ("put".equals(command[0])){
                String username = command[2];
                // update by username
            } else if ("delete".equals(command[0])){
                String username = command[2];
                // delete by username
            }
        }
    }
}

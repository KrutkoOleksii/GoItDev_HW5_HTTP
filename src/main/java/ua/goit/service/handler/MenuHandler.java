package ua.goit.service.handler;

import ua.goit.model.Category;
import ua.goit.model.Order;
import ua.goit.model.Pet;
import ua.goit.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {

    private final Scanner scanner = new Scanner(System.in);

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
                    Pet pet = getPetFromConsole();
                    // save(e);
                } else if (command.length==3){
                    // update a pet with formdata
                } else if (command.length==4){
                    Integer id = Integer.valueOf(command[2]);
                    // upload Image
                }
            } else if ("put".equals(command[0])){
                Pet pet = getPetFromConsole();
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
                Order order = getOrderFromConsole();
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
                    // logout
                } else {
                    String username = command[2];
                }
            } else if ("post".equals(command[0])){
                if ("createWithList".equals(command[2])){
                    List<User> users = new ArrayList<>();
                    users.add(getUserFromConsole());
                    users.add(getUserFromConsole());
                    //
                } else if ("createWithArray".equals(command[2])){
                    User[] users = {getUserFromConsole(), getUserFromConsole()};
                    //
                }
            } else if ("put".equals(command[0])){
                getUserFromConsole();
                String username = command[2];
                // update by username
            } else if ("delete".equals(command[0])){
                String username = command[2];
                // delete by username
            }
        }
    }

    private Pet getPetFromConsole() {
        System.out.println("enter the parameters of the new pet:\n" +
                "{id} | {name} | {status} | {category}\n" +
                "( e.g.  2 | Barbos | available | dogs )");
        String next = scanner.next();
        String[] split = next.split("\\|");
        return Pet.builder()
                .id(Integer.valueOf(split[0]))
                .name(split[1])
                .status(split[2])
                .category(new Category(11,split[3]))
                .build();
    }

    private Order getOrderFromConsole() {
        System.out.println("enter the parameters of the new order:\n" +
                "{id} | {petId} | {quantity} | {shipDate} | {status}| {complete}\n" +
                "( e.g.  2 | 1 | 30 | 2021-09-09 | placed | true )");
        String next = scanner.next();
        String[] split = next.split("\\|");
        return Order.builder()
                .id(Integer.valueOf(split[0]))
                .petId(Integer.valueOf(split[1]))
                .quantity(Integer.valueOf(split[2]))
                .shipDate(split[3])
                .status(split[4])
                .complete(Boolean.valueOf(split[5]))
                .build();
    }

    private User getUserFromConsole() {
        System.out.println("enter the parameters of the new user:\n" +
                "{id}|{username}|{firstName}|{LastName}|{email}|{password}|{phone}|{userStatus}\n" +
                "( e.g. 2|Admin|John|Dow|john.d@company.com|12345|+380117654321|1)");
        String next = scanner.next();
        String[] split = next.split("\\|");
        return User.builder()
                .id(Integer.valueOf(split[0]))
                .username(split[1])
                .firstName(split[2])
                .lastName(split[3])
                .email(split[4])
                .password(split[5])
                .phone(split[6])
                .userStatus(Integer.valueOf(split[7]))
                .build();
    }
}

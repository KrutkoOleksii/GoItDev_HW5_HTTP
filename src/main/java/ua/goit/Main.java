package ua.goit;

import ua.goit.service.handler.HandlerMenu;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main console = new Main();
        console = console.mainMenu(console);
        System.out.println("Application has been shut down");
        System.out.println("************************************");
    }

    private Main mainMenu(Main console) {
        String menuMain = new StringBuilder()
                .append("Select the entity (number):\n")
                .append("[1] Pet >>\n")
                .append("[2] Store >>\n")
                .append("[3] User >>\n")
                .append("[4] < EXIT >\n")
                .toString();
        int selection = 0;
        while (selection != 4) {
            System.out.println(menuMain);
            System.out.print("Insert selection: ");
            selection = scanner.nextInt();
            switch (selection) {
                case 1: return console.menuPet(console);
                case 2: return console.menuStore(console);
                case 3: return console.menuUser(console);
                case 4: return console;
                default:
                    System.out.println("The selection was invalid!");
            }
        }
        return console;
    }

    private Main menuPet(Main console) {
        String menuPet = new StringBuilder()
                .append("\n--- Menu PET ---\n")
                .append("Select the query and print it with the parameters:\n")
                .append("   post|pet|{petId}|uploadImage\n")
                .append("   post|pet\n")
                .append("   post|pet|{petId}\n")
                .append("   put|pet\n")
                .append("   get|pet|{petId}\n")
                .append("   get|pet|findByStatus\n")
                .append("   delete|pet|{petId}\n")
                .append("   exit")
                .toString();
        System.out.println(menuPet);
        String selection = "";
        while (!"exit".equals(selection)) {
            selection = scanner.next();
            String[] command = selection.split("\\|");
            if (command.length>1) HandlerMenu.of().handle(command);
            System.out.println(menuPet);
        }
        return console;
    }

    private Main menuStore(Main console) {
        String menuStore = new StringBuilder()
                .append("\n--- Menu STORE ---\n")
                .append("Select the query and print it with the parameters:\n")
                .append("   get|store|inventory\n")
                .append("   post|store|order\n")
                .append("   get|store|order|{orderId}\n")
                .append("   delete|store|order|{orderId}\n")
                .append("   exit")
                .toString();
        System.out.println(menuStore);
        String selection = "";
        while (!"exit".equals(selection)) {
            selection = scanner.next();
            String[] command = selection.split("\\|");
            if (command.length>1) HandlerMenu.of().handle(command);
            System.out.println(menuStore);
        }
        return console;
    }

    private Main menuUser(Main console) {
        String menuUser = new StringBuilder()
                .append("\n--- Menu USER ---\n")
                .append("Select the query and print it with the parameters:\n")
                .append("   post|user\n")
                .append("   post|user|createWithArray\n")
                .append("   post|user|createWithList\n")
                .append("   get|user|{username}\n")
                .append("   get|user|login\n")
                .append("   get|user|logout\n")
                .append("   put|user|{username}\n")
                .append("   delete|user|{username}\n")
                .append("   exit")
                .toString();
        System.out.println(menuUser);
        String selection = "";
        while (!"exit".equals(selection)) {
            selection = scanner.next();
            String[] command = selection.split("\\|");
            if (command.length>1) HandlerMenu.of().handle(command);
            System.out.println(menuUser);
        }
        return console;
    }

}

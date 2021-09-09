package ua.goit;

import ua.goit.service.MenuService;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuService console = new MenuService();
        console = console.mainMenu(console);
        System.out.println("Application has been shut down");
        System.out.println("************************************");
    }

}

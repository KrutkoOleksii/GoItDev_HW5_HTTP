package ua.goit;

import ua.goit.controller.MenuController;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuController console = new MenuController();
        console = console.mainMenu(console);
        System.out.println("Application has been shut down");
        System.out.println("************************************");
    }

}

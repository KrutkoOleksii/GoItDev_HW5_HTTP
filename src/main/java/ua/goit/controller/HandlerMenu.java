package ua.goit.controller;

import ua.goit.model.Category;
import ua.goit.model.Order;
import ua.goit.model.Pet;
import ua.goit.model.User;

import java.util.Scanner;

public abstract class HandlerMenu {

    protected final Scanner scanner = new Scanner(System.in);
    HandlerMenu handler;

    public HandlerMenu(HandlerMenu handler) {
        this.handler = handler;
    }

    protected abstract void apply(String[] command);

    protected abstract boolean isApplicable(String[] command);

    public final void handle(String[] command) {
        if (isApplicable(command)) apply(command);
        else handler.handle(command);
    }

    public static HandlerMenu of() {
        return new HandlerPetDelete(new HandlerPetGetById(new HandlerPetGetByStatus(
                new HandlerPetPost(new HandlerPetUpdateNameStatus(new HandlerPetPostUploadImage(
                new HandlerPetPut(new HandlerStoreDelete(new HandlerStoreGet(
                new HandlerStoreGetInventory(new HandlerStorePost(new HandlerUserDelete(
                new HandlerUserGet(new HandlerUserGetLogin(new HandlerUserGetLogout(
                new HandlerUserPostArray(new HandlerUserPostList(new HandlerUserPut(
                new HandlerUserPost(new HandlerException())))))))))))))))))));
    }

    protected Pet getPetFromConsole() {
        System.out.println("enter the parameters of the new pet:\n" +
                "{id}|{name}|{status}|{category}\n" +
                "( e.g.  2|Barbos|available|dogs)");
        String[] split = scanner.next().split("\\|");
        while (split.length < 4) {
            System.out.println("Parameters is not enough. Enter correct number of parameters - 4");
            split = scanner.next().split("\\|");
        }
        return Pet.builder()
                .id(Long.valueOf(split[0]))
                .name(split[1])
                .status(split[2])
                .category(new Category(0L,split[3]))
                .build();
    }

    protected Order getOrderFromConsole() {
        System.out.println("enter the parameters of the new order:\n" +
                "{id}|{petId}|{quantity}|{shipDate}|{status}|{complete}\n" +
                "( e.g.  2|1|30|2021-09-09|placed|true)");
        String[] split = scanner.next().split("\\|");
        while (split.length < 6) {
            System.out.println("Parameters is not enough. Enter correct number of parameters - 6");
            split = scanner.next().split("\\|");
        }
        return Order.builder()
                .id(Long.valueOf(split[0]))
                .petId(Long.valueOf(split[1]))
                .quantity(Integer.valueOf(split[2]))
                .shipDate(split[3])
                .status(split[4])
                .complete(Boolean.valueOf(split[5]))
                .build();
    }

    protected User getUserFromConsole() {
        System.out.println("enter the parameters of the new user:\n" +
                "{id}|{username}|{firstName}|{LastName}|{email}|{password}|{phone}|{userStatus}\n" +
                "( e.g. 2|Admin|John|Dow|john.d@company.com|12345|+380117654321|1)");
        String[] split = scanner.next().split("\\|");
        while (split.length < 8) {
            System.out.println("Parameters is not enough. Enter correct number of parameters - 8");
            split = scanner.next().split("\\|");
        }
        return User.builder()
                .id(Long.valueOf(split[0]))
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

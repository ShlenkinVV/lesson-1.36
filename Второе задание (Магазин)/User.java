package com.company;

import java.util.Scanner;

public class User {
    private String login, password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void authentication() {
        System.out.println("Введите логин: ");
        Scanner scanner = new Scanner(System.in);
        String log = scanner.nextLine();
        if (!(log.equals(login))) {
            System.out.println("Ошибка, неверный логин!");
            authentication();
            return;
        }
        System.out.println("Введите пароль: ");
        String passwd = scanner.nextLine();
        if (!(passwd.equals(password))) {
            System.out.println("Ошибка, неверный пароль!");
            authentication();
        } else System.out.println("Аутентификация прошла успешно\n");
    }

    ;
}

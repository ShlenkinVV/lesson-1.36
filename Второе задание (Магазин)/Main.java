package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;


public class Main {
    private static final String FILE_NAME = "D:\\basket.txt";
    public static void main(String[] args) {             //Пятое задание
        Clothes[] clothes = new Clothes[4];
        Clothes[] basket = new Clothes[100];
        clothes[0] = new Tshirt("Green", ClothingSize.XS, 950.0);
        clothes[1] = new Pants("Black", ClothingSize.L, 1500.0);
        clothes[2] = new Skirt("Red", ClothingSize.M, 800.0);
        clothes[3] = new Tie("Blue", ClothingSize.XXS, 560.0);
        User user1 = new User("Vladimir", "12345");
       // user1.authentication();
        boolean exit = false;
        int choiceOfCatalog=0;
        int choiceOfProduct=0;
        Operations state = Operations.MENU;
        Scanner scanner = new Scanner(System.in);
        while(!exit){

            switch (state) {
                case MENU:
                    System.out.println("============================================================\nМЕНЮ");
                    System.out.println("Выберите действие\n1.Просмотреть каталоги товаров\n2.Посмотреть корзину\n" +
                            "3.Оплатить товары в корзине\n4.Сохранить корзину\n5.Загрузить корзину\n6.Выход");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            state = Operations.LIST_CATALOG;
                            break;
                        case 2:
                            showBasket(basket);
                            break;
                        case 3:
                            state = Operations.BUY;
                            break;
                        case 4:
                            state = Operations.SAVE_BASKET;
                            break;
                        case 5:
                            state = Operations.LOAD_BASKET;
                            break;
                        case 6:
                            exit=true;
                            break;

                    }
                    break;
                case LIST_CATALOG:
                    System.out.println("============================================================");
                    showCatalog();
                    System.out.println("Введите номер каталога для просмотра или 0 для выхода в меню");
                    choiceOfCatalog = scanner.nextInt();
                    switch (choiceOfCatalog){
                        case 1,2,3:
                            state=Operations.LIST_PRODUCT;
                            break;
                        case 0:
                            state=Operations.MENU;
                            break;
                    }
                    break;
                case LIST_PRODUCT:
                    System.out.println("============================================================");
                    System.out.println("Введите номер вещи для добавления в корзину или 0 для выхода в меню");
                    switch (choiceOfCatalog) {
                        case 1:
                            showProduct(clothes, 1);
                            choiceOfProduct = scanner.nextInt();
                            int count = 0;
                            for (int i = 0; i <choiceOfProduct; count++)
                                if (clothes[count] instanceof MensClothing)
                                    i++;
                            count--;
                            add_2_basket(basket, clothes[count]);
                            state = Operations.MENU;
                            break;

                        case 2:
                            showProduct(clothes, 2);
                            choiceOfProduct = scanner.nextInt();
                            int count2 = 0;
                            for (int j = 0; j < choiceOfProduct; count2++)
                                if (clothes[count2] instanceof WomensClothing)
                                    j++;
                            count2--;
                            add_2_basket(basket, clothes[count2]);
                            state = Operations.MENU;
                            break;
                        case 3:
                            showProduct(clothes, 3);
                            choiceOfProduct = scanner.nextInt();
                            int k = choiceOfProduct - 1;
                            add_2_basket(basket, clothes[k]);
                            state = Operations.MENU;
                            break;
                    }
                    break;
                case BUY:
                    System.out.println("============================================================");
                    showBasket(basket);
                    System.out.println("\nОплатить?\n1.Да\n2.Нет");
                    int choiceOfPay = scanner.nextInt();
                    if (choiceOfPay == 1) {
                        System.out.println("Покупка успешно совершена");
                        Arrays.fill(basket, null);
                        state = Operations.MENU;
                    } else
                        state = Operations.MENU;
                    break;
                case SAVE_BASKET:

                    try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
                         ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);){
                        objectOutputStream.writeObject(basket);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    state=Operations.MENU;
                    break;
                case LOAD_BASKET:
                    Clothes[] bask = null;
                    try(FileInputStream inputStream = new FileInputStream(FILE_NAME);
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                        bask = (Clothes[]) objectInputStream.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    basket=bask;
                    state=Operations.MENU;
                    break;
            }

        }


    }
    public static void showCatalog(){
        System.out.println("1.Мужская одежда\n2.Женская одежда\n3.Все товары");
    }

    public static void showProduct(Clothes[] clothes, int choice){
        int count=0;
        switch(choice) {
            case 1:
                for (int i = 0; i<clothes.length; i++)
                    if (clothes[i] instanceof MensClothing) {
                        count++;
                        System.out.println(count +"."+clothes[i].name + " " + clothes[i].size + " " + clothes[i].color + " " + clothes[i].price);
                    }
                break;
            case 2:
                for (int i = 0; i<clothes.length; i++)
                    if (clothes[i] instanceof WomensClothing) {
                        count++;
                        System.out.println(count+"."+clothes[i].name + " " + clothes[i].size + " " + clothes[i].color + " " + clothes[i].price);
                    }
                break;
            case 3:
                for (int i = 0; i<clothes.length; i++)
                    System.out.println(i+1+"."+clothes[i].name + " " + clothes[i].size + " " + clothes[i].color + " " + clothes[i].price);
                break;
        }
    }

    public static void add_2_basket(Clothes[] basket, Clothes clothes){
        int i=0;
        while (basket[i] != null )
            i++;
        basket[i]=clothes;
        System.out.println("Вещь "+basket[i].name +" доюавлена в корзину");
    }

    public static void showBasket(Clothes[] basket){
        if (basket[0]==null) {
            System.out.println("Корзина пуста\n");
        } else {
            double sum = 0;
            int i = 0;
            while (basket[i] != null) {
                System.out.println(basket[i].name + " " + basket[i].size + " " + basket[i].color + " " + basket[i].price);
                sum += basket[i].price;
                i++;
            }
            System.out.println("Общая сумма товаров в корзине: " + sum);
        }

    }


}
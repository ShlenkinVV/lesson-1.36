package com.company;

import java.io.File;
import java.util.Date;

public class Main {                     //третье задание
    private static final String PATH = "src\\com\\company\\";
    public static void main(String[] args) {

        showInfo("Car");
        showInfo("Bus");
    }

    public static void showInfo(String name){
        File file = new File(PATH + name+ ".java");

        System.out.println("Имя: " + file.getName());
        System.out.println("Путь: " + file.getPath());
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Родительский каталог: " + file.getParent());
        System.out.println(file.canWrite() ? "Файл/каталог доступен для редактирования." : "Файл/каталог не доступен для редактирования.");
        System.out.println(file.canRead() ? "Файл/каталог доступен для чтения." : "Файл/каталог не доступен для чтения.");
        System.out.println((file.isDirectory() ? "Каталог." : "Не каталог."));
        System.out.println(file.isFile() ? "Файл." : "Не файл.");
        System.out.println("Дата последнего редактирования: " + new Date(file.lastModified()));
        System.out.println("Размер: " + file.length() + " байт.");

    }
}

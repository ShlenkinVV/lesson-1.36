package com.company;
import java.io.*;

class Animal implements Serializable {
    protected int weight, age;

    public Animal(int weight, int age){
        this.weight=weight;
        this.age=age;

    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }
}

class Horse extends Animal implements Serializable{
    private String breed;

    public Horse (int weight, int age, String breed){
        super(weight, age);
        this.breed=breed;
    }

    public String getBreed() {
        return breed;
    }

    public void showInfo(){
        System.out.println("Вес: " + weight + " Возраст: " + age + " Порода: " + breed);
    }
}



public class Main {
    private static final String FILE_NAME = "D:\\horse.txt";

    public static void main(String[] args) {
        //первое задание
        Horse horse = new Horse(100, 9, "Цирковая");
        serialize(horse);

        Horse horseClone = deserialize();

        horseClone.showInfo();


    }

    public static void serialize(Horse horse) {
        Horse serHorse = new Horse(horse.getWeight(), horse.getAge(), horse.getBreed());

        try ( FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
              ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);){
            objectOutputStream.writeObject(serHorse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Horse deserialize(){
        Horse horse = null;
        try (FileInputStream inputStream = new FileInputStream(FILE_NAME);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ) {

            horse = (Horse) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return horse;
    }
}



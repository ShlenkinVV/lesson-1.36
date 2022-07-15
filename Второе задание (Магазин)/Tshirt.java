package com.company;

public class Tshirt extends Clothes implements MensClothing, WomensClothing{

    public Tshirt(String color, ClothingSize size, double price){
        this.color=color;
        this.price=price;
        this.size = size;
        this.name = "Футболка";
    }

    @Override
    public String dressMan() {
        return "Мужчина одевает футболку";
    }

    @Override
    public String dressWoman() {
        return "Женщина одевает футболку";
    }
}

package com.company;

public class Pants extends Clothes implements MensClothing, WomensClothing{

    public Pants(String color, ClothingSize size, double price){
        this.color=color;
        this.price=price;
        this.size = size;
        this.name="Штаны";
    }

    @Override
    public String dressMan() {
        return "Мужчина одевает штаны";
    }

    @Override
    public String dressWoman() {
        return "Женщина одевает штаны";
    }
}
package com.company;

public class Tie extends Clothes implements MensClothing{

    public Tie(String color, ClothingSize size, double price){
        this.color=color;
        this.price=price;
        this.size = size;
        this.name = "Галстук";
    }

    @Override
    public String dressMan() {
        return "Мужчина одевает галстук";
    }
}

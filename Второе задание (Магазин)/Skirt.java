package com.company;

public class Skirt extends Clothes implements WomensClothing {

    public Skirt(String color, ClothingSize size, double price){
        this.color=color;
        this.price=price;
        this.size = size;
        this.name = "Юбка";
    }

    @Override
    public String dressWoman() {
        return "Женищна одевает юбку";
    }
}

package com.company;

import java.io.Serializable;

public abstract class Clothes implements Serializable {
    protected String color;
    protected double price;
    protected ClothingSize size;
    protected String name;
}

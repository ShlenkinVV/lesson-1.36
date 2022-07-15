package com.company;

public class Atelier {
    public static void dressMan(Clothes[] clothes) {
        for (Clothes c : clothes)
            if (c instanceof MensClothing) {
                System.out.println(((MensClothing) c).dressMan() + " " + c.size + " " + c.color + " " + c.price);
            }
    }

    public static void dressWoman(Clothes[] clothes) {
        for (Clothes c : clothes)
            if (c instanceof WomensClothing) {
                System.out.println(((WomensClothing) c).dressWoman() + " " + c.size + " " + c.color + " " + c.price);
            }
    }
}

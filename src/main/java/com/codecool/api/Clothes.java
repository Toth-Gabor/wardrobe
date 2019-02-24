package com.codecool.api;

public class Clothes {
    
    private static int num = 1;
    protected int id;
    private String color;
    private ClothesType clothesType;
    
    
    public Clothes(String color, ClothesType clothesType) {
        this.id = num;
        this.color = color;
        this.clothesType = clothesType;
        num++;
    }
    
    public int getId() {
        return id;
    }
    
    public String getColor() {
        return color;
    }
    
    public ClothesType getClothesType() {
        return clothesType;
    }
    
    @Override
    public String toString() {
        return  "id:" + id + ". " + color + " " + clothesType;
    }
}

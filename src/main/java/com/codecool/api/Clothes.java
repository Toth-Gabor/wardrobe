package com.codecool.api;

public class Clothes {
    
    private static int num = 1;
    protected int id;
    private String brand;
    private ClothesType clothesType;
    
    
    public Clothes(String brand, ClothesType clothesType) {
        this.id = num;
        this.brand = brand;
        this.clothesType = clothesType;
        num++;
    }
    
    public int getId() {
        return id;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public ClothesType getClothesType() {
        return clothesType;
    }
    
    @Override
    public String toString() {
        return clothesType + ", id: " + id + ". brand: " + brand;
    }
}

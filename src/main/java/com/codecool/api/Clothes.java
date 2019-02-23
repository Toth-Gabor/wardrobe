package com.codecool.api;

public abstract class Clothes {
    
    private int id;
    private String brand;
    private ClothesType clothesType;
    
    
    public Clothes(int id, String brand, ClothesType clothesType) {
        this.id = id;
        this.brand = brand;
        this.clothesType = clothesType;
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
        return "Clothes{" +
            "id=" + id +
            ", brand='" + brand + '\'' +
            ", clothesType=" + clothesType +
            '}';
    }
}

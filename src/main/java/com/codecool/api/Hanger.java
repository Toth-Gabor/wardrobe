package com.codecool.api;


public abstract class Hanger {
    
    private int id;
    
    public Hanger(int id) {
        this.id = id;
    }
    
    protected abstract void addClothes(Clothes clothes) throws HangerIsFullExeption, WrongClothesTypeException;
    
    protected abstract void removeClothes();
    
    protected abstract boolean isFull();
    
    protected abstract boolean isRightTypeClothes(Clothes clothes);
    
    public int getId() {
        return id;
    }
}

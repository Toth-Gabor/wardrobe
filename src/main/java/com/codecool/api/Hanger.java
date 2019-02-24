package com.codecool.api;


public abstract class Hanger {
    
    private static int num = 1;
    protected int id;
    
    public Hanger() {
        this.id = num;
        num++;
    }
    
    protected abstract void addClothes(Clothes clothes) throws HangerIsFullExeption, WrongClothesTypeException;
    
    protected abstract void removeClothes();
    
    protected abstract boolean isFull();
    
    protected abstract boolean isRightTypeClothes(Clothes clothes);
    
    public int getId() {
        return id;
    }
}

package com.codecool.api;

public class CombiHanger extends Hanger {
    
    public CombiHanger(int id) {
        super(id);
    }
    
    @Override
    protected void addClothes(Clothes clothes) throws HangerIsFullExeption, WrongClothesTypeException {
    
    }
    
    @Override
    protected void removeClothes() {
    
    }
    
    @Override
    protected boolean isFull() {
        return false;
    }
    
    @Override
    protected boolean isRightTypeClothes(Clothes clothes) {
        return false;
    }
}

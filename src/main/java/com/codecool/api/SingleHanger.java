package com.codecool.api;

public class SingleHanger extends Hanger {
    
    private Clothes clothes;
    
    
    @Override
    protected void addClothes(Clothes clothes) throws HangerIsFullException, WrongClothesTypeException {
        if (!isFull()){
            if (isRightTypeClothes(clothes)){
                this.clothes = clothes;
            } else {
                throw new WrongClothesTypeException("Wrong type of clothes!");
            }
        } else {
            throw new HangerIsFullException("This hanger is full!");
        }
    }
    
    @Override
    protected void removeClothes() {
        this.clothes = null;
    }
    
    @Override
    protected boolean isFull() {
        return this.clothes != null;
    }
    
    @Override
    protected boolean isRightTypeClothes(Clothes clothes) {
        return clothes.getClothesType().equals(ClothesType.SHIRT) || clothes.getClothesType().equals(ClothesType.BLOUSE);
    }
    
    public Clothes getClothes() {
        return clothes;
    }
    
    @Override
    public String toString() {
        if (clothes == null){
            return "SingleHanger id: " + id + "\n This hanger is empty!";
        } else {
            return "SingleHanger id: " + id + "\n Clothes: " + clothes;
    
        }
    }
}

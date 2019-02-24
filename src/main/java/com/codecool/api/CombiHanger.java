package com.codecool.api;

public class CombiHanger extends Hanger {
    
    private Clothes upper;
    private Clothes under;
    
    @Override
    protected void addClothes(Clothes clothes) throws HangerIsFullException {
        if (!isFull() && (clothes.getClothesType().equals(ClothesType.BLOUSE)
                        || clothes.getClothesType().equals(ClothesType.SHIRT))){
            this.upper = clothes;
            
        } else if(!isUnderFull() && (clothes.getClothesType().equals(ClothesType.TROUSERS)
                                    || clothes.getClothesType().equals(ClothesType.SKIRT))){
            this.under = clothes;
        } else {
            throw new HangerIsFullException("This hanger is full!");
        }
    }
    
    @Override
    protected void removeClothes() {
    
    }
    
    @Override
    protected boolean isFull() {
        return this.upper != null;
    }
    
    protected boolean isUnderFull(){
        return this.under != null;
    }
    
    @Override
    protected boolean isRightTypeClothes(Clothes clothes) {
        return false;
    }
    
    @Override
    public String toString() {
        String result = "";
        if (!isFull() && isUnderFull()){
            result = "CombiHanger id: " + id + "\n" + " upper: is empty!\n under: " + under;
        } else if (isFull() && !isUnderFull()){
            result = "CombiHanger id: " + id + "\n" + " upper: " + upper + "\n under: is empty!";
        } else if (!isFull() && !isUnderFull()){
            result =  "CombiHanger id: " + id + "\n" + " upper: is empty!\n under: is empty!";
        } else {
            result = "CombiHanger id: " + id + "\n" + " upper: " + upper + "\n under: " + under;
        }
        return result;
    }
}

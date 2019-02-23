package com.codecool.api;

public class SingleHanger extends Hanger {
    
    private Clothes clothes;
    
    public SingleHanger(int id) {
        super(id);
    }
    
    @Override
    protected void addClothes(Clothes clothes) throws HangerIsFullExeption, WrongClothesTypeException {
        if (!isFull()){
            if (isRightTypeClothes(clothes)){
                this.clothes = clothes;
            }
            throw new WrongClothesTypeException("Wrong type of clothes!");
        }
        throw new HangerIsFullExeption("This hanger is full!");
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
        return "SingleHanger{" +
            "clothes=" + clothes +
            "} " + super.toString();
    }
}

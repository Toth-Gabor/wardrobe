package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    
    private String name;
    private int addedNumOfHangers;
    private int hangarLimit;
    private List<Hanger> hangers;
    
    public Wardrobe(String name, int hangarLimit) {
        this.name = name;
        this.hangarLimit = hangarLimit;
        this.addedNumOfHangers = 0;
        this.hangers = new ArrayList<>();
    }
    public int getAddedNumOfHangers(){
        return addedNumOfHangers;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHangarLimit() {
        return hangarLimit;
    }
    
    public List<Hanger> getHangers() {
        return hangers;
    }
    
    public void addHanger(Hanger hanger) throws WardrobeIsFullException {
        if (!isFull()){
            this.hangers.add(hanger);
            this.addedNumOfHangers++;
        } else {
            throw new WardrobeIsFullException("No place for more hanger!");
        }
    }
    
    public void removeHanger(Hanger hanger){
        this.hangers.remove(hanger);
        this.addedNumOfHangers--;
    }
    
    public Hanger getHangerById(int id) throws NoSuchHangerException {
        for (Hanger hanger : this.hangers) {
            if (hanger.getId() == id){
                return hanger;
            }
        }
        throw new NoSuchHangerException("There are not any hanger with this id!");
    }
    
    public void addClothes(int id, Clothes clothes) throws NoSuchHangerException, HangerIsFullException, WrongClothesTypeException {
        getHangerById(id).addClothes(clothes);
    }
    
    public void removeClothes(int id){
    
    
    }
    
    public Clothes findClothesById(int id) throws NotSuchClothesException {
        for (Hanger hanger : hangers) {
            if (hanger instanceof SingleHanger){
                if (((SingleHanger) hanger).getClothes().getId() == id){
                    return ((SingleHanger) hanger).getClothes();
                }
            } else {
                if (((CombiHanger)hanger).getUpper().getId() == id){
                    return ((CombiHanger)hanger).getUpper();
                } else if (((CombiHanger)hanger).getUnder().getId() == id){
                    return ((CombiHanger)hanger).getUnder();
                    
                }
            }
        }
        throw new NotSuchClothesException("There are not any clothes with this id!");
    }
    
    public boolean isFull(){
        return this.hangers.size() == hangarLimit;
    }
    
    public boolean isEmpty(){
        return this.hangers.size() == 0;
    }
    
    @Override
    public String toString() {
        String wardrobe = name + " has " + addedNumOfHangers + " hangers\n";
        for (Hanger hanger : hangers) {
            wardrobe += " " + hanger + "\n";
        }
        return wardrobe;
    }
}

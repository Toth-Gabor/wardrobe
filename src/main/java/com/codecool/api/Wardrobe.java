package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    
    private String name;
    private int hangarLimit;
    private List<Hanger> hangers;
    
    public Wardrobe(String name, int hangarLimit) {
        this.name = name;
        this.hangarLimit = hangarLimit;
        this.hangers = new ArrayList<>();
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
    
    public void addHanger(Hanger hanger){
        if (!isFull()){
            this.hangers.add(hanger);
        }
    }
    
    public void removeHanger(Hanger hanger){
        this.hangers.remove(hanger);
    }
    
    public boolean isFull(){
        if (this.hangers.size() == hangarLimit){
            return true;
        } else {
            return false;
        }
    }
    
}

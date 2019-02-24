package com.codecool.cmdProg;

import com.codecool.api.*;

public class Main {
    
    public static void main(String[] args){
        //new CmdProgram(args).run();
    
        SingleHanger sh = new SingleHanger();
        System.out.println(sh.getId());
        SingleHanger sh2 = new SingleHanger();
        System.out.println(sh2.getId());
        CombiHanger ch = new CombiHanger();
        System.out.println(ch.getId());
    
        Clothes c = new Clothes("Red", ClothesType.SHIRT);
        Clothes c1 = new Clothes("Blue", ClothesType.TROUSERS);
        Wardrobe w = new Wardrobe("Wardrobe",3);
        try {
            w.addHanger(sh);
            w.addHanger(sh2);
            w.addHanger(ch);
        } catch (WardrobeIsFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            w.addClothes(3,c1);
            w.addClothes(3,c);
        } catch (NoSuchHangerException | HangerIsFullException | WrongClothesTypeException e) {
            System.out.println(e.getMessage());
    
        }
        try {
            System.out.println(w.getHangerById(3));
            System.out.println(w.getHangerById(1));
        } catch (NoSuchHangerException e) {
            System.out.println(e.getMessage());
        }
    
    }
}

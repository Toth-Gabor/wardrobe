package com.codecool.cmdProg;

import com.codecool.api.*;

import java.util.Scanner;

public class CmdProgram {
    
    private Wardrobe wardrobe;
    private Scanner scanner = new Scanner(System.in);
    private FileManager fm = new FileManager();
    
    public CmdProgram(String[] args) {
    
    }
    
    public void run() {
        String[] menuOptions = new String[]{"to create a new wardrobe.", "to enter the default wardobe", "to exit"};
        Menu menu = new Menu("Main menu", menuOptions);
        
        while (true) {
            menu.displayMenu();
            switch (scanner.nextLine()) {
                case "1":
                    createWardrobe();
                    wardrobeMenu();
                    break;
                case "2":
                    try {
                        defaultWardrobe();
                    } catch (WardrobeIsFullException e) {
                        System.out.println(e.getMessage());
                    }
                    wardrobeMenu();
                    break;
                case "3":
                    System.exit(0);
                    break;
            }
        }
    }
    
    private void createWardrobe() throws NumberFormatException {
        System.out.print("Give a name: ");
        String name = scanner.nextLine();
        System.out.print("Give the max number of hangers: ");
        int limit = Integer.parseInt(scanner.nextLine());
        wardrobe = new Wardrobe(name, limit);
    }
    
    private void defaultWardrobe() throws WardrobeIsFullException {
        wardrobe = new Wardrobe("Default", 10);
        for (int i = 0; i < 5; i++) {
            wardrobe.addHanger(new SingleHanger());
            wardrobe.addHanger(new CombiHanger());
        }
    }
    
    private void wardrobeMenu() {
        String[] menuOptions = new String[]{"to create a new hangers", "list all hangers",
            "add clothes", "to exit"};
        Menu menu = new Menu("Wardrobe menu", menuOptions);
        
        while (true) {
            menu.displayMenu();
            switch (scanner.nextLine()) {
                case "1":
                    try {
                        createHangers();
                    } catch (ToMuchHangerException | WardrobeIsFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        showAllHangers();
                    } catch (NoHangersException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        addClothes();
                    } catch (WardrobeIsEmptyExceptions | WrongClothesTypeException | NoSuchHangerException | HangerIsFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    System.exit(0);
                    break;
            }
        }
    }
    
    private void createHangers() throws ToMuchHangerException, NumberFormatException, WardrobeIsFullException {
        if ((wardrobe.getHangarLimit() - wardrobe.getAddedNumOfHangers()) == 0) {
            throw new WardrobeIsFullException("You can not add more hanger!");
        }
        System.out.println("The max hangers are: " + (wardrobe.getHangarLimit() - wardrobe.getAddedNumOfHangers()));
        System.out.print("How many hangars do you want to create? ");
        int num = Integer.parseInt(scanner.nextLine());
        if ((wardrobe.getHangers().size() + num) <= wardrobe.getHangarLimit()) {
            while (true) {
                System.out.print("What type of hanger do you want [single or combi]? ");
                String hangerType = scanner.nextLine();
                if (hangerType.toLowerCase().equals("single")) {
                    for (int i = 0; i < num; i++) {
                        wardrobe.addHanger(new SingleHanger());
                    }
                    break;
                } else if (hangerType.toLowerCase().equals("combi")) {
                    for (int i = 0; i < num; i++) {
                        wardrobe.addHanger(new CombiHanger());
                    }
                    break;
                }
            }
        } else {
            throw new ToMuchHangerException("You can not add more hanger than " +
                (wardrobe.getHangarLimit() - wardrobe.getAddedNumOfHangers()) + "!");
        }
    }
    
    private void showAllHangers() throws NoHangersException {
        if (!wardrobe.isEmpty()) {
            System.out.println(wardrobe);
        } else {
            throw new NoHangersException("Create hangers first!");
        }
    }
    
    private void addClothes() throws WardrobeIsEmptyExceptions, NumberFormatException, WrongClothesTypeException, NoSuchHangerException, HangerIsFullException {
        if (!wardrobe.isEmpty()) {
            System.out.print("Give a hanger id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Give a brand: ");
            String brand = scanner.nextLine();
            System.out.print("Give a type of clothes[SHIRT, BLOUSE, TROUSER, SKIRT]: ");
            switch (scanner.nextLine().toLowerCase()) {
                case "shirt":
                    wardrobe.addClothes(id, new Clothes(brand, ClothesType.SHIRT));
                    break;
                case "blouse":
                    wardrobe.addClothes(id, new Clothes(brand, ClothesType.BLOUSE));
                    break;
                case "trouser":
                    wardrobe.addClothes(id, new Clothes(brand, ClothesType.TROUSERS));
                    break;
                case "skirt":
                    wardrobe.addClothes(id, new Clothes(brand, ClothesType.SKIRT));
                    break;
            }
        } else {
            throw new WardrobeIsEmptyExceptions("Add hangers first!");
        }
        
    }
}

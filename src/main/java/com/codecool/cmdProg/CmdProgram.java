package com.codecool.cmdProg;

import com.codecool.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CmdProgram {
    
    private Scanner scanner = new Scanner(System.in);
    private FileManager fm = new FileManager();
    
    public CmdProgram(String[] args) {
    
    }
    
    public void run() {
        String[] menuOptions = new String[]{"to create a new plaza.", "to enter the default plaza", "to load saved plaza", "to exit"};
        Menu menu = new Menu("Plaza project", menuOptions);
        
        while (true) {
            menu.displayMenu();
            switch (scanner.nextLine()) {
                case "1":

                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                case "4":
                    System.exit(0);
                    break;
            }
        }
    }
}

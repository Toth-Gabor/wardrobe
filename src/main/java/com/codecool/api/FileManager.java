package com.codecool.api;

import java.io.*;

public class FileManager {
    
    public void fileWriter(Object o){
        try {
            FileOutputStream fileOut = new FileOutputStream("project.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in project.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public Object fileReader(){
        Object o = null;
        try {
            FileInputStream fileIn = new FileInputStream("project.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            o = (Object) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return o;
    }
}

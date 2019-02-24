package com.codecool.cmdProg;

import com.codecool.api.CombiHanger;
import com.codecool.api.SingleHanger;

public class Main {
    
    public static void main(String[] args){
        //new CmdProgram(args).run();
    
        SingleHanger sh = new SingleHanger();
        System.out.println(sh.getId());
        SingleHanger sh2 = new SingleHanger();
        System.out.println(sh2.getId());
        CombiHanger ch = new CombiHanger();
        System.out.println(ch.getId());
    }
}

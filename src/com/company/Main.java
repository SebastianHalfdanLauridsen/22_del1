package com.company;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static boolean testMode = false;

    public static final int playerOffset = 5;
    //something with playeroffset*playerID+dieRoll1
    //we be ded

    public static final int dieRoll1Col = 2;
    public static final int dieRoll2Col = 3;
    public static final int sumCol = 4;
    public static final int scoreCol = 5;

    public static void main(String[] args) {
        //maybe replace with scanner
        System.out.println("amount of player set to: " + args[0]);
        System.out.println("test program enabled: " + args[1]);
        System.out.println("testMode enabled " + args[2]);

        if(args[0] == null) {
            System.out.println("please run with amount of players specified");
            System.exit(0);
        }

        if(args[1].equals("Y")) {
            //run Test.methods()
        }

        if (args[2].equals("Y")) {
            testMode = true;
        }

    }
}

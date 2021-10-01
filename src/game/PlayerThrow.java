package game;

import java.lang.Math;
import java.util.ArrayList;
import main.Main;

public class PlayerThrow {
    //holds all die roll values
    private final ArrayList<Integer> m_dies = new ArrayList<>();
    private int m_sum;

    //class constructor defines variables/parameters and rolls dice
    public PlayerThrow() {
        roll();
    }

    //dummy throw class constructor and dummy rolls
    public PlayerThrow(boolean dummyThrow){
        dummyRoll();
    }

    //returns random int between min and max parameters
    private int random(int min, int max) {
        return (int) ((Math.random() * max) + min);
    }

    //rolls a random value to all dies in m_dies
    //https://www.youtube.com/watch?v=RYnFIRc0k6E
    private void roll() {
        //get die rolls with random and add to ArrayList
        for(int i = 0; i < Main.getM_diceAmount(); i++) {
            m_dies.add(random((Main.getM_diceSides() + 1) - Main.getM_diceSides(), Main.getM_diceSides()));
        }
        //add die rolls to m_sum
        for (int i = 0; i < m_dies.size(); i++) {
            m_sum += m_dies.get(i);
        }
    }

    //Pretends to throw dice, Adds 0 instead of rolling an actual dice
    private void dummyRoll(){
        for(int i = 0; i < Main.getM_diceAmount(); i++) {
            m_dies.add(0);
        }
        for (int i = 0; i < m_dies.size(); i++) {
            m_sum += m_dies.get(i);
        }
    }

    //get sum of die rolls
    public int getM_sum() {
        return m_sum;
    }

    //get die rolls
    public int getM_dies(int index) {
        return m_dies.get(index);
    }

    //returns true if all dies are equal to the first die.
    public boolean isPair() {
        for (int dies = 1; dies < m_dies.size(); dies++) {
            if (m_dies.get(0).equals( m_dies.get(dies) ) ) {
                return true;
            }
        }
        //System.out.println("pære?");
        return false;
    }
}
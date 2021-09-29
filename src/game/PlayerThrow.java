package game;

import java.lang.Math;
import java.util.ArrayList;


public class PlayerThrow {
    private int m_playerID;
    private ArrayList<Integer> m_die = new ArrayList<Integer>();
    private int m_sum;

    //class constructor defines variables/parameters and rolls dice
    public PlayerThrow(int playerID) {
        System.out.println("Instantiated PlayerThrow(" + playerID + ")");
        m_playerID = playerID;
        roll();
    }

    //random function
    private int random(int min, int max) {
        return (int) ((Math.random() * max) + min);
    }

    private void roll() {
        //get die rolls with random and add to ArrayList
        for(int i = 0; i < Game.m_game.getM_diceAmount(); i++) {
            m_die.add(random((Game.m_game.getM_diceSides() + 1) - Game.m_game.getM_diceSides(), Game.m_game.getM_diceSides()));
        }
        //add die rolls to m_sum
        for (int i = 0; i < m_die.size(); i++) {
            m_sum += m_die.get(i);
        }
    }

    //get playerID
    public int getM_playerID() {
        return m_playerID;
    }

    //get sum of die rolls
    public int getM_sum() {
        return m_sum;
    }

    //get die rolls
    public int getM_die(int index) {
        return m_die.get(index);
    }
}
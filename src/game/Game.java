package game;

import java.util.ArrayList;

public class Game {

    private int m_diceAmount = 2;
    private int m_diceSides = 6;
    private static int m_playerAmount = 4;
    private static final int m_winCond = 40;

    public static Game m_game; //i think this is illegal (public)
    private static ArrayList<Round> m_rounds = new ArrayList<>();

    public Game() {
        System.out.println("The game has started...");

    }

    public static void main(String[] args) {
        m_game = new Game();
        //run through rounds
        for (int currRound = 0; currRound < 1000; currRound++) {

            System.out.println();
            System.out.println("Round " + (currRound+1) + "!");

            Round round = new Round(getM_playerAmount());
            m_rounds.add(round);
            System.out.println("Current score:");
            for(int i = 0; i < m_playerAmount; i++) {
                System.out.println("Player " + (i+1) + ", " + round.getM_points(i) + " points.");
            }
        }
    }

    //returns the amount of dies
    public int getM_diceAmount() {
        //fetches m_diceAmount
        return m_diceAmount;
    }

    //returns the amount of die sides
    public int getM_diceSides() {
        //fetches m_diceSides
        return m_diceSides;
    }

    //returns the amount of players
    public static int getM_playerAmount() {
        //fetches m_playerAmount
        return m_playerAmount;
    }

    //returns the amount of points needed to win
    public static int getM_winCond() {
        return m_winCond;
    }

    //returns all rounds
    public Round getM_rounds(int index) {
        return m_rounds.get(index);
    }
}
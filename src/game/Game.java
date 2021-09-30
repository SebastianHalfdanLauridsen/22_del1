package game;

import java.util.ArrayList;

public class Game {

    private int m_diceAmount = 2;
    private int m_diceSides = 6;
    private static int m_playerAmount = 4;


    //should contain all rounds

    public static Game m_game; //i think this is illegal (public)
    private static ArrayList<Round> m_rounds = new ArrayList<>();

    public Game() {
        System.out.println("Game.Game(): instantiated Game");

    }

    public static void main(String[] args) {
        m_game = new Game();
        //run through rounds
        for (int currRound = 0; currRound < 1000; currRound++) {

            System.out.println();
            System.out.println("Game.main(): Current Round = " + currRound);

            Round round = new Round(getM_playerAmount());
            m_rounds.add(round);
            System.out.println("Game.main(): Points:");
            for(int i = 0; i < m_playerAmount; i++) {
                System.out.println("Game.main(): Player: " + i + ", points = " + round.getM_points(i));
            }
        }
    }


    public int getM_diceAmount() {
        return m_diceAmount;
    }

    public int getM_diceSides() {
        return m_diceSides;
    }

    public static int getM_playerAmount() {
        return m_playerAmount;
    }

    public static int getM_winCond() {
        return m_winCond;
    }

    public Round getM_rounds(int index) {
        return m_rounds.get(index);
    }
}
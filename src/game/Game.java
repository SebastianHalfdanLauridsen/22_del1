package game;

import java.util.ArrayList;
import main.Main;

public class Game {


    private final int m_winCond;
    private boolean m_win = false;
    //holds all Round instances
    private static final ArrayList<Round> m_rounds = new ArrayList<>();

    public Game(int winCond) {
        this.m_winCond = winCond;
    }

    public void play(int rounds) {

        //run through rounds
        for (int currRound = 0; currRound < rounds; currRound++) {

            System.out.println();
            System.out.println("Round " + (currRound+1) + "!");

            Round round = new Round(Main.getM_playerAmount());
            m_rounds.add(round);

            if (m_win) {
                return;
            }

            System.out.println("Current score:");
            for(int i = 0; i < Main.getM_playerAmount(); i++) {
                System.out.println("Player " + (i+1) + ", " + round.getM_points(i) + " points.");
            }

        }

    }



    //returns the amount of points needed to win
    public int getM_winCond() {
        return m_winCond;
    }

    //returns all rounds
    public Round getM_rounds(int index) {
        return m_rounds.get(index);
    }

    //sets m_win to bool
    public void setM_win(boolean bool) {
        m_win = bool;
    }

}
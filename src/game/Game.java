package game;

import java.util.ArrayList;

public class Game {

    private int m_diceAmount = 3;
    private int m_diceSides = 6;
    private static int m_playerAmount = 4;

    private static ArrayList<Integer> m_points = new ArrayList<>(m_playerAmount);
    //should contain all rounds

    public static Game m_game = new Game();


    public Game() {
        System.out.println("instantiated Game");

        while(m_points.size() < m_playerAmount) {
            m_points.add(0);
        }
    }

    public static void main(String[] args) {

        for(int i = 0; i < 1000; i++) {
            Round round = new Round(m_playerAmount);

            System.out.println("Points:");
            for(int j = 0; j < m_playerAmount; j++) {


                //Sets m_points array to old val + new sum

                m_points.set(j, (m_points.get(j) + round.getM_sum(j)));

                System.out.println("Player " + (j+1) + ": " + m_points.get(j));
            }

        }
    }

    public int getM_diceAmount() {
        return m_diceAmount;
    }

    public int getM_diceSides() {
        return m_diceSides;
    }

    public int getM_playerAmount() {
        return m_playerAmount;
    }
}
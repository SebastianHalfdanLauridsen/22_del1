package game;

import java.util.ArrayList;

public class Game {

    private int m_diceAmount = 2;
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
        int playerID = 0;
        int playerSkipID = 0;
        boolean skip = false;

        for(int currRound = 0; currRound < 1000; currRound++) {
            Round round = new Round(m_playerAmount);

            System.out.println("Points:");


            if(!skip) {
                System.out.println("ID restart");
                playerID = 0;
                playerSkipID = 0;
            } else {
                System.out.println("PLAYERID = PLAYERSKIPID");
                playerID = playerSkipID;
            }

            for(playerID = playerSkipID;playerID < m_playerAmount; playerID++) {

                System.out.println(playerID);

                //reset points for player if pair of 1's
                if (round.getPair(playerID) == 1) {
                    m_points.set(playerID, 0);
                } else {
                    //Sets m_points array to old val + new sum
                    m_points.set(playerID, (m_points.get(playerID) + round.getM_sum(playerID)));
                }
                System.out.println("Player " + (playerID + 1) + ": " + m_points.get(playerID));

                if (m_points.get(playerID) >= m_winCond) {
                    System.out.println("WINWINWIN for Player: " + (playerID + 1));
                    System.exit(0);
                }

                if(round.isPair(playerID)) {
                    System.out.println("pære for player: " + playerID );
                    skip = true;
                    playerSkipID = playerID;
                    break;
                }

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
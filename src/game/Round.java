package game;

import java.util.ArrayList;
import java.util.Scanner;

import static game.Game.m_game;

public class Round {

    Scanner scan = new Scanner(System.in);

    //holds all Player instances for this round
    private ArrayList<PlayerThrow> m_round = new ArrayList<>(); //need method for this
    private ArrayList<Integer> m_throwSums = new ArrayList<>();
    private ArrayList<Integer> m_pairs = new ArrayList<>();
    private ArrayList<Boolean> m_isPairs = new ArrayList<>();

    private ArrayList<Integer> m_points = new ArrayList<>(Game.getM_playerAmount()); //make method for accessing this
    private static int m_instances=0;

    public Round(int playerAmount) {
        System.out.println("Round.Round(): Instantiated Round(" + playerAmount + ")");
        m_instances++;
        while (m_points.size() < Game.getM_playerAmount()) {
            m_points.add(0);
        }

        for (int playerID = 0; playerID < playerAmount; playerID++) {

            throwDice(playerID);

            //Sets m_points array to old val + new sum unless it is the first round
            if(m_instances == 1) {
                m_points.set(playerID, getM_sum(playerID));
            } else {
                m_points.set(playerID, ( m_game.getM_rounds(m_instances-2).getM_points(playerID) + getM_sum(playerID) ));
            }

            //reset points if 2x1
            if(pairOfOnes(playerID)) {
                resetPoints(playerID);
            }


            System.out.println("Round.Round(): Player " + (playerID) + " has " + m_points.get(playerID) + " points");
            System.out.println();

            if (isWin(playerID)) {
                System.out.println("Round.Round(): WINWINWIN for Player: " + (playerID));
                System.exit(0);
            }
        }
    }

        public void throwDice (int playerID){

            System.out.println("Round.throwDice(): Press t for player: " + playerID + " to throw");

            String input = scan.nextLine();

            if (input.equals("t")) {
                PlayerThrow playerThrow = new PlayerThrow(playerID);
                m_round.add(playerThrow);

                for (int i = 0; i < m_game.getM_diceAmount(); i++) { //maybe rename int i
                    //Prints both throws, (maybe move?) maybe make own function? unless???
                    System.out.println("Round.throwDice(): Player: " + playerID
                            + " throw #" + (i + 1)
                            + " = " + playerThrow.getM_dies(i));
                }

                if (playerThrow.isPair()) {
                    m_pairs.add(playerThrow.getM_dies(0));
                    m_isPairs.add(true);
                } else {
                    m_pairs.add(0);
                    m_isPairs.add(false);
                }

                m_throwSums.add(playerThrow.getM_sum());
            }
        }

    public boolean isWin(int playerID) { //add if 2x6 in a row
        return m_points.get(playerID) >= Game.getM_winCond();
    }

    public boolean pairOfOnes(int playerID) {
        return getPair(playerID) == 1;
    }

    public void resetPoints(int playerID) {
        m_points.set(playerID, 0); //fix dis
    }

    public int getM_sum (int playerID){
        //returns arraylist of all sums to specified playerID
        return m_throwSums.get(playerID);
    }

    public int getPair (int playerID){
        return m_pairs.get(playerID);
    }

    public boolean isPair (int playerID){
        return m_isPairs.get(playerID);
    }

    public int getM_points(int index) {
        return m_points.get(index);
    }

    public PlayerThrow getM_round(int index) {
        return m_round.get(index);
    }
}
package game;

import java.util.ArrayList;
import java.util.Scanner;

import static game.Game.m_game;

public class Round {

    Scanner scan = new Scanner(System.in);

    //holds all Player instances for this round
    private ArrayList<PlayerThrow> m_round = new ArrayList<>(); //need method for this

    private ArrayList<Integer> m_points = new ArrayList<>(Game.getM_playerAmount()); //make method for accessing this
    private static int m_instances = 0;

    public Round(int playerAmount) {
        System.out.println("Round.Round(): Instantiated Round(" + playerAmount + ")");
        m_instances++;

        //throws dies for all players, adds points and determines isWin() and pairOfOnes()
        for (int playerID = 0; playerID < playerAmount; playerID++) {

            throwDies(playerID);

            //Sets m_points array to old val + new sum unless it is the first round
            if(m_instances == 1) {
                m_points.add(playerID, getM_round(playerID).getM_sum());
            } else {
                m_points.add(playerID, ( m_game.getM_rounds(m_instances-2).getM_points(playerID) + getM_round(playerID).getM_sum()));
                System.out.println("Round.Round() m_points.set(playerID, ( m_game.getM_rounds(m_instances-2).getM_points(playerID) + getM_sum(playerID) ))" +
                        "= " + m_points.get(playerID));
            }

            //Runs if playerID won
            if (isWin(playerID)) {
                System.out.println("Round.Round(): WINWINWIN for Player: " + (playerID));
                System.exit(0);
            }

            //reset points for playerID if pair of 1's
            if(pairOfOnes(getM_round(playerID))) {
                resetPoints(playerID);
            }

            System.out.println("Round.Round(): Player " + (playerID) + " has " + m_points.get(playerID) + " points");
            System.out.println();
        }
    }
        //throws dies for specified playerID
        private void throwDies(int playerID) {
            System.out.println("Player " + playerID + ", type t to throw...");
            String input = scan.nextLine();

            //runs while loop until input is t
            while(!input.equals("t")){
                System.out.println("You typed " + input + ", please type t");
                input = scan.nextLine();
            }

            //throws dies for player
            PlayerThrow playerThrow = new PlayerThrow(playerID);
            m_round.add(playerThrow);

            //prints all throws from player
            for (int i = 0; i < m_game.getM_diceAmount(); i++) { //maybe rename int i
                System.out.println("Round.throwDice(): Player: " + playerID
                        + " throw #" + (i + 1)
                        + " = " + playerThrow.getM_dies(i));
            }

        }

    public boolean isWin(int playerID) { //add if 2x6 in a row
        return m_points.get(playerID) >= Game.getM_winCond();
    }

    //returns true if there is a pair of 1's
    public boolean pairOfOnes(PlayerThrow playerThrow) {
        return playerThrow.isPair() && playerThrow.getM_dies(0) == 1;
    }

    public void resetPoints(int playerID) {
        m_points.set(playerID, 0);
        System.out.println("Player " + playerID + ", lost all their points!");
    }

    public int getM_sum (int playerID){
        //returns arraylist of all sums to specified playerID
        return m_throwSums.get(playerID);
    }

    //returns amount of points from specified player
    public int getM_points(int playerID) {
        return m_points.get(playerID);
    }

    public PlayerThrow getM_round(int index) {
        return m_round.get(index);
    }
}
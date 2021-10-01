package game;

import java.util.ArrayList;
import java.util.Scanner;
import test.Test;
import main.Main;

public class Round {

    Scanner scan = new Scanner(System.in);

    //holds all Player instances for this round
    private final ArrayList<PlayerThrow> m_round = new ArrayList<>(); //need method for this
    //holds all point instances for all players this round
    private final ArrayList<Integer> m_points = new ArrayList<>(Main.getM_playerAmount()); //make method for accessing this
    private static int m_instances = 0;

    public Round(int playerAmount) {
        //counts the amount of times the class has been instantiated
        m_instances++;

        //throws dies for all players, adds points and determines isWin() and pairOfOnes()
        for (int playerID = 0; playerID < playerAmount; playerID++) {

            throwDies(playerID);

            //Sets m_points array to old val + new sum unless it is the first round
            if (m_instances == 1) {
                m_points.add(playerID, getM_round(playerID).getM_sum());
            } else {
                m_points.add(playerID, (Main.getGame().getM_rounds(m_instances - 2).getM_points(playerID) + getM_round(playerID).getM_sum()));
            }

            //Runs if player won
            if (isWin(playerID)) {
                System.out.println();
                System.out.println("WINWINWIN for Player " + (playerID + 1) + "!");
                System.out.println("You won with " + getM_points(playerID) + " points!!!");

                System.out.println();
                System.out.println("Thanks for playing.");

                //Dummy throws for the remaining players
                for (int i = (playerID + 1); i < Main.getM_playerAmount(); i++) {
                    PlayerThrow playerThrow = new PlayerThrow(true);
                    m_round.add(playerThrow);
                }

                Main.game.setM_win(true);
                return;
            }

            //reset points for player if pair of 1's
            if (pairOfOnes(getM_round(playerID))) {
                resetPoints(playerID);
            }

            System.out.println("You now have " + m_points.get(playerID) + " points!");
            System.out.println();
        }
    }

    //throws dies for specified player
    private void throwDies(int playerID) {
        if (!(playerID == -1)) {
            System.out.println("----------------------------");
            System.out.println("Player " + (playerID + 1) + ", type t to throw...");
        }
        String input = "";
        if (!Test.isTestMode()) {
            input = scan.nextLine();
        }
        //runs while loop until input is t

        while (!input.equals("t") && !Test.isTestMode()) {
            System.out.println("You typed " + input + ", please type t...");
            input = scan.nextLine();
        }

        //throws dies for player
        PlayerThrow playerThrow = new PlayerThrow();
        m_round.add(playerThrow);

        //prints all throws from player
        if (!(playerID == -1)) {
            for (int i = 0; i < Main.getM_diceAmount(); i++) { //maybe rename int i
                System.out.println("Die " + (i + 1) + " landed on " + m_round.get(playerID).getM_dies(i) + ".");
            }
        }

    }

    //Check if player has won the game
    public boolean isWin(int playerID) { //add if 2x6 in a row
        return m_points.get(playerID) >= Main.game.getM_winCond();
    }

    //returns true if there is a pair of 1's
    public boolean pairOfOnes(PlayerThrow playerThrow) {
        return playerThrow.isPair() && playerThrow.getM_dies(0) == 1;
    }

    //resets points for player
    public void resetPoints(int playerID) {
        m_points.set(playerID, 0);
        System.out.println("Oh no, you lost all your points!");
    }

    //returns amount of points from specified player
    public int getM_points(int playerID) {
        return m_points.get(playerID);
    }

    //returns specified playerThrow
    public PlayerThrow getM_round(int playerID) {
        return m_round.get(playerID);
    }

    //returns all instances of Round
    public static int getM_instances() {
        return m_instances;
    }
}
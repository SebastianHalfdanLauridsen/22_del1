package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Round {

    Scanner scan = new Scanner(System.in);

    //holds all Player instances for this round
    private ArrayList<PlayerThrow> m_round = new ArrayList<>();
    private ArrayList<Integer> m_sums = new ArrayList<>();
    private ArrayList<Integer> m_pairs = new ArrayList<>();
    private ArrayList<Boolean> m_isPairs = new ArrayList<>();

    public Round(int playerAmount) {
        System.out.println("Instantiated Round(" + playerAmount + ")");
        for (int i = 0; i < playerAmount; i++) {
            throwDice(i);
            System.out.println();


            //System.out.println(m_players);

        }
    }

    public void throwDice(int playerID) {

        System.out.println("t for player: " + (playerID + 1) + " to throw");

        String input = scan.nextLine();

        if (input.equals("t")) {
            PlayerThrow playerThrow = new PlayerThrow(playerID);
            m_round.add(playerThrow);

            for (int i = 0; i < Game.m_game.getM_diceAmount(); i++) {
                //Prints both throws, (maybe move?) maybe make own function? unless???
                System.out.println("Player: " + (playerID + 1)
                        + " throw #" + (i + 1)
                        + " = " + playerThrow.getM_die(i));
            }

            if (playerThrow.isPair()) {
                m_pairs.add(playerThrow.getM_die(0));
                m_isPairs.add(true);
            } else {
                m_pairs.add(0);
                m_isPairs.add(false);
            }

                m_sums.add(playerThrow.getM_sum());
            }
        }

        public int getM_sum ( int playerID){
            //returns arraylist of all sums to specified playerID
            return m_sums.get(playerID);
        }

        public int getPair (int playerID){
            return m_pairs.get(playerID);
        }

        public boolean isPair(int playerID) {
            return m_isPairs.get(playerID);
        }

    }
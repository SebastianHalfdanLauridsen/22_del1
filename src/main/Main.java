package main;

import game.Game;
import game.Round;
import test.Test;

import java.util.ArrayList;

public class Main {

    private static final int m_diceAmount = 2;
    private static final int m_diceSides = 6;
    private static final int m_playerAmount = 4;

    public static Game game;
    public static Test test;

    public static void main(String[] args) {
        switch (Integer.parseInt(args[0])) {
            case 0:
                //standard run game
                game = new Game(40);
                game.play(Integer.MAX_VALUE);
                break;
            case 1: //run game for test 1000 rounds
                test = new Test();
                game = new Game(Integer.MAX_VALUE);
                game.play(1000);
                break;
            case 2: //runs the game and counts the amounts of sums
                test = new Test();
                game = new Game(40);
                game.play(Integer.MAX_VALUE);
                System.out.println();
                System.out.println("----------------------------");
                System.out.println("Sums:");

                ArrayList<Integer> sums = new ArrayList<>();
                ArrayList<Integer> sumAmount = new ArrayList<>();
                //Fills sumAmount with 0
                for(int i = 0; i <= 12; i++){
                    sumAmount.add(0);
                }
                for(int rounds = 0; rounds < Round.getM_instances(); rounds++) {
                    for (int players = 0; players < Main.getM_playerAmount(); players++) {
                        sums.add(game.getM_rounds(rounds).getM_round(players).getM_sum());
                        //Counts up 1 for the specified sum
                        int count = (sumAmount.get(game.getM_rounds(rounds).getM_round(players).getM_sum()) + 1);
                        sumAmount.set((game.getM_rounds(rounds).getM_round(players).getM_sum()), count);
                    }
                }

                for(int i = 0; i < sums.size(); i++) {
                    System.out.println(sums.get(i));
                }
                for(int i = 2; i < sumAmount.size(); i++) {
                    System.out.println("sumAmount for " + i + " is " + sumAmount.get(i));
                }
                System.out.println("----------------------------");
                System.out.println("Total sums = " + sums.size());
                break;
            case 3: //runs the game counts the amount of pairs
                test = new Test();
                game = new Game(40);
                game.play(Integer.MAX_VALUE);
                System.out.println();
                System.out.println("----------------------------");
                System.out.println("Pairs:");

                //holds all throws (true if pair, false if not)
                ArrayList<Boolean> pairs = new ArrayList<>();
                for(int rounds = 0; rounds < Round.getM_instances(); rounds++) {
                    for (int players = 0; players < Main.getM_playerAmount(); players++) {
                            //adds all throws, true if pair
                            pairs.add(game.getM_rounds(rounds).getM_round(players).isPair());

                    }
                }
                //removes all false values from pairs
                for(int i = 0; i < pairs.size(); i++) {
                    pairs.removeIf(pair -> !pair);
                }
                pairs.trimToSize();
                System.out.println(pairs.size());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Integer.parseInt(args[0]));
        }
    }

    //returns game instance
    public static Game getGame() {
        return game;
    }

    //returns the amount of dies
    public static int getM_diceAmount() {
        return m_diceAmount;
    }

    //returns the amount of die sides
    public static int getM_diceSides() {
        return m_diceSides;
    }

    //returns the amount of players
    public static int getM_playerAmount() {
        return m_playerAmount;
    }

}

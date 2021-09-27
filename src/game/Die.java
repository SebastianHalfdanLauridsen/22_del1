package game;

import java.lang.reflect.Array;

public class Die {

    public static Pair<Integer, Integer> getRoll(int[][] score, int playerID) {
        int roll1 = 0; int roll2 = 0;

        return new Pair<>(roll1, roll2);
    }

    public static int getScore(int[][] score, int playerID, int roll) {
        int score1 = 0;
        return score1;
    }

    private static void setDie(int random) {

    }

    private static void saveRoll(int[][] score) {

    }

    private static Pair<Integer, Boolean> checkWin(int[][] score) {
        int playerID = -1;
        boolean win = false;

        return new Pair<Integer, Boolean>(playerID, win);
    }

}

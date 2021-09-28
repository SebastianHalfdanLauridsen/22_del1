package game;

import com.company.Main;

public class Die {

    public static Pair<Integer, Integer> getRoll(int[][] score, int playerID) {
        int roll1 = 0; int roll2 = 0;

        return new Pair<>(roll1, roll2);
    }

    private static int random(int min, int max) {
        //returns random int between min and max
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void saveRoll(int[][] score) {

    }

    private static Pair<Integer, Boolean> checkWin(int[][] score) {
        int playerID = -1;
        boolean win = false;

        return new Pair<Integer, Boolean>(playerID, win);
    }

}

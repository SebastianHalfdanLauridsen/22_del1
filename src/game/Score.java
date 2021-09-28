package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.company.Main;

public class Score {

    public static List<int[]> scoreList = new ArrayList<int[]>();

    public static void resetScore(int[][] score, int playerID, int roll) {
        //resets the current player and current roll's score

        //score[roll][playerID*Main.playerOffset + Main.scoreCol] = 0;

        setScore(score, playerID, roll, Main.scoreCol, 0);

        if(Main.testMode) {
            System.out.println("ran resetScore on roll: "+ roll
                    + " and set " + Arrays.deepToString(score)
                    + " player: " + playerID
                    + " scoreCol, to 0");
            System.out.println();
        }
    }

    public static void setScore(int[][] score, int playerID, int roll, int col, int val) {
        int offsetCol = playerID*Main.playerOffset + col;
        score[roll][offsetCol] = val;
    }

    public static void skipTurn(int[][] score, int playerID, int roll) {
        //sets every other player's dieRoll1, dieRoll2 and sumCol to 0, to skip their turn.

        //score[roll][playerID*Main.playerOffset + Main.dieRoll1Col] = 0; //make a method for these
        //score[roll][playerID*Main.playerOffset + Main.dieRoll2Col] = 0;
        //score[roll][playerID*Main.playerOffset + Main.sumCol] = 0; //may be excluded

        setScore(score, playerID, roll, Main.dieRoll1Col, 0);
        setScore(score, playerID, roll, Main.dieRoll2Col, 0);
        setScore(score, playerID, roll, Main.sumCol, 0);

        if(Main.testMode) {
            System.out.println("ran skipTurn on roll: "+ roll
                    + " and set " + Arrays.deepToString(score)
                    + " player: " + playerID
                    + " dieRoll1, dieRoll2 and sumCol, to 0");
            System.out.println();
        }
    }
}

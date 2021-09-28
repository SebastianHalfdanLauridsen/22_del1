package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.company.Main;

public class Score {

    public static List<int[]> scoreList = new ArrayList<int[]>();

    public static void setArray(List<int[]> list, int playerID, int roll, int col, int val) {
        //sets the List array's player's specified index and roll to val
        int offsetCol = playerID*Main.playerOffset + col;
        //fetches array in roll index to list and saves in newArray
        int[] newArray = list.get(roll);

        //newArray is modified to the specified column
        newArray[offsetCol] = val;
        //newArray is pushed into the list and replaces the old array with the new array with the new val
        list.set(roll, newArray);

        if(Main.testMode) {
            System.out.println("ran setArray on roll: " + roll
                    + " and set " + Arrays.toString(newArray)
                    + " player: " + playerID
                    + " column: " + col + ", to " + val);
            System.out.println();
        }
    }

    public static void addArray(List<int[]> list, int roll) {
        //adds a new array to the list and sets the playerID for the specified playerAmount
        //total rows in new array
        int totalCol = Main.playerAmount*Main.playerOffset;

        //initializes the to be added array
        int[] newArray = new int[totalCol];
        //fills the array with -1 in every row (for debugging)
        Arrays.fill(newArray, -1);

        //sets all the playerIDs in the correct rows
        for (int i=0; i<Main.playerAmount; i++) {
            newArray[i*Main.playerOffset] = i;
        }

        //adds the new array to the list
        list.add(roll, newArray);

        if(Main.testMode) {
            System.out.println("ran addArray on roll: " + roll
                    + " and inserted " + Arrays.toString(newArray));
            System.out.println();
        }
    }

    public static int getArray(List<int[]> array, int playerID, int roll, int col) {
        //fetches the array's player's specified roll and column
        int offsetCol = playerID*Main.playerOffset + col;
        return array.get(roll)[offsetCol];
    }


    public static int getScore(List<int[]> array, int playerID, int roll) {
        //fetches the score from list to the specified player and roll
        return getArray(array, playerID, roll, playerID*Main.playerOffset + Main.scoreCol);
    }

    public static void resetScore(List<int[]> array, int playerID, int roll) {
        //resets the current player and current roll's score

        setArray(array, playerID, roll, Main.scoreCol, 0);

        if(Main.testMode) {
            System.out.println("ran resetScore on roll: "+ roll
                    + " and set " + array //change this
                    + " player: " + playerID
                    + " scoreCol, to 0");
            System.out.println();
        }
    }

    public static void skipTurn(List<int[]> array, int playerID, int roll) {
        //sets every other player's dieRoll1, dieRoll2 and sumCol to 0, to skip their turn.

        //score[roll][playerID*Main.playerOffset + Main.dieRoll1Col] = 0; //make a method for these
        //score[roll][playerID*Main.playerOffset + Main.dieRoll2Col] = 0;
        //score[roll][playerID*Main.playerOffset + Main.sumCol] = 0; //may be excluded

        setArray(array, playerID, roll, Main.dieRoll1Col, 0);
        setArray(array, playerID, roll, Main.dieRoll2Col, 0);
        setArray(array, playerID, roll, Main.sumCol, 0);

        if(Main.testMode) {
            System.out.println("ran skipTurn on roll: "+ roll
                    + " and set " + array //change this as well
                    + " player: " + playerID
                    + " dieRoll1, dieRoll2 and sumCol, to 0");
            System.out.println();
        }
    }
}

package interview.amz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by caitsithx on 14-4-21.
 */
public class MMChess {
    static BufferedReader in = new BufferedReader(new InputStreamReader(
        System.in));
    private MMResult max = null;
    private HashMap<String, Boolean> stepsLog = new HashMap<String, Boolean>();
    //statistic info
    private int playCount = 0;
    private int loopCount = 0;

    public static void main(String[] args) throws IOException {
        int[] grids = null;
        int[] cards = null;
        String line1 = in.readLine();
        String[] line1s = line1.split(" ");
        grids = new int[Integer.parseInt(line1s[0]) + 1];
        cards = new int[Integer.parseInt(line1s[1])];

        //start line
        grids[0] = 0;
        for (int i = 1; i < grids.length; i++) {
            grids[i] = in.read() - (int) 0x30;
        }

        in.read();

        for (int i = 0; i < cards.length; i++) {
            cards[i] = in.read() - (int) 0x30;
        }

        MMChess mmChess = new MMChess();
        mmChess.play(grids, cards);
        System.out.println(mmChess.max);
    }

    private static int[] remainCards(int[] cards, int index) {
        int[] remainCards = new int[cards.length - 1];

        if (index > 0) {
            System.arraycopy(cards, 0, remainCards, 0, index);
        }

        if (cards.length - index - 1 > 0) {
            System.arraycopy(cards, index + 1, remainCards, index, cards.length - index - 1);
        }

        return remainCards;
    }

    private static int remainScores(int[] grids, int i) {
        int scores = 0;
        for (int j = i; j < grids.length; j++) {
            scores += grids[j];
        }
        return scores;
    }

    protected MMResult play(int[] grids, int[] cards) {
        MMResult subResult = new MMResult();
        max = null;

        play(grids, subResult, cards);

        System.out.println(
            String.format("plays:%s", playCount));

        System.out.println(
            String.format("loops:%s", loopCount));

        return max;
    }

    protected void play(int[] grids, MMResult result, int[] cards) {
        playCount++;

        for (int i = 0; i < cards.length; i++) {
            int newCard = cards[i];

            LinkedList<Integer> steps = new LinkedList<Integer>();
            steps.addAll(result.currentSteps);
            steps.add(newCard);
            String stepStr = Arrays.toString(steps.toArray());
            if (stepsLog.containsKey(stepStr)) {
                continue;
            } else {
                stepsLog.put(stepStr, true);
            }

            loopCount++;

            int newPos = result.pos + newCard;
            if (newPos < grids.length) {
                MMResult newResult = new MMResult();
                newResult.pos = newPos;
                newResult.score = result.score + grids[newPos];
                newResult.currentSteps.addAll(steps);

                if (max == null || newResult.score > max.score) {
                    max = newResult;
                }

                if (cards.length > 1) {
                    if (max == newResult || newResult.score + remainScores(grids, newPos) > max.score) {
                        int[] remainCards = remainCards(cards, i);

                        play(grids, newResult, remainCards);
                    }
                }

            } else {
                if (max == null || result.score > max.score) {
                       /*
                       MMResult newResult = new MMResult();
                       newResult.pos = newPos;
                       newResult.score = newScore;
                       newResult.currentSteps.addAll(result.currentSteps);
                       newResult.currentSteps.add(firstCard);
                       */

                    max = result;
                }
            }

        }

    }
}

class MMResult {
    int pos = 0;
    int score;
    LinkedList<Integer> currentSteps = new LinkedList<Integer>();

    public String toString() {
        return String.format("pos:%1s,score:%2s", pos, score)
            + "\n" +
            Arrays.toString(
                currentSteps.toArray());
    }
}

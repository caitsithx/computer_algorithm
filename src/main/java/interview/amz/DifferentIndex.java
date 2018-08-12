package interview.amz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by caitsithx on 14-4-21.
 */
public class DifferentIndex {
    static BufferedReader in = new BufferedReader(new InputStreamReader(
        System.in));
    protected ArrayList<ActionList> min = new ArrayList<ActionList>();

    public static void main(String[] args) throws IOException {
        String[] phrase1 = in.readLine().split("\\s");
        String[] phrase2 = in.readLine().split("\\s");

        DifferentIndex di = new DifferentIndex();
        di.diffIndex(phrase1, phrase2);

        System.out.print(di.min.get(0).actionCount);
    }

    public void diffIndex(String[] phrase1, String[] phrase2) {
        diffIndex(phrase1, phrase2, new ActionList());
        diffIndex(phrase2, phrase1, new ActionList());

        for (ActionList actionList : min) {
            System.out.println(Arrays.toString(actionList.innerList.toArray()));
        }
    }

    private void diffIndex(String[] phrase1, String[] phrase2, ActionList actionList) {
        //phrase1 is empty
        if (phrase1.length == 0) {
            ActionList finalActionList = null;
            //still remaining words in phrase2, insert them
            if (phrase2.length > 0) {
                finalActionList = new ActionList();
                finalActionList.addAll(actionList);
                for (int i = 0; i < phrase2.length; i++) {
                    finalActionList.add("i");
                }
            }
            //no remaining words in phrase2, done
            else {
                finalActionList = actionList;
                //do nothing
            }

            //we are done. let's count the minimum index so far.
            if (min.size() == 0) {
                min.add(finalActionList);
            } else {
                if (min.get(0).actionCount > finalActionList.actionCount) {
                    min.clear();
                    min.add(finalActionList);
                } else if (min.get(0).actionCount == finalActionList.actionCount) {
                    min.add(finalActionList);
                }
            }
            return;
        }
        //failed
        else if (phrase2.length == 0) {
            return;
        }

        if (phrase1[0].equals(phrase2[0])) {
            String[] phrase11 = new String[phrase1.length - 1];
            System.arraycopy(phrase1, 1, phrase11, 0, phrase11.length);
            String[] phrase21 = new String[phrase2.length - 1];
            System.arraycopy(phrase2, 1, phrase21, 0, phrase21.length);

            ActionList newActionList = new ActionList();
            newActionList.addAll(actionList);
            newActionList.add("-");
            diffIndex(phrase11, phrase21, newActionList);
        } else {
            String[] phrase2x = new String[phrase2.length - 1];
            System.arraycopy(phrase2, 1, phrase2x, 0, phrase2x.length);

            // try s/i/d on phrase1
            //substitute
            String[] phrase12 = new String[phrase1.length - 1];
            System.arraycopy(phrase1, 1, phrase12, 0, phrase12.length);

            ActionList newActionList = new ActionList();
            newActionList.addAll(actionList);
            newActionList.add("s");
            diffIndex(phrase12, phrase2x, newActionList);

            //insert
            String[] phrase13 = new String[phrase1.length + 1];
            System.arraycopy(phrase1, 0, phrase13, 1, phrase1.length);
            phrase13[0] = phrase2[0];
            newActionList = new ActionList();
            newActionList.addAll(actionList);
            newActionList.add("i");
            diffIndex(phrase13, phrase2x, newActionList);

            //delete
            String[] phrase14 = new String[phrase1.length - 1];
            System.arraycopy(phrase1, 1, phrase14, 0, phrase14.length);
            newActionList = new ActionList();
            newActionList.addAll(actionList);
            newActionList.add("d");
            diffIndex(phrase14, phrase2, newActionList);
        }
    }

    class ActionList {
        ArrayList<String> innerList = new ArrayList<String>();
        int actionCount;

        public void add(String action) {
            innerList.add(action);
            if (!action.equals("-")) {
                actionCount++;
            }
        }

        public void addAll(ActionList actionList) {
            innerList.addAll(actionList.innerList);
            actionCount += actionList.actionCount;
        }
    }

    /*
        private static int diffIndex(String[] phrase1, String[] phrase2, int i) {
        //skip the same word to the left
        String word1 = i < phrase1.length ? phrase1[i] : null;
        String word2 = i < phrase2.length ? phrase2[i] : null;
        while(i < phrase1.length &&  i < phrase2.length && word2.equals(word1)) {
            i ++;
            word1 = i < phrase1.length ? phrase1[i] : null;
            word2 = i < phrase2.length ? phrase2[i] : null;
        }

        //if at the end of phrase2, stop and calculate the words to be deleted from phrase1.
        if(i == phrase1.length || i == phrase2.length) {
            return phrase1.length - phrase2.length;
        }

        int diffIndex = 0;

        //for each different word, try s/i/d
        //substitute
        String[] phrase11 = new String[phrase1.length];
        System.arraycopy(phrase1, 0, phrase11, 0, phrase1.length);
        phrase11[i] = word2;
        diffIndex ++;
        int diffIndexs1 = diffIndex + diffIndex(phrase11, phrase2, i+1);

        //insert
        String[] phrase12 = new String[phrase1.length + 1];
        System.arraycopy(phrase1, 0, phrase11, 0, i);
        phrase12[i] = word2;
        System.arraycopy(phrase1, i, phrase12, i + 1, phrase1.length - i);
        int diffIndexs2 = diffIndex + diffIndex(phrase12, phrase2, i+1);

        //delete
        String[] phrase13 = new String[phrase1.length - 1];
        System.arraycopy(phrase1, 0, phrase13, 0, i);
        System.arraycopy(phrase1, i + 1, phrase13, i, phrase1.length - i - 1);
        int diffIndexs3 = diffIndex + diffIndex(phrase13, phrase2, i);

        return min(diffIndexs1, diffIndexs2, diffIndexs3);
    }

    private static int min(int diffIndexs1, int diffIndexs2, int diffIndexs3) {
        int[] vals = new int[]{diffIndexs1, diffIndexs2, diffIndexs3};

        Arrays.sort(vals);
        return vals[0];
    }
     */
}

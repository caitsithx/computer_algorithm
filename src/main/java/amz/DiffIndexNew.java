package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoliangl on 06/06/2017.
 */
class DiffIndexNew {
    private static List<String> min = null;
    static int minCount = 0;

    static void calculate(String[] stra1, String[] stra2, List<String> actionList) {
        if (stra1.length == 0) {
            append(actionList, stra2.length, "i");
            finish(actionList);
        } else if (stra2.length == 0) {
            append(actionList, stra1.length, "d");
            finish(actionList);
        } else {
            String[] stra11;
            String[] stra22;
            if (stra1[0].equals(stra2[0])) {
                stra11 = new String[stra1.length - 1];
                System.arraycopy(stra1, 1, stra11, 0, stra11.length);
                stra22 = new String[stra2.length - 1];
                System.arraycopy(stra2, 1, stra22, 0, stra22.length);

                List<String> actionList1 = new ArrayList<>(actionList);
                actionList1.add("-");
                calculate(stra11, stra22, actionList1);
            } else {
                List<String> actionList1 = new ArrayList<>(actionList);
                actionList1.add("d");
                stra11 = new String[stra1.length - 1];
                System.arraycopy(stra1, 1, stra11, 0, stra11.length);
                stra22 = new String[stra2.length];
                System.arraycopy(stra2, 0, stra22, 0, stra22.length);
                calculate(stra11, stra22, actionList1);

                actionList1 = new ArrayList<>(actionList);
                actionList1.add("s");
                stra11 = new String[stra1.length - 1];
                System.arraycopy(stra1, 1, stra11, 0, stra11.length);
                stra22 = new String[stra2.length - 1];
                System.arraycopy(stra2, 1, stra22, 0, stra22.length);
                calculate(stra11, stra22, actionList1);

                actionList1 = new ArrayList<>(actionList);
                actionList1.add("i");
                stra11 = new String[stra1.length];
                System.arraycopy(stra1, 0, stra11, 0, stra11.length);
                stra22 = new String[stra2.length - 1];
                System.arraycopy(stra2, 0, stra22, 0, stra22.length);
                calculate(stra11, stra22, actionList1);
            }
        }
    }

    private static void finish(List<String> actionList) {
        System.out.println(Arrays.toString(actionList.toArray()));
        int count = getCount(actionList);
        if (min == null) {
            min = new ArrayList<>(actionList);
            minCount = count;
        } else if (minCount > count) {
            min.clear();
            min.addAll(actionList);
            minCount = count;
        }
    }

    private static int getCount(List<String> actionList) {
        Object[] actions  = actionList.stream().filter(s -> !s.equals("-")).toArray();
        System.out.println(Arrays.toString(actions));
        return actions.length;
//        return (int)actionList.stream().filter(s -> !s.equals("-")).peek(s -> s.getBytes()).count();
    }

    private static void append(List<String> actionList, int num, String action) {
        for (int i = 0; i < num; i++) {
            actionList.add(action);
        }
    }
}

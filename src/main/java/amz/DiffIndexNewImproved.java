package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoliangl on 06/06/2017.
 */
class DiffIndexNewImproved {
    static int perfCount = 0;
    private static Map<String, ActionList> CACHE = new HashMap<>();

    static ActionList calculate(String[] stra1, String[] stra2) {
        ActionList actionList;


        String key = Arrays.toString(stra1) + "<~>" + Arrays.toString(stra2);
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }
        perfCount++;

        if (stra1.length == 0 || stra2.length == 0) {

            if (stra1.length == 0) {
                actionList = append(stra2.length, "i");
            } else {
                actionList = append(stra2.length, "d");
            }
        } else {
            String action;
            ActionList actionList1;

            String[] stra11;
            String[] stra22;
            if (stra1[0].equals(stra2[0])) {
                stra11 = new String[stra1.length - 1];
                System.arraycopy(stra1, 1, stra11, 0, stra11.length);
                stra22 = new String[stra2.length - 1];
                System.arraycopy(stra2, 1, stra22, 0, stra22.length);

                action = "-";
                actionList1 = calculate(stra11, stra22);
            } else {
                stra11 = new String[stra1.length - 1];
                System.arraycopy(stra1, 1, stra11, 0, stra11.length);
                stra22 = new String[stra2.length];
                System.arraycopy(stra2, 0, stra22, 0, stra22.length);
                action = "d";
                actionList1 = calculate(stra11, stra22);

                stra11 = new String[stra1.length - 1];
                System.arraycopy(stra1, 1, stra11, 0, stra11.length);
                stra22 = new String[stra2.length - 1];
                System.arraycopy(stra2, 1, stra22, 0, stra22.length);

                ActionList actionLists = calculate(stra11, stra22);
                if (getCount(actionList1.sequence) > getCount(actionLists.sequence)) {
                    action = "s";
                    actionList1 = actionLists;
                }

                stra11 = new String[stra1.length];
                System.arraycopy(stra1, 0, stra11, 0, stra11.length);
                stra22 = new String[stra2.length - 1];
                System.arraycopy(stra2, 0, stra22, 0, stra22.length);
                ActionList actionListi = calculate(stra11, stra22);
                if (getCount(actionList1.sequence) > getCount(actionListi.sequence)) {
                    action = "s";
                    actionList1 = actionListi;
                }
            }

            actionList = new ActionList();
            actionList.sequence = new ArrayList<>();
            actionList.sequence.add(action);
            actionList.sequence.addAll(actionList1.sequence);
            actionList.actionCount = getCount(actionList.sequence);
        }

        return actionList;
    }

    private static int getCount(List<String> actionList) {
        Object[] actions = actionList.stream().filter(s -> !s.equals("-")).toArray();
        System.out.println(Arrays.toString(actions));
        return actions.length;
//        return (int)actionList.stream().filter(s -> !s.equals("-")).peek(s -> s.getBytes()).count();
    }

    private static ActionList append(int num, String action) {
        List<String> actionList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            actionList.add(action);
        }

        ActionList actionList1 = new ActionList();
        actionList1.sequence = actionList;
        actionList1.actionCount = getCount(actionList);
        return actionList1;
    }

    static class ActionList {
        List<String> sequence;
         int actionCount;
    }
}

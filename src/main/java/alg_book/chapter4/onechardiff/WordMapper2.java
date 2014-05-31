package alg_book.chapter4.onechardiff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by caitsithx on 14-5-25.
 */
public class WordMapper2 {
    public static Map<String, List<String>> createMapping(List<String> allWords) {
        Map<String, List<String>> mapping = new TreeMap<>();

        Map<Integer, Wrapper> wrapperByLen = new TreeMap<>();
        for (String word : allWords) {
            int length = word.length();

            if (wrapperByLen.get(length) == null) {
                wrapperByLen.put(length, new Wrapper(length));
            }

            for (int i = 0; i < length; i++) {
                String fragment = removeCharAt(word, i);

                if (wrapperByLen.get(length).removeKthCharMap[i].get(fragment) == null) {
                    wrapperByLen.get(length).removeKthCharMap[i].put(fragment, new ArrayList<String>());
                }

                wrapperByLen.get(length).removeKthCharMap[i].get(fragment).add(word);
            }
        }

        for (Wrapper wrapper : wrapperByLen.values()) {
            for (Map<String, List<String>> repMap : wrapper.removeKthCharMap) {
                for (List<String> values : repMap.values()) {
                    String[] words1 = new String[values.size()];
                    values.toArray(words1);
                    for (int i = 0; i < words1.length; i++) {
                        for (int j = i + 1; j < words1.length; j++) {
                            WordMapper.updateSequence(mapping, words1[i], words1[j]);
                            WordMapper.updateSequence(mapping, words1[j], words1[i]);
                        }
                    }
                }
            }
        }



        return mapping;
    }

    public static String removeCharAt(String word, int i) {
        int length = word.length();

        StringBuilder sb = new StringBuilder(length);
        for (int j = 0; j < length; j++) {
            if (i != j) {
                sb.append(word.charAt(j));
            }
        }

        return sb.toString();
    }
}

class Wrapper {
    int length;
    Map<String, List<String>>[] removeKthCharMap;

    public Wrapper(int len) {
        this.length = len;
        removeKthCharMap = new TreeMap[len];
    }
}

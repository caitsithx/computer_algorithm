package alg_book.chapter4.onechardiff.charshuffle;

import java.util.*;

/**
 * Created by lixl on 6/1/14.
 */
public class SOL1_WordMapper {
    public static Map<Integer, Map<String, List<String>>> buildMapping(List<String> words) {
        Map<Integer, Map<String, List<String>>> wordsByLenByKey = new HashMap<>();

        for (String word : words) {
            if (wordsByLenByKey.get(word.length()) == null) {
                wordsByLenByKey.put(word.length(), new HashMap<String, List<String>>());
            }

            String key = convertKey(word);

            if (wordsByLenByKey.get(word.length()).get(key) == null) {
                wordsByLenByKey.get(word.length()).put(key, new ArrayList<String>());
            }
            wordsByLenByKey.get(word.length()).get(key).add(word);
        }



        return wordsByLenByKey;
    }

    public static char[] convertKeyChars(String word) {
        char[] chs = word.toCharArray();

        Arrays.sort(chs);

        return chs;
    }

    private static String convertKey(String word) {
        return new String(convertKeyChars(word));
    }
}

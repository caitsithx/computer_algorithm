package alg_book.chapter4.onechardiff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by caitsithx on 14-5-25.
 */
public class WordMapper1 {
    public static Map<String, List<String>> createMapping(List<String> allWords) {
        Map<String, List<String>> mapping = new TreeMap<>();

        Map<Integer, List<String>> wordsByLength = new TreeMap<>();
        for (String word : allWords) {
            int length = word.length();
            if (wordsByLength.get(length) == null) {
                wordsByLength.put(length, new ArrayList<String>(allWords.size()));
            }

            wordsByLength.get(length).add(word);
        }

        for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
            String[] words = new String[entry.getValue().size()];
            entry.getValue().toArray(words);

            WordMapper.updateSequences(mapping, words);
        }

        return mapping;
    }
}

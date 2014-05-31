package alg_book.chapter4.onechardiff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by caitsithx on 14-5-25.
 */
public class WordMapper3 {
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

            for (int i = 0; i < entry.getKey(); i++) {
                Map<String, List<String>> subMapping = new TreeMap<>();
                for (String word : words) {
                    String token = WordMapper2.removeCharAt(word, i);
                    WordMapper.updateSequence(subMapping, token, word);
                }

                for (List<String> wordsByToken : subMapping.values()) {
                    for (String word1 : wordsByToken) {
                        for (String word2 : wordsByToken) {
                            if (word1 != word2) {
                                WordMapper.updateSequence(mapping, word1, word2);
                            }
                        }
                    }
                }
            }
        }

        return mapping;
    }
}

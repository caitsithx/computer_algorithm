package alg_book.chapter4.onechardiff;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by caitsithx on 14-5-25.
 */
public class WordMapper {
    public static Map<String, List<String>> createMapping(List<String> allWords) {
        Map<String, List<String>> mapping = new TreeMap<>();

        String[] words = new String[allWords.size()];
        allWords.toArray(words);

        updateSequences(mapping, words);

        return mapping;
    }

    public static void updateSequences(Map<String, List<String>> mapping, String[] words) {
        for(int i = 0; i < words.length; i ++) {
            for(int j = i + 1; i < words.length; j ++) {
                if(oneCharDiff(words[i], words[j])) {
                    updateSequence(mapping, words[i], words[j]);
                    updateSequence(mapping, words[j], words[i]);
                }
            }
        }
    }

    public static void updateSequence(Map<String, List<String>> mapping, String word, String word1) {
        if(!mapping.containsKey(word)) {
            mapping.put(word, new LinkedList<String>());
        }

        mapping.get(word).add(word1);
    }

    public static boolean oneCharDiff(String word, String word1) {
        int diffCount = 0;
        if(word.length() == word1.length()) {
            for(int i = 0; i < word.length(); i ++) {
                if(word.charAt(i) != word1.charAt(i)) {
                    if(++diffCount > 1) {
                        break;
                    }
                }
            }

            return diffCount == 1;
        }

        return false;
    }
}

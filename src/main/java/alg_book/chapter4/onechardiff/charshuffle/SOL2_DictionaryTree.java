package alg_book.chapter4.onechardiff.charshuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给一个单词a，如果通过交换单词中字母的顺序可以得到另外的单词b，那么b是a的兄弟单词，
 * 比如的单词army和mary互为兄弟单词。
 * <p/>
 * 字典树的典型应用，一般情况下，字典树的结构都是采用26叉树进行组织的，每个节点对应一个字母，查找的时候，
 * 就是一个字母一个字母的进行匹配，算法的时间复杂度就是单词的长度n，效率很高。
 * 因此这个题目可以定义一个字典树作为数据结构来查询的，时间效率会很高，这样就转化为在一棵字典树中查找兄弟单词，
 * 只要在字典树中的前缀中在存储一个vector结构的容器，这样查找起来就是常数级的时间复杂度了，效率很高的。。
 * <p/>
 * http://blog.csdn.net/hackbuteer1/article/details/7542774
 * <p/>
 * Created by lixl on 6/1/14.
 */
public class SOL2_DictionaryTree {
    public static DictNode buildDictTree(List<String> words) {
        if (words == null) {
            throw new NullPointerException();
        }

        if (words.size() == 0) {
            throw new IllegalArgumentException();
        }

        DictNode root = new DictNode();

        for (String word : words) {
            char[] keyChars = SOL1_WordMapper.convertKeyChars(word);

            visitAndAddTree(root, keyChars, 0, word);
        }

        return root;
    }

    public static List<String> search(DictNode tree, String word) {
        if (tree == null) {
            throw new NullPointerException("tree");
        }

        if (word == null) {
            throw new NullPointerException("word");
        }



        char[] keyChars = SOL1_WordMapper.convertKeyChars(word);

        DictNode foundNode = visitAndSearchTree(tree, keyChars, 0);

        return Collections.unmodifiableList(foundNode.words);
    }

    private static DictNode visitAndSearchTree(DictNode node, char[] keyChars, int keyIndex) {

        if (keyIndex == keyChars.length - 1) {
            return node.children[keyChars[keyIndex]];
        } else {
            return visitAndSearchTree(node.children[keyChars[keyIndex]], keyChars, keyIndex + 1);
        }
    }

    private static void visitAndAddTree(DictNode node, char[] keyChars, int keyIndex, String word) {


        if (node.children[keyChars[keyIndex]] == null) {
            node.children[keyChars[keyIndex]] = new DictNode();
        }

        if (keyIndex == keyChars.length - 1) {
            node.children[keyChars[keyIndex]].words.add(word);
        } else {
            visitAndAddTree(node.children[keyChars[keyIndex]], keyChars, keyIndex + 1, word);
        }

    }

}

class DictNode {
    List<String> words = new ArrayList<>();

    DictNode[] children = new DictNode['z' + 1];
}

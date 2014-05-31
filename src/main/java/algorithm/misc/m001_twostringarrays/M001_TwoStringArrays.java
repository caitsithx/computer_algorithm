package algorithm.misc.m001_twostringarrays;

/**
 * Created by lixl on 5/31/14.
 * <p/>
 * 求两个字符串数组的交集，并集和差集的程序代码
 */
public class M001_TwoStringArrays {
    public static void process(String[] array1, String[] array2) {
        BinaryTreeEx<String> bTree = new BinaryTreeEx<>();

        for (String str : array1) {
            bTree.insert(str, 1);
        }

        for (String str : array2) {
            bTree.insert(str, 2);
        }

        bTree.visit();
    }

}

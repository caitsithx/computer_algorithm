package algorithm.ms.itv.book;

/**
 * (原题出自微软公司面试题)问题如下：
 * <p/>
 * 有两个序列a,b，大小都为n,序列元素的值任意整数，无序；
 * 要求：通过交换a,b中的元素，使[序列a元素的和]与[序列b元素的和]之间的差最小。
 * 例如:
 * var a=[100,99,98,1,2, 3];
 * var b=[1, 2, 3, 4,5,40];
 * <p/>
 * Created by caitsithx on 14-5-6.
 */
public class SwapArrays {

    public void swap(Element[] collection1, Element[] collection2, int sum1, int sum2) {
        for (int i = 0; i < collection1.length; i++) {
            for (int j = 0; j < collection2.length; j++) {
                int val1 = collection1[i].value;
                int val2 = collection2[j].value;

                int oldDiff = sum1 - sum1;
                int newDiff = 2 * val2 - 2 * val1;

                if (Math.abs(oldDiff) > Math.abs(newDiff)) {

                }
            }
        }
    }

    class Element {
        int value = 0;
        boolean swapped = false;
    }

    class MyCollection {
        Element[] array;
        int sum;
    }
}

package algorithm.ms.itv.book;

import java.util.Arrays;

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

    public void swap(int[] a, int[] b) {
        int[] v1, v2;
        int diff = getDiff(a, b);
        if(diff > 0) {
            v1 = a;
            v2 = b;
        }else if(diff == 0) {
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));
            return;
        } else {
            diff = - diff;
            v1 = b;
            v2 = a;
        }

        for(int i = 0; i < v1.length; i ++) {
            for(int j = 0; j < v2.length; j ++) {
                int delta = v1[i] - v2[j];
                if(delta > 0 && delta < diff/2) {
                    int tmp = v1[i];
                    v1[i] = v2[j];
                    v2[j] = tmp;
                    diff = 2 * delta;
                }else if(delta == diff/2) {
                    System.out.println(Arrays.toString(a));
                    System.out.println(Arrays.toString(b));
                    return;
                } else if(delta > diff/2 && delta < diff) {
                    int tmp = v1[i];
                    v1[i] = v2[j];
                    v2[j] = tmp;
                    diff = 2 * (diff - delta);
                    v1 = v2;
                    v2 = v1;
                }
            }
        }
    }

    private int getDiff(int[] a, int[] b) {
        return Arrays.stream(a).parallel().reduce(0, Integer::sum)
                - Arrays.stream(b).parallel().reduce(0, Integer::sum);
    }
}

/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class PigeonSort {

    public void sort(int[] p_vals, int p_range) {
        int[] l_boxes = new int[p_range];
        Arrays.fill(l_boxes, 0);


        for (int l_i = 0; l_i < p_vals.length; l_i++) {
            l_boxes[p_vals[l_i]]++;
        }

        int l_j = 0;
        for (int l_i = 0; l_i < l_boxes.length; l_i++) {
            while (l_boxes[l_i]-- > 0) {
                p_vals[l_j++] = l_i;
            }
        }
    }

    @Test
    public void case1() {
        PigeonSort l_sort = new PigeonSort();
        int[] p_values = new int[] {1, 2, 5, 4, 100, 500, 20, 2, 1, 19, 99, 198};
        l_sort.sort(p_values, 1000);
        System.out.println(Arrays.toString(p_values));
    }
}

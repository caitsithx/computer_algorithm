package algorithm;

import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class AlgrithmL {

    public static void main(String[] args) {

        int[] inputs = {1, 2, 3, 4};

        System.out.println(Arrays.toString(inputs));
        perm(inputs);

	/*
   * int[] inputs = { 2, 4, 3, 1 };
	 * 
	 * reverse(inputs, 1, inputs.length - 1);
	 * System.out.println(Arrays.toString(inputs));
	 */
    }

    /**
     * @param p_inputs
     * @since RM 3.0.0
     */
    private static void perm(int[] p_inputs) {
        int count = 2;
        int middle = 0;

        while (true) {
            //find the highest: p_inputs[middle] < p_inputs[middle + 1].
            // it doesn't exist at the end.
            for (middle = p_inputs.length - 2; middle >= 0; middle--) {// n-2
                if (p_inputs[middle] < p_inputs[middle + 1]) {
                    break;
                }
            }

            if (middle == -1) {
                break;
            }

            int toSwap = findLgrAfMid(p_inputs, middle);// n-1

            swap(p_inputs, middle, toSwap);
            //	   System.out.println("swap:" + Arrays.toString(p_inputs));

            reverse(p_inputs, middle + 1, p_inputs.length - 1);

            System.out.println("item " + count + " is: " + Arrays.toString(p_inputs));

            count++;
        }
        // perm(p_inputs); tail recursive!!! bad, lixl
    }

    /**
     * @param p_inputs
     * @param p_i
     * @param p_i2
     * @since RM 3.0.0
     */
    private static void reverse(int[] p_inputs, int p_i, int p_i2) {
        for (int start = p_i, end = p_i2; start < end; start++, end--) {
            swap(p_inputs, start, end);
            // System.out.println("here");
            // if (start < end) {
            // tmp = p_inputs[start];
            // p_inputs[start] = p_inputs[end];
            // p_inputs[end] = tmp;
            // }
        }
    }

    /**
     * @param p_inputs
     * @param p_middle
     * @param p_toSwap
     * @since RM 3.0.0
     */
    private static void swap(int[] p_inputs, int p_middle, int p_toSwap) {
        int tmp = p_inputs[p_middle];
        p_inputs[p_middle] = p_inputs[p_toSwap];
        p_inputs[p_toSwap] = tmp;
    }

    /**
     * @param p_inputs
     * @param p_middle
     * @return
     * @since RM 3.0.0
     */
    private static int findLgrAfMid(int[] p_inputs, int p_middle) {
        int i = p_inputs.length - 1;
        for (; i > p_middle; i--) {
            if (p_inputs[p_middle] < p_inputs[i]) {
                break;
            }
        }

        return i;
    }

}

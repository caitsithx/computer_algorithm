/*
 *
 * $Revison$
 * $author$
 */
package algorithm;

import java.util.Arrays;

/**
 *
 */
public class FindTheLargestK {

    public final static void main(String[] args) {
        FindTheLargestK finder = new FindTheLargestK();
        finder.findThem(new int[] {100, 2, 3, 4, 1, 90, 8, 2, 10, 22, 3, 1111, 99, 31}, 5);
    }

    public void findThem(int[] p_input, int p_k) {
        //TODO check inputs

        int[] l_result = new int[p_k];
        int l_resEndIdx = p_k - 1;

        l_result[0] = p_input[0];
        for (int l_i = 1; l_i < p_input.length; l_i++) {

            int l_currentInput = p_input[l_i];
            //init the res array.
            if (l_i < p_k) {
                int l_preIndex = l_i - 1;

                //make the smallest at the tail.
                if (l_currentInput > l_result[l_preIndex]) {
                    l_result[l_i] = l_result[l_preIndex];
                    l_result[l_preIndex] = l_currentInput;
                } else {
                    l_result[l_i] = l_currentInput;
                }

                System.out.println(Arrays.toString(l_result));
            }
            //real start
            else {
                if (l_currentInput > l_result[l_resEndIdx]) {
                    for (int l_j = 0; l_j < l_resEndIdx; l_j++) {
                        if (l_result[l_j] < l_currentInput) {
                            l_result[l_resEndIdx] = l_result[l_j];
                            l_result[l_j] = l_currentInput;
                            l_currentInput = l_result[l_resEndIdx];
                        }
                    }

                    l_result[l_resEndIdx] = l_currentInput;
                }
            }
        }

        System.out.println(Arrays.toString(l_result));
    }

}

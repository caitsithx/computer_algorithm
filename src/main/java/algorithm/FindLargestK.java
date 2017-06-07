package algorithm;

import java.util.Arrays;

/**
 * Created by xiaoliangl on 06/06/2017.
 */
public class FindLargestK {
    public static int[] find(int[] input, int k) {
        int[] output = new int[k];
        double logn = Math.log(input.length);
        if(k < logn) {
            System.arraycopy(input, 0, output, 0, k);
            Arrays.sort(output);

            for (int i = k; i < input.length; i++) {
                boolean start = false;
                for (int j = 0; j < k; j++) {
                    if (input[i] == output[j]) {
                        break;
                    } else if (input[i] < output[j]) {
                        if (start) {
                            insert(output, j - 1, input[i]);
                            break;
                        }
                    } else {
                        start = true;
                        if (j == k - 1) {
                            insert(output, j, input[i]);
                        }
                    }
                }

//                System.out.println(Arrays.toString(output));
            }

        } else {
            Arrays.sort(input);
            System.arraycopy(input, input.length - k, output, 0, k);
        }

        return output;
    }

    private static void insert(int[] array, int index, int value) {
        System.arraycopy(array, 1, array, 0, index);
//        for(int i = 0; i < index; i ++) {
//
//                array[i] = array[i + 1];
//
//        }
        array[index] = value;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(find(new int[] {100, 2, 3, 4, 1, 90, 8, 2, 10, 22, 3, 1111, 99, 31}, 5)));

        System.out.println(
                Arrays.toString(find(new int[] {100, 2, 3, 4, 1, 90, 8, 2, 10, 22, 3, 1111, 99, 31}, 2)));
    }
}

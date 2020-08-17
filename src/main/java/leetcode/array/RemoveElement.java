package leetcode.array;

public class RemoveElement {

    public int removeElement(int[] array, int val) {
        int  j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != val) {
                array[j] = array[i];
                j++;
            }
        }

        return j;
    }
}

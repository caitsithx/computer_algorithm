package leetcode.medianof2sortedarray;

import static java.lang.Integer.min;

public class Solution3 {

    private static int[] sArray = {4, 5};
    private static int[] bArray = {1, 2, 3};

    public static void main(String[] args) {
        int mIndex1 = (bArray.length + sArray.length) / 2;
        int mIndex2 = (bArray.length + sArray.length + 1) / 2;

        double median;
        if (mIndex1 == mIndex2) {
            median = (findMinK(sArray, 0, sArray.length - 1, bArray, 0, bArray.length - 1, mIndex1)
                    + findMinK(sArray, 0, sArray.length, bArray, 0, bArray.length,
                    mIndex1 + 1)) / 2.0d;
        } else {
            median = findMinK(sArray, 0, sArray.length - 1, bArray, 0, bArray.length - 1, mIndex2);
        }

        System.out.println(median);
    }

    private static double findMinK(int[] sArray, int sStart, int sEnd, int[] bArray, int bStart, int bEnd, int k) {
        int sLen = sEnd - sStart + 1;
        int bLen = bEnd - bStart + 1;

        if (bLen < sLen) {
            return findMinK(bArray, bStart, bEnd, sArray, sStart, sEnd, k);
        } else {
            if (sLen == 0) {
                return bArray[bStart + k - 1];
            } else {
                if (k == 1) {
                    return min(sArray[sStart], bArray[bStart]);
                }

                int sK = min(k / 2, sLen);
                int bK = min(k / 2, bLen);

                if (sArray[sStart + sK - 1] > bArray[bStart + bK - 1]) {
                    return findMinK(sArray, sStart, sEnd, bArray, bStart + bK, bEnd, k - bK);
                } else {
                    return findMinK(sArray, sStart + sK, sEnd, bArray, bStart, bEnd, k - sK);
                }
            }
        }

    }
}

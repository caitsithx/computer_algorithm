package leetcode.array.bisection;

public class MySqrt {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 5};
        System.out.println(new MySqrt().mySqrt(4));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long i = 1;
        long j = x - 1;
        while (i < j) {
            long mid = (i + j + 1) / 2;

            long val = foo(mid);

            if (val > x) {
                j = mid - 1;
            } else {
                i = mid;
            }

        }

        return (int) i;
    }

    private long foo(long x) {
        return x * x;
    }
}

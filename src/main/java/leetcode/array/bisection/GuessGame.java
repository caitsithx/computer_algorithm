package leetcode.array.bisection;

public class GuessGame {

    public int guessNumber(int n) {
        int i = 1;
        int j = n;

        while (i < j) {
            int mid = i +  (j - i)/ 2;
            int res = guess(mid);

            switch (res) {
                case 0:
                    return mid;
                case -1:
                    j = mid -1;
                    break;
                case 1:
                    i = mid + 1;
                    break;
            }

        }

        return i;
    }

    //2126753390
    //1702766719
    int guess(int num) {
        int ex = 1702766719;
        if(ex == num) {
            return 0;
        }
        if (ex > num) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new GuessGame().guessNumber(2126753390));
    }
}

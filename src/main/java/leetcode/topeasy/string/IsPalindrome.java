package leetcode.topeasy.string;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        while (i < j) {
            if (!isValid(s.charAt(i))) {
                i ++;
            } else if (!isValid(s.charAt(j))) {
                j --;
            } else if (compare(s.charAt(i), s.charAt(j))) {
                i ++;
                j --;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean compare(char a, char b) {
        return getShift(a) == getShift(b);
    }

    private int getShift(char charAt) {
        if (charAt >= 'a' && charAt <= 'z') {
            return 'A' + charAt - 'a';
        } else return charAt;
    }

    private boolean isValid(char charAt) {
        return (charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
    }
}

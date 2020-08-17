package leetcode.string;

public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0,j=s.length - 1; i < j; i++,j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }

    public static void main(String[] args) {

        char[] chars = new char[]{'a','b', 'c'};
        new ReverseString().reverseString(chars);
        System.out.println(new String(chars));
    }
}

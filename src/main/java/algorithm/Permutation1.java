package algorithm;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * @since RM 3.0.0
 */
public class Permutation1 {
    public static void main(String[] args) {
        Permutation1 perm = new Permutation1();
        char s[] = {'1', '2', '3'};
        perm.Perm(s, 0, 2);
    }

    final void Swap(char[] chs, int a, int b) {// swap
        char temp = chs[a];
        chs[a] = chs[b];
        chs[b] = temp;
    }

    void Perm(char list[], int k, int m) { // list [k:m]
        int i;
        if (k == m) {// T(n+1)
            for (i = 0; i < list.length; i++) {
                System.out.print(list[i]);
            }
            System.out.println();
        } else
            // list[k:m] has multi combinations
            // recursively
            for (i = k; i < list.length; i++) {
                Swap(list, k, i);
                Perm(list, k + 1, m);
                Swap(list, k, i);
            }
    }
}

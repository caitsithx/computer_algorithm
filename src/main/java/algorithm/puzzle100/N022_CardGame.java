/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */

/*
 第22题：
 有4张红色的牌和4张蓝色的牌，主持人先拿任意两张，再分别在A、B、C三人额头上贴任意两张牌，
 A、B、C三人都可以看见其余两人额头上的牌，看完后让他们猜自己额头上是什么颜色的牌，
 A说不知道，B说不知道，C说不知道，然后A说知道了。
 请教如何推理，A是怎么知道的。
 如果用程序，又怎么实现呢？

 豆沙的做法：
 题不难，难在数学模型的建立。

 1. 先给问题设计一个数学模型：
 设红色的牌一张算1分，蓝色的牌一张算10分。这样最初发牌之前，4张红牌和四张蓝牌，总分值是44分。
 对某一个人来说，他拿到牌以后可能得到分数如下：
 1.1) 一红一蓝就是11分；
 1.2) 俩红就是20分；
 1.3）俩蓝就是2分。

 ABC三人可能拿到分值分别为SA, SB, SC，那么{SA，SB, SC}的所有可能情况是{11, 20, 2}的任意组合。
 先定义一下：private int[] m_c42 = {20, 11, 02};

 1. 首先对任意两个人（AB）来说，如果AB分别拿了2张同色的，而且AB拿的都是红色，这样C看到他们的牌后，
 是可以猜到自己的牌的。AB拿走牌后，只剩下四张蓝牌了，C只可能有2张蓝牌。于是乎，
 我们可以得到第一个判断条件：任意两个人的分数值之和不可以是4或者40，否则另一个人一下就猜出来了。
 public boolean isGuessible1(int p_p1, int p_p2) {
 return (p_p1 == 2 && p_p2 == 2) || (p_p1 == 20 && p_p2 == 20);
 }
 2. 根据第一个条件，我们可以对2个人分数的所有组合情况做一次筛选。
 ArrayList<int[]> l_candidateList = new ArrayList<>();

 for(int l_i = 0; l_i < m_c42.length; l_i++) {
 for(int l_j = 0; l_j < m_c42.length; l_j++) {
 if(!isGuessible1(m_c42[l_i], m_c42[l_j])) {
 l_candidateList.add(new int[]{m_c42[l_i], m_c42[l_j]});
 }
 }
 }
 这段代码结束时，我们排除了所有只要看一眼就能猜出来的组合。

 3. 然后怎么继续下去呢？有两句话很关键：A猜不到，B也猜不到，C也猜不到。刚才我们做完第二步，
 已经保证了“A猜不到”。那怎么继续保证B和C也猜不到呢？我们来看个例子：
 假设A一开始看到的是这种情况：{SA=??, SB=20, SC=02}。那么首先SB和SC是能通过第二步的筛选的，
 所以A一开始猜不出来。接下来我们需要看一下下面两种假设：
 3.1）如果SA=02，那么B看到的就是{SA=02, SB=??, SC=02}，这样B就猜得出来。
 3.2）如果SA=20，那么C看到的就是{SA=20, SB=20, SC=??}，这样C就能猜出来。
 所以，但是A知道B和C没猜到，所以SA只能等于11！条件函数是如下：

 public boolean isGuessible2(int p_p1, int p_p2) {
 int l_nonGuessible = 0;
 for (int l_i = 0; l_i < m_c42.length; l_i++) {
 boolean l_guessible2 = isGuessible1(p_p1, m_c42[l_i]) || isGuessible1(p_p2, m_c42[l_i]);
 if(!l_guessible2) {
 l_nonGuessible ++;
 }
 }
 return l_nonGuessible == 1;
 }

 4.把第二步筛选过的组合，再用新的条件重筛一下。你会发下，A看到某几个组合的时候，也会抓瞎:)

 */
package algorithm.puzzle100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N022_CardGame {
    public final static int[] POSSIBLE_SCORES = {20, 11, 02};

    private boolean thirdGuyCanGuess(int score1, int score2) {
        return (score1 == 2 && score2 == 2) || (score1 == 20 && score2 == 20);
    }

    private boolean isGuessible2(int p_p1, int p_p2) {
        int l_nonGuessible = 0;
        for (int l_i = 0; l_i < POSSIBLE_SCORES.length; l_i++) {
            boolean l_guessible2 = thirdGuyCanGuess(p_p1, POSSIBLE_SCORES[l_i])
                || thirdGuyCanGuess(p_p2, POSSIBLE_SCORES[l_i]);
            if (!l_guessible2) {
                l_nonGuessible++;
            }
        }
        return l_nonGuessible == 1;
    }

    @Test
    public void straightForwardGuess() {
        ArrayList<int[]> bc_Scores = new ArrayList<>();

        for (int score1 : POSSIBLE_SCORES) {
            for (int score2 : POSSIBLE_SCORES) {
                //A tries to guess from BC.
                //only keep the scores that A can't guess.
                if (!thirdGuyCanGuess(score1, score2)) {
                    bc_Scores.add(new int[] {score1, score2});
                }
            }
        }

        // find all ABC combinations that all can't guess.
        // but exceptions! for some B and C combinations, A has only one possibility!
        // e.g. [A, 20, 2], A can only be 11, otherwise, B or C should be able to guess.
        // which means, if A see 20, 2, at same time B and C says can't guess. A knows himself is 11.
        //so we need the BC scores, that A has to be one value.
        ArrayList<int[]> abc_Scores = new ArrayList<>();
        for (int[] bc_score : bc_Scores) {
            int a_scoreCount = 0;
            int A_scoreCandidate = 0;

            System.out.println("test bc: " + Arrays.toString(bc_score));
            for (int a_score : POSSIBLE_SCORES) {
                if (isVaild(a_score, bc_score[0], bc_score[1])) {
                    // B try to guess from AC.
                    // only keep the scores that B can't guess.
                    if (!thirdGuyCanGuess(a_score, bc_score[1])) {
                        // C try to guess from AB.
                        // only keep the scores that C can't guess.
                        if (!thirdGuyCanGuess(a_score, bc_score[0])) {
                            a_scoreCount++;
                            A_scoreCandidate = a_score;
                            System.out.println("possible abc that all can't guess at first round: " + a_score + "," + Arrays.toString(bc_score));
                        }
                    }
                }
            }

            if (a_scoreCount == 1) {
                abc_Scores.add(new int[] {A_scoreCandidate, bc_score[0], bc_score[1]});
            } else {
                System.out.println("not good, in this case, A can't guess at the end.");
            }
        }

        System.out.println("finally:");
        for (int[] abc_score : abc_Scores) {
            System.out.println(Arrays.toString(abc_score));
        }
    }

    private boolean isVaild(int a_score, int b_score, int c_sore) {
        int sum = a_score + b_score + c_sore;

        if (sum / 10 > 4)
            return false;

        if (sum % 10 > 4)
            return false;

        return true;
    }

    @Test
    public void guess1() {
        ArrayList<int[]> l_candidateList = new ArrayList<>();

        for (int l_i = 0; l_i < POSSIBLE_SCORES.length; l_i++) {
            for (int l_j = 0; l_j < POSSIBLE_SCORES.length; l_j++) {
                if (!thirdGuyCanGuess(POSSIBLE_SCORES[l_i], POSSIBLE_SCORES[l_j])) {
                    l_candidateList.add(new int[] {POSSIBLE_SCORES[l_i], POSSIBLE_SCORES[l_j]});
                }
            }
        }
        int[][] l_candidates = new int[l_candidateList.size()][];
        l_candidateList.toArray(l_candidates);

        for (int l_i = 0; l_i < l_candidates.length; l_i++) {
            System.out.println(Arrays.toString(l_candidates[l_i]) + " guessible: "
                + isGuessible2(l_candidates[l_i][0], l_candidates[l_i][1]));
        }
    }
}

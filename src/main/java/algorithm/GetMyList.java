// -------------------------------------------------------------------------
// Copyright (c) 2006-2012 GEMALTO group. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// GEMALTO.
//
package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * @since RM 3.0.0
 */
public class GetMyList {
    private char[] patternAb;
    private char chara = 'a';
    private List<char[]> resList = new ArrayList<char[]>();

    public static void main(String[] args) {
        GetMyList obj = new GetMyList();

        obj.getMyList(new char[3]);
    }

    public void getMyList(char[] patternAb) {
        char[] tmp = new char[patternAb.length + 1];

        List<Integer> indexPool = new ArrayList<Integer>();
        for (int l_i = 0; l_i < tmp.length; l_i++) {
            indexPool.add(l_i);
        }

        getMyList(tmp, (byte) 0, indexPool);
    }

    protected void getMyList(char[] temp, byte shift, List<Integer> indexPool) {
        for (Integer i : indexPool) {
            temp[i] = (char) (chara + shift);//T1
            List<Integer> subIndexPool = new ArrayList<Integer>(indexPool);
            subIndexPool.remove(i);//T1

            if (subIndexPool.size() == 0) {
                System.out.println(temp);//T1
            }

            getMyList(temp, (byte) (shift + 1), subIndexPool); //T(n-1)
        }
    }
}

/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package interview;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class Itv01_Q01_NumberFinder {
   private ArrayList<Integer> m_pool = new ArrayList<Integer>(); //{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}

   private long[] DICT = {1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

   public Itv01_Q01_NumberFinder() {
      for (int l_i = 0; l_i < 10; l_i++) {
         m_pool.add(l_i);
      }
   }

   private long getPower10(int p_weiShu) {
      if (DICT[p_weiShu] == -1) {
         if (DICT[p_weiShu - 1] == -1) {
            throw new IllegalStateException();
         }
         DICT[p_weiShu] = DICT[p_weiShu - 1] * 10;
      }

      return DICT[p_weiShu];
   }

   public void printMyNumbers(int p_weiShu, long p_current, ArrayList<Integer> p_pool) {
      if (p_pool.size() == 0) {
         return;
      }

      for (int l_j = 0; l_j < p_pool.size(); l_j++) {
         long l_current = p_current;
         if (p_pool.get(l_j) != 0) {
            l_current = getPower10(p_weiShu) * p_pool.get(l_j) + l_current;
//		l_current = ((long)Math.pow(10, p_weiShu)) * p_pool.get(l_j) + p_current;
            System.out.println(l_current);
         } else {
            if (p_weiShu == 0) {
               System.out.println(l_current);
            }
         }

         if (p_weiShu < 10) {
            //build a new pool
            ArrayList<Integer> l_newPool = new ArrayList<>();
            l_newPool.addAll(p_pool);
            l_newPool.remove(l_j);
            printMyNumbers(p_weiShu + 1, l_current, l_newPool);
         }
      }
   }


   public void printMyNumbers() {
      printMyNumbers(0, 0, m_pool);
   }

   @Test
   public void case1() {
      printMyNumbers();
   }
}
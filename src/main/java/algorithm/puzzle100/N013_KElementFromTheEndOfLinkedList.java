/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
/*
第13题：
题目：输入一个单向链表，输出该链表中倒数第k个结点。链表的倒数第0个结点为链表的尾指针。
链表结点定义如下：   
struct ListNode
{
  int m_nKey;
  ListNode* m_pNext;
};
 */
package algorithm.puzzle100;

import algorithm.puzzle100.struct.IntNode;
import org.junit.jupiter.api.Test;

/**
 * @param <T>
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */

public class N013_KElementFromTheEndOfLinkedList {
    public IntNode find(IntNode p_list, int p_k) {

        int l_length = getLength(p_list);
        int l_kFromBeginning = (l_length - p_k - 1);

        IntNode l_tmp = p_list;
        for (int i = 1; i <= l_kFromBeginning; i++) {
            l_tmp = (IntNode) l_tmp.getNext();
        }

        return l_tmp;
    }

    /**
     * @param p_list
     * @return
     */
    private int getLength(IntNode p_list) {
        if (p_list == null) {
            return 0;
        }

        IntNode l_tmp = p_list;
        int l_len = 0;

        do {
            l_len++;
            l_tmp = (IntNode) l_tmp.getNext();
        } while (l_tmp != null);

        return l_len;
    }

    @Test
    public void case1() {
        N013_KElementFromTheEndOfLinkedList l_finder = new N013_KElementFromTheEndOfLinkedList();

        IntNode l_tmp = null;
        for (int l_i = 9; l_i >= 0; l_i--) {
            l_tmp = new IntNode(l_i, null, l_tmp);
        }
        System.out.println(l_finder.find(l_tmp, 5));
    }

}


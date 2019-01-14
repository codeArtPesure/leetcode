package com.dengzhili.leetcode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 例如，下面的两个链表：
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交。
 *
 *
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class Demo160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }

        int headALength=0;
        int headBLength=0;

        ListNode tmpA=headA;
        ListNode tmpB=headB;
        while (tmpA!=null && tmpB!=null){
            if(tmpA==tmpB){
                return tmpA;
            }
            tmpA=tmpA.next;
            tmpB=tmpB.next;
            headALength++;
            headBLength++;
        }
        if(tmpA==null){
            while (tmpB!=null){
                tmpB=tmpB.next;
                headBLength++;
            }
            int offset=headBLength-headALength;
            tmpA=headA;
            tmpB=headB;
            for (int i = 0; i < offset; i++) {
                tmpB=tmpB.next;
            }
            while (tmpA!=null && tmpB!=null){
                if(tmpA == tmpB){
                    return tmpA;
                }else {
                    tmpA=tmpA.next;
                    tmpB=tmpB.next;
                }
            }
        }else if(tmpB==null){
            while (tmpA!=null){
                tmpA=tmpA.next;
                headALength++;
            }
            tmpA=headA;
            tmpB=headB;
            int offset=headALength-headBLength;
            for (int i = 0; i < offset; i++) {
                tmpA=tmpA.next;
            }
            while (tmpA!=null && tmpB!=null){
                if(tmpA == tmpB){
                    return tmpA;
                }else {
                    tmpA=tmpA.next;
                    tmpB=tmpB.next;
                }
            }
        }
        return null;
    }

}

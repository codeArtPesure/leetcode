package com.dengzhili.leetcode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Demo206 {

    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode reversrHead=new ListNode(head.val);
        ListNode node=reversrHead;
        while (head.next!=null){
            head=head.next;
            node=new ListNode(head.val);
            node.next=reversrHead;
            reversrHead=node;
        }
        return node;
    }
}

package com.dengzhili.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 */
public class Demo19 {

    //思路一 先便利一遍链表，记录长度len。下一次链表移动len-n次，并删除元素
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head==null){
//            return head;
//        }
//        int len=0;
//        ListNode node=head;
//        while (node!=null){
//            len++;
//            node=node.next;
//        }
//        node=head;
//        for (int i=0;i<len-n-1;i++){
//            node=node.next;
//        }
//        if(len==0)  return null;  //len等于1，说明只有一个头节点
//        if(len==n){     //删除头节点
//            head=node.next;
//
//        }else {
//            node.next=node.next.next;
//        }
//        return head;
//    }

    /**
     * 思路二
     *双指针解法（前指针、后指针），让前指针先走N步，再让两个在指针同时后移，直到前指针到达尾部，
     *此时，后指针的下一个节点就是要被删除的节点了。
     */
    

}

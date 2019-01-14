package com.dengzhili.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Demo203 {

    public ListNode removeElements(ListNode head, int val) {

        while (head!=null && head.val==val){
            head=head.next;
        }
        if(head==null){
            return null;
        }
        ListNode node=head;
        ListNode nextNode=node.next;
        while (node!=null){
            while (nextNode!=null && nextNode.val==val){
                nextNode=nextNode.next;
            }
            node.next=nextNode;
            node=node.next;
            if(nextNode!=null)
                nextNode=nextNode.next;
        }
        return head;
    }
}

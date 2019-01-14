package com.dengzhili.leetcode;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Demo234 {

    /**
     * 思路一：栈（简单思路）
     * @param head
     * @return
     */
//    public boolean isPalindrome(ListNode head) {
//        Stack<Integer> stack=new Stack<Integer>();
//        ListNode node=head;
//        while (node!=null){
//            stack.push(node.val);
//            node=node.next;
//        }
//        node=head;
//        while (node!=null){
//            int val=node.val;
//            int reversrVal=stack.pop();
//            if(val!=reversrVal){
//                return false;
//            }
//            node=node.next;
//        }
//        return true;
//    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}

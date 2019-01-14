package com.dengzhili.leetcode;


/**
 * 给定一个链表，判断链表中是否有环。
 */
public class Demo141 {

    /**
     * 使用快慢指针，若指针相遇则判断有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

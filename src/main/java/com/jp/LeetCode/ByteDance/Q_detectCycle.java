package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.ListNode;

/**
 * @author zjp
 * @createTime 2020/7/23 22:51
 **/
public class Q_detectCycle {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}

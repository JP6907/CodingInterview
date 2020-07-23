package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.ListNode;

/**
 * @author zjp
 * @createTime 2020/7/23 21:33
 **/
public class Q_reverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

}

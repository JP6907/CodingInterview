package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.ListNode;

/**
 * @author zjp
 * @createTime 2020/7/23 21:36
 **/
public class Q_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        ListNode p = head;
        int carry = 0;
        while (p1 != null && p2 != null){
            int sum = p1.val + p2.val + carry;
            if(head == null){
                head = new ListNode(sum % 10);
                p = head;
            } else {
                ListNode node = new ListNode(sum % 10);
                p.next = node;
                p = node;
            }
            carry = sum / 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null){
            int sum = p1.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            p.next = node;
            p = node;
            p1 = p1.next;
        }
        while (p2 != null) {
            int sum = p2.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            p.next = node;
            p = node;
            p2 = p2.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            p.next = node;
        }
        return head;
    }

}

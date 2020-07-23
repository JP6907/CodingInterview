package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.ListNode;

/**
 * @author zjp
 * @createTime 2020/7/23 21:27
 **/
public class Q_mergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head;
        if(p1.val < p2.val){
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
        ListNode p = head;
        while (p1 != null && p2 != null){
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1 != null){
            p.next = p1;
        }
        if(p2 != null){
            p.next = p2;
        }
        return head;
    }
}

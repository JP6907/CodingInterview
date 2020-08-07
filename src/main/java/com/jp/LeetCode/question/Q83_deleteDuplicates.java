package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.ListNode;

/**
 * @author shangqiu
 * @createTime 2020/8/6
 **/
public class Q83_deleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head.next;
        ListNode pre = head;
        ListNode next = null;
        while (p != null){
            while (p != null && pre.val == p.val){
                next = p.next;
                pre.next = next;
                p.next = null;
                p = next;
            }
            if(p != null) {
                pre = p;
                p = p.next;
            }
        }
        return head;
    }

    public static void test(int[] data){
        ListNode head = deleteDuplicates(new ListNode(data));
        System.out.println(head);
    }

    public static void main(String[] args) {
        test(new int[]{1,1,2,3,3});
    }

}

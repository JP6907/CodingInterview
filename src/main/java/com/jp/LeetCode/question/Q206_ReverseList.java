package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author zjp
 * @Description
 * @createTime 10:59
 **/
public class Q206_ReverseList {

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void test(List<Integer> data){
        ListNode head = new ListNode(data);
        ListNode reverseHead = reverseList(head);
        System.out.println(reverseHead);
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3,4,5));
    }
}

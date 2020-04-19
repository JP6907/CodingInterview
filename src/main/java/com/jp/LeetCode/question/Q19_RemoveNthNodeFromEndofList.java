package com.jp.LeetCode.question;

//Given a linked list, remove the n-th node from the end of list and return its head.
//
//Example:
//
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//
//Given n will always be valid.
//
//Follow up:
//
//Could you do this in one pass?

import com.jp.LeetCode.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

public class Q19_RemoveNthNodeFromEndofList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int i=1;
        for(;i<n&&p!=null;i++)
            p = p.next;
        //长度不够n
        if(i!=n)
            return head;
        //移除的是头节点
        if(p.next==null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        ListNode cur = head;
        ListNode pre = head;
        while (p.next!=null){
            pre = cur;
            cur = cur.next;
            p = p.next;
        }
        pre.next = cur.next;
        cur.next = null;
        return head;
    }

    public static void Test(List<Integer> data, int n){
        ListNode head = new ListNode(data);
        ListNode result = removeNthFromEnd(head,n);
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Test(Arrays.asList(1,2,3,4,5),2);
        Test(Arrays.asList(1,2,3,4,5),5);
    }

}

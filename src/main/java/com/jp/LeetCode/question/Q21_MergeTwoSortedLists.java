package com.jp.LeetCode.question;

// Merge two sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.
//
//Example:
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4

import com.jp.LeetCode.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

public class Q21_MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        ListNode curr = null;
        while (p1!=null&&p2!=null){
            if(p1.val<p2.val){
                if(head==null){
                    head = p1;
                    curr = head;
                    p1 = p1.next;
                }else{
                    curr.next = p1;
                    curr = curr.next;
                    p1 = p1.next;
                }
            }else{
                if(head==null){
                    head = p2;
                    curr = head;
                    p2 = p2.next;
                }else{
                    curr.next = p2;
                    curr = curr.next;
                    p2 = p2.next;
                }
            }
        }
        p1 = (p1==null?p2:p1);
        while (p1!=null){
            curr.next = p1;
            curr = curr.next;
            p1 = p1.next;
        }
        return head;
    }

    public static void Test(List<Integer> list1, List<Integer> list2){
        ListNode l1 = new ListNode(list1);
        ListNode l2 = new ListNode(list2);
        ListNode head = mergeTwoLists(l1,l2);
        System.out.println(head);
    }

    public static void main(String[] args) {
        Test(Arrays.asList(1,2,4),Arrays.asList(1,3,4));
    }
}

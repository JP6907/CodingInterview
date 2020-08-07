package com.jp.LeetCode.question;

//Merge k sorted linked lists and return it as one sorted list.
// Analyze and describe its complexity.
//
//Example:
//
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6


import com.jp.LeetCode.datastruct.ListNode;

import java.util.Arrays;

public class Q23_MergekSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null)
            return null;
        else if(lists.length==1)
            return lists[0];
        int size = lists.length;
        ListNode[] curr = new ListNode[size];
        int len = 0;
        for(int i=0;i<size;i++){
            curr[i] = lists[i];
            ListNode p = curr[i];
            while (p!=null){
                len++;
                p = p.next;
            }
        }
        ListNode head = null;
        ListNode p = head;
        while (len-->0){
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                if(curr[i]!=null&&curr[i].val<min){
                    minIndex = i;
                    min = curr[i].val;
                }
            }
            if(head==null){
                head = curr[minIndex];
                curr[minIndex] = curr[minIndex].next;
                p = head;
            }else{
                p.next = curr[minIndex];
                curr[minIndex] = curr[minIndex].next;
                p = p.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(Arrays.asList(1,4,5));
        lists[1] = new ListNode(Arrays.asList(1,3,4));
        lists[2] = new ListNode(Arrays.asList(2,6));
        ListNode result = mergeKLists(lists);
        System.out.println(result.toString());

        lists = new ListNode[3];
        lists[0] = new ListNode(Arrays.asList(1,4,5));
        lists[1] = new ListNode(Arrays.asList(1,3,4));
        lists[2] = new ListNode(Arrays.asList(2,6));
        result = mergeKLists2(lists);
        System.out.println(result.toString());
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode[] curr = new ListNode[lists.length];
        for(int i=0;i<lists.length;i++){
            curr[i] = lists[i];
        }
        ListNode head = null;
        ListNode p = null;
        while (true){
            int minIndex = -1;
            int minVal = Integer.MAX_VALUE;
            for (int i=0;i<lists.length;i++){
                if(curr[i] != null){
                    if(curr[i].val < minVal){
                        minVal = curr[i].val;
                        minIndex = i;
                    }
                }
            }
            if(minIndex == -1){
                break;
            }
            if(head == null){
                head = curr[minIndex];
                p = head;
                curr[minIndex] = curr[minIndex].next;
            } else {
                p.next = curr[minIndex];
                p = p.next;
                curr[minIndex] = curr[minIndex].next;
            }
        }
        return head;
    }

}

package com.jp.CodingInterview;

// 52：两个链表的第一个公共结点
// 题目：输入两个链表，找出它们的第一个公共结点。

import com.jp.datastruct.ListNode;

public class Q52_FirstCommonNodesInLists {

    public static ListNode<Integer> FindFirstCommonNode(ListNode<Integer> pHead1,ListNode<Integer> pHead2){
        int len1 = 0;
        int len2 = 0;
        for(ListNode<Integer> p = pHead1;p!=null;p=p.next)
            len1++;
        for(ListNode<Integer> p = pHead2;p!=null;p=p.next)
            len2++;
        ListNode<Integer> p1,p2;
        int diff = len1-len2;
        if(diff>0) {
            p1 = pHead1;
            p2 = pHead2;
        }else{
            p1 = pHead2;
            p2 = pHead1;
            diff = -diff;
        }
        while (diff>0){
            p1 = p1.next;
            diff--;
        }
        while (p1!=null&&p2!=null&&p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1==p2?p1:null;
    }

    public static void main(String[] args){
        ListNode<Integer> node0 = new ListNode<>(0,null);
        ListNode<Integer> node1 = new ListNode<>(1,null);
        ListNode<Integer> node2 = new ListNode<>(2,null);
        ListNode<Integer> node3 = new ListNode<>(3,null);
        ListNode<Integer> node4 = new ListNode<>(4,null);
        ListNode<Integer> node5 = new ListNode<>(5,null);
        ListNode<Integer> node6 = new ListNode<>(6,null);
        ListNode<Integer> node7 = new ListNode<>(7,null);
        ListNode<Integer> node8 = new ListNode<>(8,null);
        ListNode<Integer> node9 = new ListNode<>(9,null);
        //0 1 2 3 4
        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        //5 6 7 8 9 3 4
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node3);

        System.out.println(node0);
        System.out.println(node5);
        System.out.println(FindFirstCommonNode(node0,node5));
    }
}

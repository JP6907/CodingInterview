package com.jp.CodingInterview;

import com.jp.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

// 面试题24：反转链表
// 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
// 头结点。
public class Q24_ReverseList {

    static ListNode<Integer> ReverseList(ListNode<Integer> pHead){
        ListNode<Integer> pReversedHead = null;
        ListNode<Integer> pNode = pHead;
        ListNode<Integer> pPre = null;
        ListNode<Integer> pNext = null;
        while(pNode!=null){
            if(pNode.next==null){
                pReversedHead = pNode;
            }

            pNext = pNode.next;
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }

    public static void main(String[] args){
        List<Integer> data = Arrays.asList(1,2,3,4,5);
        ListNode<Integer> pHead = new ListNode<Integer>(data);
        ListNode<Integer> pReversedHead = ReverseList(pHead);
        System.out.println(pReversedHead);
    }
}

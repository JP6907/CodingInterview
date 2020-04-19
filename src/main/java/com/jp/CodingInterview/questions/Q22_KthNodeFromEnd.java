package com.jp.CodingInterview.questions;

import com.jp.CodingInterview.datastruct.ListNode;

import java.util.Arrays;
import java.util.stream.Collectors;

// 22：链表中倒数第k个结点
// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。
public class Q22_KthNodeFromEnd {

    public static ListNode<Integer> FindKthToTail(ListNode<Integer> head,int k){
        ListNode<Integer> p = head;
        for(int i=0;i<k;i++) {
            if(p==null)
                return null;
            p = p.next;
        }
        ListNode<Integer> q = head;
        while (p!=null){
            p = p.next;
            q = q.next;
        }
        return q;
    }

    public static void Test(int[] array,int k,int expected){
        ListNode<Integer> head = new ListNode<>(Arrays.stream(array).boxed().collect(Collectors.toList()));
        System.out.println(FindKthToTail(head,k).data==expected);
    }

    public static void main(String[] args){
        Test(new int[]{1,2,3,4,5,6},2,5);
    }
}


package com.jp.CodingInterview;

// 面试题6：从尾到头打印链表
// 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
// 输入一个链表，按链表从尾到头的顺序返回一个ArrayList


import com.jp.datastruct.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q06_PrintListInReversedOrder {

    public static ArrayList<Integer> printListFromTailToHead(ListNode<Integer> listNode){
        if(listNode!=null) {
            ArrayList<Integer> tailList = printListFromTailToHead(listNode.next);
            tailList.add(listNode.data);
            return tailList;
        }else{
            return new ArrayList<Integer>();
        }
    }

    public static void main(String[] args){
        List data = Arrays.asList(1,2,3,4,5);
        ListNode<Integer> listNode = new ListNode<>(data);
        ArrayList<Integer> inverseList = printListFromTailToHead(listNode);
        System.out.println(inverseList);
    }
}

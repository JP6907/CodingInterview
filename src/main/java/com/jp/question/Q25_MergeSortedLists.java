package com.jp.question;


// 面试题25：合并两个排序的链表
// 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
// 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
// 表3所示。

//递归

import com.jp.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

public class Q25_MergeSortedLists {

    static ListNode<Integer> Merge(ListNode<Integer> pHead1,ListNode<Integer> pHead2){
        if(pHead1==null)
            return pHead2;
        else if(pHead2==null)
            return pHead1;

        ListNode<Integer> pMergeHead = null;
        if(pHead1.data<pHead2.data){
            pMergeHead = pHead1;
            pMergeHead.setNext(Merge(pHead1.next,pHead2));
        }else{
            pMergeHead = pHead2;
            pMergeHead.setNext(Merge(pHead1,pHead2.next));
        }
        return pMergeHead;
    }

    public static void main(String[] args){
        List<Integer> data1 = Arrays.asList(1,3,5,7,8,9);
        ListNode<Integer> pHead1 = new ListNode<Integer>(data1);
        List<Integer> data2 = Arrays.asList(2,4,6,8,10);
        ListNode<Integer> pHead2 = new ListNode<Integer>(data2);
        ListNode<Integer> pMergeHead = Merge(pHead1,pHead2);
        System.out.println(pMergeHead);

    }
}

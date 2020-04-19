package com.jp.CodingInterview.questions;

// 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

import com.jp.CodingInterview.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

public class Q23_EntryNodeInListLoop2 {

    //1. 判断是否存在环
    //2. 求环的长度
    //3. 求环的入口
    public static ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode node = IsExistCycle(pHead);
        if(node==null) //不存在环
            return null;
        //计算环中节点数量
        int count = 1;
        ListNode p = node.next;
        while (p!=node){
            count++;
            p = p.next;
        }
        //求环中入口
        //slow和fast
        //fast先走cout步
        //slow和fast同时走，在入口处相遇
        ListNode slow = pHead;
        ListNode fast = pHead;
        for(int i=0;i<count;i++)
            fast = fast.next;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    //存在环：返回环中其中一个节点
    //不存在：返回null
    public static ListNode IsExistCycle(ListNode head){
        if(head==null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=null&&fast!=null){
            if(slow==fast)
                return fast;
            //slow走一步
            slow = slow.next;
            //fast走两步
            fast = fast.next;
            if(fast!=null)
                fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        ListNode<Integer> pHead = new ListNode<Integer>(list);
        ListNode<Integer> node = IsExistCycle(pHead);
        System.out.println("存在环？" + (node!=null));
        ListNode<Integer> node3 = pHead.next.next;
        ListNode<Integer> node5 = node3.next.next;
        node5.next = node3;   //5指向3，创建环
        node = IsExistCycle(pHead);
        System.out.println("存在环？" + (node!=null));

        ListNode<Integer> entryNodeOfLoop = EntryNodeOfLoop(pHead);
        System.out.println(entryNodeOfLoop.data);
    }
}

package com.jp.CodingInterview;


import com.jp.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

// 面试题23：链表中环的入口结点
// 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
// 环的入口结点是结点3。
// 思路：
// 1. 判断是否存在环
// 2. 环中节点计数
// 3. 寻找入口
public class Q23_EntryNodeInListLoop {

    //判断是否存在环
    //若存在，返回环中其中一个节点
    //若不存在，返回null
    //使用两个节点，快慢节点，慢节点一次走一步，快节点一次走两步
    //如果快节点能够遇见慢节点，说明存在环
    //而且相遇的时候的节点在环中
    static ListNode<Integer> MeetingNode(ListNode<Integer> pHead){
        if(pHead==null)
            return null;
        ListNode<Integer> pSlow = pHead;
        ListNode<Integer> pFast = pSlow.next;
        while(pSlow!=null&&pFast!=null){
            if(pSlow==pFast)
                return pFast;
            pSlow = pSlow.next; //走一步
            pFast = pFast.next;
            if(pFast!=null)  //走两步
                pFast = pFast.next;
        }
        return pFast;
    }

    //寻找环的入口
    static ListNode<Integer> EntryNodeIfLoop(ListNode<Integer> pHead){
        //判断是否存在环，找出环中其中一个节点
        ListNode<Integer> node = MeetingNode(pHead);
        if(node==null)//不存在环
            return null;

        //根据前面求出环中节点，计算环中节点数量
        int count = 1;
        ListNode<Integer> loopNode = node.next;
        while(loopNode!=node){
            count++;
            loopNode = loopNode.next;
        }

        //寻找环的入口
        //两个指针
        //第一个指针从开头先走count步，第二个指针从开头开始
        //接下来两个指针同步走
        //当到达入口处时，第一个指针刚好走完所有节点，两个指针在环的入口处相遇
        ListNode<Integer> pSlow = pHead;
        ListNode<Integer> pFast = pHead;
        for(int i=0;i<count;i++)
            pFast = pFast.next;

        while (pFast!=pSlow){
            pSlow = pSlow.next;
            pFast = pFast.next;
        }

        return pFast;
    }


    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        ListNode<Integer> pHead = new ListNode<Integer>(list);
        ListNode<Integer> node = MeetingNode(pHead);
        System.out.println("存在环？" + (node!=null));
        ListNode<Integer> node3 = pHead.next.next;
        ListNode<Integer> node5 = node3.next.next;
        node5.next = node3;   //5指向3，创建环
        node = MeetingNode(pHead);
        System.out.println("存在环？" + (node!=null));

        ListNode<Integer> entryNodeOfLoop = EntryNodeIfLoop(pHead);
        System.out.println(entryNodeOfLoop.data);
    }
}

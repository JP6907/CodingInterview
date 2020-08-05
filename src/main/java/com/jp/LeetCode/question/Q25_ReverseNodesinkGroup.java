package com.jp.LeetCode.question;

//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//Example:
//
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5
//
//Note:
//
//Only constant extra memory is allowed.
//You may not alter the values in the list's nodes, only nodes itself may be changed.

import com.jp.LeetCode.datastruct.ListNode;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.Arrays;
import java.util.List;

//每k个进行反转，不足k个不反转
public class Q25_ReverseNodesinkGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode start = head;
        ListNode end = head;
        for(int i=0;i<k;i++){
            if(end==null)
                return start;
            end = end.next;
        }
        //反转前k个
        ListNode newHead = reverse(start,end);
        //递归
        start.next = reverseKGroup(end,k);
        return newHead;
    }

    //链表的头尾节点分别为a、b
    //返回反转链表的新头节点，应该是b
        public static ListNode reverse(ListNode a,ListNode b){
            ListNode pre = null;
            ListNode cur = a;
            ListNode next = a;
            //pre为已经反转连接好的最后一个节点
            while (cur!=b){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }


    public static ListNode reverseKGroup2(ListNode head, int k){
        ListNode node = head;
        int i=0;
        for(;i<k&&node!=null;i++)
            node = node.next;
        if(i!=k&&node==null)
            return head;
        ListNode p = head;
        ListNode pre = null;
        ListNode next = head;
        while (p!=node){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        head.next = reverseKGroup2(node,k);
        return pre;
    }

    public static void test(List<Integer> data,int k){
        ListNode list = new ListNode(data);
        //System.out.println(data.toString());
        ListNode newHead = reverseKGroup(list,k);
        System.out.println(newHead.toString());
        System.out.println("====");
        list = new ListNode(data);
        newHead = reverseKGroup2(list,k);
        System.out.println(newHead.toString());
        System.out.println("====");
        list = new ListNode(data);
        newHead = reverseKGroup3(list,k);
        System.out.println(newHead.toString());
        System.out.println("====");
        list = new ListNode(data);
        newHead = reverseKGroup4(list,k);
        System.out.println(newHead.toString());
        System.out.println("====");
        list = new ListNode(data);
        newHead = reverseKGroup5(list,k);
        System.out.println(newHead.toString());
        System.out.println("====");
        System.out.println("====================");
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3,4,5),2);
        test(Arrays.asList(1,2),2);
    }


    public static ListNode reverseKGroup3(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode start = head;
        ListNode end = head;
        for(int i=0;i<k;i++){
            if(end == null){
                return start;
            }
            end = end.next;
        }
        ListNode newHead = reverse3(start, end);
        start.next = reverseKGroup3(end, k);
        return newHead;

    }

    //node1：包含
    //node2：不包含
    public static ListNode reverse3(ListNode node1, ListNode node2){
        ListNode pre = null;
        ListNode p = node1;
        ListNode next = node1;
        while (p != node2){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }


    public static ListNode reverseKGroup4(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        for(int i=0;i<k;i++){
            if(end == null){
                return start;
            }
            end = end.next;
        }
        ListNode newHead = reverse4(head, end);
        head.next = reverseKGroup4(end, k);
        return newHead;
    }


    public static ListNode reverse4(ListNode head, ListNode end){
        ListNode curr = head;
        ListNode pre = null;
        ListNode next = head.next;
        while (curr != end){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static ListNode reverse5(ListNode head, ListNode end){
        ListNode curr = head;
        ListNode next = curr.next;
        ListNode pre = null;
        while (curr != end){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static ListNode reverseKGroup5(ListNode head, int k){
        ListNode start = head;
        ListNode end = head;
        for(int i=0;i<k;i++){
            if(end == null){
                return start;
            }
            end = end.next;
        }
        ListNode newHead = reverse4(head, end);
        head.next = reverseKGroup4(end, k);
        return newHead;
    }
}


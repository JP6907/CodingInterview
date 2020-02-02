package com.jp.question;

// 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5


import com.jp.datastruct.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q18_02_DeleteDuplicatedNode {

    public static ListNode deleteDuplication(ListNode pHead){
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode p = pHead;
        ListNode next = p.next;
        ListNode newHead = pHead;
        //头节点重复，特殊处理
        while (p!=null&&(next=p.next)!=null&&next.val==p.val){
            //删除跟头节点重复的节点
            while (next!=null&&next.val==p.val){
                p.next = next.next;
                next.next = null;
                next = p.next;
            }
            //删除头节点
            newHead = p.next;
            p.next = null;
            p = newHead;
        }
        if(newHead==null||newHead.next==null)
            return newHead;
        ListNode pre = newHead;
        p = newHead.next;
        next = p.next;
        boolean isDuplicated = false;
        while (p!=null&&next!=null){
            if(p.val==next.val){
                isDuplicated = true;
                //删除next
                p.next = next.next;
                next.next = null;
                next = p.next;
            }else if(isDuplicated&&p.val!=next.val){
                isDuplicated = false;
                //删除p
                pre.next = next;
                p.next = null;
                p = next;
                next = next.next;
            }else{
                isDuplicated = false;
                //前进
                pre = p;
                p = next;
                next = next.next;
            }
        }
        //最后一个元素是重复元素
        if(isDuplicated){
            pre.next = null;
        }

        return newHead;
    }

    public static void Test(int[] data){
        List<Integer> list = Arrays.stream(data).boxed().collect(Collectors.toList());
        System.out.print(list.toString() + " -> ");
        ListNode<Integer> head = new ListNode<Integer>(list);
        ListNode<Integer> newHead = deleteDuplication(head);
        System.out.println(newHead==null?"null":newHead.toString());
    }

    public static void main(String[] args){
        Test(new int[]{1,2,3,3,4,4,5});
        Test(new int[]{1,2,3,4,5,6,7});
        Test(new int[]{1,1,1,1,1,1,2});
        Test(new int[]{1,1,1,1,1,1,1});
        Test(new int[]{1,1,2,2,3,3,4,4});
        Test(new int[]{1,1,2,3,3,4,5,5});
        Test(new int[]{1,2});
        Test(new int[]{1,1});
    }
}

package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.ListNode;

/**
 * @author zjp
 * @createTime 2020/7/23 23:12
 **/
public class Q_getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        int lenA = 0;
        while (pa != null){
            lenA++;
            pa = pa.next;
        }
        int lenB = 0;
        ListNode pb = headB;
        while (pb != null){
            lenB++;
            pb = pb.next;
        }
        pa = headA;
        pb = headB;
        while (lenA > lenB){
            pa = pa.next;
            lenA--;
        }
        while (lenB > lenA){
            pb = pb.next;
            lenB--;
        }
        while (pa != pb){
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }

}

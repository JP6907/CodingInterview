package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author zjp
 * @Description
 * @createTime 11:08
 **/
public class Q92_ReverseBetweenII {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1){
            return reverseN(head, n);
        }else {
            head.next = reverseBetween(head.next, m-1, n-1);
            return head;
        }
    }

    //反转前N个
    static ListNode successor = null;
    public static ListNode reverseN(ListNode head, int n) {
        if(n == 1 || head.next == null){
            //记录第n+1个节点
            successor = head.next;
            return head;
        }else {
            ListNode newHead = reverseN(head.next, n-1);
            head.next.next = head;
            head.next = successor;
            return newHead;
        }
    }

    public static void test(List<Integer> data,int m, int n){
        ListNode head = new ListNode(data);
        ListNode reverseHead = reverseBetween(head, m, n);
        System.out.println(reverseHead);
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3,4,5), 2, 4);
    }


}

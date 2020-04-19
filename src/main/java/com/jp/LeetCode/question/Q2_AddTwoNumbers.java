package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.ListNode;

import java.util.Arrays;
import java.util.List;

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Example:
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
public class Q2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        int sum = 0;
        ListNode result = null;
        ListNode current = result;
        while (p1!=null&&p2!=null){
            sum = carry + p1.val + p2.val;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            if(result==null){
                result = node;
                current = result;
            }else{
                current.next = node;
                current = node;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        p1 = (p1!=null?p1:p2);
        while (p1!=null){
            sum = carry + p1.val;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            if(result==null){
                result = node;
                current = result;
            }else{
                current.next = node;
                current = node;
            }
            p1 = p1.next;
        }
        return result;
    }

    public static void Test(List<Integer> list1,List<Integer> list2,List<Integer> expectedList){
        ListNode l1 = new ListNode(list1);
        ListNode l2 = new ListNode(list2);
        ListNode expected = new ListNode(expectedList);
        ListNode result = addTwoNumbers(l1,l2);
        while (expected!=null&&result!=null&&expected.val==result.val){
            expected = expected.next;
            result = result.next;
        }
        if(expected==null&&result==null)
            System.out.println("true");
        else
            System.out.println("false");
    }

    public static void main(String[] args) {
        Test(Arrays.asList(2,4,3),Arrays.asList(5,6,4),Arrays.asList(7,0,8));
        Test(Arrays.asList(4,3),Arrays.asList(5,6,4),Arrays.asList(9,9,4));
        Test(Arrays.asList(0),Arrays.asList(5,6,4),Arrays.asList(5,6,4));
    }

}
package com.jp.LeetCode.question;


//Given a singly linked list, determine if it is a palindrome.
//
//Example 1:
//
//Input: 1->2
//Output: false
//Example 2:
//
//Input: 1->2->2->1
//Output: true

import com.jp.LeetCode.datastruct.ListNode;

import java.util.List;

//判断是否为回文链表
public class Q234_PalindromeLinkedList {

    ListNode left;
    //方法1：递归方法
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right){
        //后序遍历
        if(right==null)
            return true;
        boolean res = traverse(right.next);
        res = res&&(left.val==right.val);
        left = left.next;
        return res;
    }

    //方法2：反转链表
    public boolean isPalindrome2(ListNode head) {
        if(head==null)
            return true;
        //快慢指针寻找中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转链表
        ListNode rightHalf;
        //偶数：o-o-slow-o-fast-o
        if(fast.next!=null) {
            fast = fast.next;
            rightHalf = reverse(slow.next,fast.next);
        }else {
            //奇数：o-o-o-slow-o-o-fast
            rightHalf = reverse(slow.next,fast.next);
        }
        ListNode p = head;
        boolean result = true;
        //比较
        while (rightHalf!=null){
            if(p.val!=rightHalf.val) {
                result = false;
                break;
            }
            rightHalf = rightHalf.next;
            p = p.next;
        }
        return result;

    }
    //不包含tail
    public ListNode reverse(ListNode head,ListNode tail){
        if(head==tail)
            return head;
        ListNode pre = null;
        ListNode p = head;
        ListNode next = head;
        while (p!=tail){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public void test(int[] data,boolean expected){
        ListNode head = new ListNode(data);
        System.out.println(isPalindrome(head)==expected);
        head = new ListNode(data);
        System.out.println(isPalindrome2(head)==expected);
        head = new ListNode(data);
        System.out.println(isPalindrome3(head)==expected);
        System.out.println("===");
    }


    public static void main(String[] args) {
        Q234_PalindromeLinkedList q = new Q234_PalindromeLinkedList();
        q.test(new int[]{1,2},false);
        q.test(new int[]{1,2,2,1},true);
        q.test(new int[]{1,0,0},false);
        q.test(new int[]{1},true);
    }

    public static boolean isPalindrome3(ListNode head) {
        //寻找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //偶数：slow指向第n/2个
        if(fast == null) {

        }else { //奇数：slow指向中点
            slow = slow.next;
        }
        //反转后半段
        ListNode head2 = reverse3(slow, null);
        //比较
        ListNode p1 = head;
        ListNode p2 = head2;
        while (p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    //不包含 tail
    public static ListNode reverse3(ListNode head, ListNode tail){
        ListNode pre = null;
        ListNode curr = head;
        ListNode next;
        while (curr != tail){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

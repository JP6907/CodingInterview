package com.jp.LeetCode.question;

//Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
//
//Follow up:
//What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
//
//Example:
//
//// Init a singly linked list [1,2,3].
//ListNode head = new ListNode(1);
//head.next = new ListNode(2);
//head.next.next = new ListNode(3);
//Solution solution = new Solution(head);
//
//// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
//solution.getRandom();

import com.jp.LeetCode.datastruct.ListNode;

import java.util.Random;

//水塘抽样
public class Q382_LinkedListRandomNode {

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    private ListNode head;
    Random random;


    public Q382_LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        //先选中第一个元素
        int res = head.val;
        int index = 1;
        ListNode p = head.next;
        while (p!=null){
            //[0,index)中选中0的概率为1/index
            if(random.nextInt(++index)==0){
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}

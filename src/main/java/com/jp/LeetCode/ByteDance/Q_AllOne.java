package com.jp.LeetCode.ByteDance;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author zjp
 * @createTime 2020/7/26 9:20
 **/
public class Q_AllOne {

    static class AllOne{

        public Node head;
        public Node tail;
        public Map<String, Node> map;

        /** Initialize your data structure here. */
        public AllOne() {
            map = new HashMap<>();
            head = new Node("head", -1);
            tail = new Node("tail", -1);
            head.next = tail;
            tail.pre = head;
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            map.merge(key, new Node(key, 1), (oldNode, newNode) -> {
                oldNode.val++;
                return oldNode;
            });
            map.get(key).moveToTail(head, tail);
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            Node temp = map.get(key);
            map.computeIfPresent(key, (k, v) -> {
                if(--v.val == 0){
                    return null;
                } else {
                    return v;
                }
            });
            if(map.containsKey(key)){
                map.get(key).moveToHead(tail);
            } else {
                if(temp != null) {
                    temp.delete();
                }
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if(map.isEmpty()){
                return "";
            } else {
                return tail.pre.key;
            }
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if(map.isEmpty()){
                return "";
             } else {
                return head.next.key;
            }

        }

        class Node{
            public Node pre;
            public Node next;
            public String key;
            public int val;

            public Node(String key, int val) {
                this.key = key;
                this.val = val;
                this.pre = null;
                this.next = null;
            }

            public void moveToHead(Node head){
                while (pre != head && this.val < pre.val){
                    pre.next = next;
                    next.pre = pre;
                    Node temp = pre;
                    pre = temp.pre;
                    this.next = temp;
                    temp.pre = this;
                    pre.next = this;
                }
            }

            public void moveToTail(Node head, Node tail){
                //新节点，值一定为1，直接插入头部
                if(pre == null && next == null){
                    Node next = head.next;
                    this.next = next;
                    next.pre = this;
                    this.pre = head;
                    head.next = this;
                } else if(next != tail){
                    while (next != tail && next.val < this.val){
                        pre.next = next;
                        next.pre = pre;
                        Node temp = next;
                        next = temp.next;
                        temp.next = this;
                        this.pre = temp;
                        next.pre = this;
                    }
                }
            }

            public void delete(){
                pre.next = next;
                next.pre = pre;
                pre = null;
                next = null;
            }
        }
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        allOne.inc("leet");
        allOne.inc("code");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        System.out.println(allOne.getMaxKey());
    }

}

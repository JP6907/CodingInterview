package com.jp.LeetCode.datastruct;

import java.util.Arrays;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int data, ListNode next) {
        this.next = next;
        this.val = data;
    }


    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int[] data){
        this.val = data[0];
        ListNode current = this;
        for(int i=1;i<data.length;i++){
            ListNode next = new ListNode(data[i],null);
            current.setNext(next);
            current = next;
        }
    }

    public ListNode(List<Integer> list){
        this.val = list.get(0);
        ListNode current = this;
        for(int i=1;i<list.size();i++){
            ListNode next = new ListNode(list.get(i),null);
            current.setNext(next);
            current = next;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        ListNode current = this;
        ListNode next = current.next;
        while(next!=null){
            sb.append(current.val + ",");
            current = next;
            next = next.next;
        }
        sb.append(current.val);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        List<Integer> data = Arrays.asList(1,3,5,7);
        ListNode list = new ListNode(data);
        System.out.println(list.toString());
    }
}
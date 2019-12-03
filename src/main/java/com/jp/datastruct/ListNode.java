package com.jp.datastruct;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode(List<T> list){
        assert data!=null && list.size()>=1;
        this.data = list.get(0);
        ListNode<T> current = this;
        for(int i=1;i<list.size();i++){
            ListNode<T> next = new ListNode<T>(list.get(i),null);
            current.setNext(next);
            current = next;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        ListNode<T> current = this;
        ListNode<T> next = current.next;
        while(next!=null){
            sb.append(current.data + ",");
            current = next;
            next = next.next;
        }
        sb.append(current.data);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        List<Integer> data = Arrays.asList(1,3,5,7);
        ListNode<Integer> list = new ListNode<Integer>(data);
        System.out.println(list.toString());
    }
}

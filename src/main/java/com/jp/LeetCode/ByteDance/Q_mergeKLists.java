package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zjp
 * @createTime 2020/7/23 23:17
 **/
public class Q_mergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        } else if(lists.length == 1){
            return lists[0];
        }
        ListNode[] p = new ListNode[lists.length];
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        ListNode head;
        ListNode curr;
        for(int i=0;i<lists.length;i++){
            p[i] = lists[i];
            if(p[i] != null) {
                if(p[i].val < min){
                    min = p[i].val;
                    minIndex = i;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return null;
        }
        head = p[minIndex];
        curr = head;
        p[minIndex] = p[minIndex].next;
        while (true){
            boolean flag = true;
            min = Integer.MAX_VALUE;
            for(int i=0;i<lists.length;i++){
                if(p[i] != null){
                    flag = false;
                    if(p[i].val < min){
                        min = p[i].val;
                        minIndex = i;
                    }
                }
            }
            if(!flag){
                curr.next = p[minIndex];
                p[minIndex] = p[minIndex].next;
                curr = curr.next;
            } else {
                break;
            }
        }
        return head;

    }

    public static void test(ListNode[] lists){
        mergeKLists(lists);
    }

    public static void main(String[] args) {
        test(new ListNode[]{null, null});
    }
}

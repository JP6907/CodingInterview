package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.ListNode;

/**
 * @author shangqiu
 * @createTime 2020/8/5
 **/
public class Q143_reorderList {

    public void reorderList(ListNode head) {
        //头插法
        ListNode p1 = head;
        ListNode p2 = null;
        ListNode next = null;
        while (p1 != null){
            next = p1.next;
            if(next == null){
                break;
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Q143_reorderList.class.getName());
        String className = Q143_reorderList.class.getName();
        Class<?> aClass = Class.forName(className);
        System.out.format(aClass.getName());
        System.out.println(Integer.TYPE.getName());
    }

}

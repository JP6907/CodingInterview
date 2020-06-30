package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zjp
 * @Description
 * @createTime 19:28
 **/
public class Q1019_NextLargerNodes {

    public static int[] nextLargerNodes(int[] nums) {
        //储存索引
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while (!stack.empty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            result[i] = stack.empty()?0:stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> data = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            data.add(p.val);
            p = p.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[data.size()];
        for(int i=data.size()-1;i>=0;i--){
            while (!stack.empty()&&stack.peek()<=data.get(i)){
                stack.pop();
            }
            result[i] = stack.empty()?0:stack.peek();
            stack.push(data.get(i));
        }
        return result;
    }

    public static void test(int[] nums, int[] expected){
        System.out.println(Arrays.equals(nextLargerNodes(nums), expected));
        //System.out.println(Arrays.toString(nextLargerNodes(nums)));
    }

    public static void main(String[] args) {
        test(new int[]{2,1,5}, new int[]{5,5,0});
        test(new int[]{2,7,4,3,5}, new int[]{7,0,5,5,0});
        test(new int[]{1,7,5,1,9,2,5,1}, new int[]{7,9,9,9,0,5,0,0});
    }

}

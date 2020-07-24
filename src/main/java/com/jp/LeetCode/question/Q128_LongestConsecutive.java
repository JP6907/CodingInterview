package com.jp.LeetCode.question;

import java.util.PriorityQueue;

/**
 * @author shangqiu
 * @createTime 2020/7/20
 **/
public class Q128_LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums){
            heap.add(num);
        }
        int count = 1;
        int max = 1;
        int last = heap.poll();
        while (!heap.isEmpty()){
            int curr = heap.poll();
            if(last == curr){
                continue;
            }
            if(last + 1 == curr){
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
            last = curr;
        }
        return max;
    }

    public static void test(int[] nums, int expected){
        System.out.println(longestConsecutive(nums) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{100, 4, 200, 1, 3, 2}, 4);
        test(new int[]{1,2,0,1}, 3);
    }

}

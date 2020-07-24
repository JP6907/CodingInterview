package com.jp.LeetCode.ByteDance;

import java.util.Arrays;

/**
 * @author shangqiu
 * @createTime 2020/7/23
 **/
public class Q_findKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void test(int[] nums, int k, int expected){
        System.out.println(findKthLargest(nums, k) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{3,2,1,5,6,4}, 2, 5);
        test(new int[]{3,2,3,1,2,4,5,5,6}, 4, 4);
    }

}

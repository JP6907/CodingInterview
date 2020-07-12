package com.jp.LeetCode.question;


import java.util.Arrays;

/**
 * @author zjp
 * @createTime 2020/7/12 17:14
 **/
public class Q26_RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int slow = 0, fast = 0;
        while (fast < nums.length){
            nums[slow++] = nums[fast++];
            while (fast > 0 && fast < nums.length && nums[fast] == nums[fast-1]){
                fast++;
            }
        }
        return slow;
    }

    public static void test(int[] nums, int expected){
        System.out.println(removeDuplicates(nums) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{1,1,2}, 2);
        test(new int[]{0,0,1,1,1,2,2,3,3,4}, 5);
    }
}

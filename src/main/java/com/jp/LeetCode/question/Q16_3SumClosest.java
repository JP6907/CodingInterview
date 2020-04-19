package com.jp.LeetCode.question;

//Given an array nums of n integers and an integer target,
// find three integers in nums such that the sum is closest to target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//Example:
//
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

import java.util.Arrays;

public class Q16_3SumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int maxDiff = Integer.MAX_VALUE;
        int similarSum = 0;
        int currentSum = 0;
        int currentDiff = 0;
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                currentSum = nums[i] + nums[left] + nums[right];
                currentDiff = Math.abs(currentSum-target);
                if(currentDiff<maxDiff) {
                    maxDiff = currentDiff;
                    similarSum = currentSum;
                }
                if(currentSum<target)
                    left++;
                else if(currentSum>target)
                    right--;
                else
                    return target;
            }
        }
        return similarSum;
    }

    public static void Test(int[] nums, int target,int expected){
        System.out.println(threeSumClosest(nums,target)==expected);
    }

    public static void main(String[] args) {
        Test(new int[]{-1, 2, 1, -4},1,2);
    }

}

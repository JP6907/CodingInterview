package com.jp.LeetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//
//The solution set must not contain duplicate triplets.
//
//Example:
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
public class Q15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            //去重
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int expected = 0-nums[i];
            int left = i+1,right = nums.length-1;
            while (left<right){
                int sum = nums[left]+nums[right];
                if(sum==expected){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    //去重
                    while (left<nums.length&&nums[left]==nums[left-1])
                        left++;
                    while (right>i&&nums[right]==nums[right+1])
                        right--;
                }else if(sum<expected){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void Test(int[] nums){
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> l : result){
            System.out.println(l.toString());
        }
        System.out.println("--");
        result = threeSum2(nums);
        for(List<Integer> l : result){
            System.out.println(l.toString());
        }
        System.out.println("===");
    }

    public static void main(String[] args) {
        Test(new int[]{-1, 0, 1, 2, -1, -4});
        Test(new int[]{-2,0,0,2,2});
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++){
            while (i> 0 && i < len - 2 && nums[i-1] == nums[i]){
                i++;
            }
            List<ArrayList<Integer>> pair = twoSum2(nums, i + 1, len - 1, 0 - nums[i]);
            for(List<Integer> p : pair){
                p.add(nums[i]);
                result.add(p);
            }
        }
        return result;
    }

    public static List<ArrayList<Integer>> twoSum2(int[] nums, int left, int right, int target){
        List<ArrayList<Integer>> result = new ArrayList<>();
        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                result.add(pair);
                left++;
                right--;
                while (left < right && nums[left - 1] == nums[left]){
                    left++;
                }
                while (left < right && nums[right + 1] == nums[right]){
                    right--;
                }
            } else if(sum < target){
                left++;
                while (left < right && nums[left - 1] == nums[left]){
                    left++;
                }
            } else {
                right--;
                while (left < right && nums[right + 1] == nums[right]){
                    right--;
                }
            }
        }
        return result;
    }
}

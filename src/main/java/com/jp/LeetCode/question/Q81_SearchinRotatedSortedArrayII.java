package com.jp.LeetCode.question;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
//
//You are given a target value to search. If found in the array return true, otherwise return false.
//
//Example 1:
//
//Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
//Example 2:
//
//Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
//Follow up:
//
//This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
//Would this affect the run-time complexity? How and why?


public class Q81_SearchinRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        if(nums.length==0)
            return false;
        else if(nums.length==1)
            return nums[0]==target;
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return true;
            else{
                if(nums[mid]<=nums[right]){//右边有序
                    if(target>nums[mid]&&target<=nums[right])
                        left = mid+1;
                    else
                        right = mid-1;
                }else{//左边有序
                    if(target>=nums[left]&&target<nums[mid])
                        right = mid-1;
                    else
                        left = mid+1;
                }
            }
        }
        return false;
    }

    public static void Test(int[] nums, int target,boolean expected){
        System.out.println(search(nums,target)==expected);
    }

    public static void main(String[] args) {
        Test(new int[]{2,5,6,0,0,1,2},0,true);
        Test(new int[]{2,5,6,0,0,1,2},3,false);
        Test(new int[]{3,1,1},3,true);
    }
}

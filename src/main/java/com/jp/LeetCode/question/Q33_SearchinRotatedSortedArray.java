package com.jp.LeetCode.question;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//Example 1:
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1

public class Q33_SearchinRotatedSortedArray {

    //二分查找的高级版
    //比较 mid 和 right的大小，就能知道做边有序还是右边有序
    //判断target是否在有序的部分中
    public static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        else if(nums.length==1&&nums[0]==target)
            return 0;
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return mid;
            else{
                if(nums[mid]<nums[right]){//右边有序
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
        return -1;
    }

    public static void Test(int[] nums, int target,int expected){
        System.out.println(search(nums,target)==expected);
    }

    public static void main(String[] args) {
        Test(new int[]{4,5,6,7,0,1,2},0,4);
        Test(new int[]{4,5,6,7,0,1,2},3,-1);
    }

}

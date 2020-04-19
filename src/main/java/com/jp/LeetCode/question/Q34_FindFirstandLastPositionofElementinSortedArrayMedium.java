package com.jp.LeetCode.question;

//Given an array of integers nums sorted in ascending order,
// find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]

//找到其中一个位置
//然后分别往左边和右边寻找第一个和最后一个出现的位置
//三次寻找均用二分法
public class Q34_FindFirstandLastPositionofElementinSortedArrayMedium {

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1,-1};
        if(nums.length==1)
            return nums[0]==target?new int[]{0,0}:new int[]{-1,-1};

        //找到其中一个位置
        int left=0,right=nums.length-1;
        int index=-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) {
                index = mid;
                break;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(index==-1)
            return new int[]{-1,-1};
        int start=index,end=index;
        //找到第一个
        left = 0;
        right = index;
        while (left<=right){
            int mid = (left+right)/2;
            //只可能等于或者小于
            if(nums[mid]==target){
                if(mid==0||(nums[mid-1]!=target)){
                    start = mid;
                    break;
                }else{
                    right = mid-1;
                }
            }else{
                left = mid+1;
            }
        }
        //找到最后一个
        left = index;
        right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            //只可能等于或者大于
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid+1]!=target){
                    end = mid;
                    break;
                }else{
                    left = mid+1;
                }
            }else {
                right = mid-1;
            }
        }
        return new int[]{start,end};
    }

    public static void Test(int[] nums, int target,int[] expected){
        int[] result = searchRange(nums,target);
        System.out.println(result[0]==expected[0]&&result[1]==expected[1]);
    }

    public static void main(String[] args) {
        Test(new int[]{5,7,7,8,8,10},8,new int[]{3,4});
        Test(new int[]{5,7,7,8,8,10},6,new int[]{-1,-1});
        Test(new int[]{1},1,new int[]{0,0});
    }
}

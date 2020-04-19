package com.jp.LeetCode.question;

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//Example:
//
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//Follow up:
//
//If you have figured out the O(n) solution,
// try coding another solution using the divide and conquer approach, which is more subtle.

public class Q53_MaximumSubarray {
    //动态规划
    //f(i)表示i结束的最大连续子集和
    //f(i)>0  f(i+1)=f(i)+num[i+1]
    //f(i)<=0  f(i+1)=num[i+1]
    //不需要保存所有值
    public static int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
//        int[] f = new int[nums.length];
//        f[0] = nums[0];
        int curr = nums[0];
        int max = curr;
        for(int i=1;i<nums.length;i++){
            if(curr>0)
                curr += nums[i];
            else
                curr = nums[i];
            if(curr>max)
                max = curr;
        }
        return max;
    }

    //分治算法divide and conquer
    //左边最大连续和  右边最大连续和  包含中间的最大连续和
    public static int maxSubArray2(int[] nums){
        return maxSubArrayDC(nums,0,nums.length-1);
    }

    public static int maxSubArrayDC(int[] nums,int left,int right){
        if(left==right)
            return nums[left];
        else if(left<right) {
            int mid = (left + right) / 2;
            int leftMax = maxSubArrayDC(nums,left,mid-1);
            int rightMax = maxSubArrayDC(nums,mid+1,right);
            int midMax = nums[mid];
            int curr = nums[mid];
            for(int i=mid-1;i>=left;i--){
                curr += nums[i];
                midMax = (curr>midMax?curr:midMax);
            }
            curr = midMax;
            for(int i=mid+1;i<=right;i++){
                curr += nums[i];
                midMax = (curr>midMax?curr:midMax);
            }
            return Math.max(Math.max(leftMax,rightMax),midMax);
        }else{
            return Integer.MIN_VALUE;
        }
    }

    public static void test(int[] nums,int expected){
        System.out.println(maxSubArray(nums)==expected);
    }

    public static void test2(int[] nums,int expected){
        System.out.println(maxSubArray2(nums)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{-2,1,-3,4,-1,2,1,-5,4},6);
        test2(new int[]{-2,1,-3,4,-1,2,1,-5,4},6);
    }
}

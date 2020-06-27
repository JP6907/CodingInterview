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
        test34(new int[]{-2,1,-3,4,-1,2,1,-5,4},6);
    }


    //动态规划的两种思路，两种状态转移：
    //第一种：
    //f(n) 表示前n个数的最大子序和，这种表示方法f(n)和f(n-1)之间没有直接的关系
    //需要再增加一个状态:f(n)(0)表示前n个数中，不选num[n]的最大子序和，f(n)(1)表示选num[n]，则：
    //  f(n)(0) = max{f(n-1)(0),f(n-1)(1)}
    //  f(n)(1) = max{f(n-1)(1)+num[n],num[n]}
    //初始状态：
    //  f(0)(0) = Integer.MIN_VALUE
    //  f(0)(1) = num[0]
    //结果：
    //  max{f(n)(0),f((n)(1)}
    public static int maxSubArray3(int[] nums){
        int n = nums.length;
        int[][] f = new int[n][2];
        f[0][0] = Integer.MIN_VALUE;
        f[0][1] = nums[0];
        for(int i=1;i<n;i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][1]);
            f[i][1] = Math.max(f[i-1][1]+nums[i],nums[i]);
        }
        return Math.max(f[n-1][0],f[n-1][1]);
    }

    //第二种思路：
    //f(n) 表示以n为结尾的最大子序和
    //  f(n) = max{f(n-1)+num[n],num[n]}
    //初始状态:
    //  f(0) = num[0]
    //结果：
    //  max(f(i)) i=1,....n
    public static int maxSubArray4(int[]  nums){
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int result = f[0];
        for(int i=1;i<n;i++){
            f[i] = Math.max(f[i-1]+nums[i],nums[i]);
            result = Math.max(result,f[i]);
        }
        return result;
    }

    public static void test34(int[] nums,int expected){

        System.out.println(maxSubArray3(nums)==expected);
        System.out.println(maxSubArray4(nums)==expected);
    }
}

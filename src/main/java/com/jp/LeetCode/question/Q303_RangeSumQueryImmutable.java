package com.jp.LeetCode.question;

//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//Example:
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
//Note:
//You may assume that the array does not change.
//There are many calls to sumRange function.

public class Q303_RangeSumQueryImmutable {
    //sum[i] = 0....i-1
    static class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length+1];
            for(int i=1;i<=nums.length;i++){
                sum[i] = sum[i-1]+nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            if(i>=sum.length||j<0)
                return 0;
            return sum[j+1]-sum[i];
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,2)==1);
        System.out.println(numArray.sumRange(2,5)==-1);
        System.out.println(numArray.sumRange(0,5)==-3);
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

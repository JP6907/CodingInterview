package com.jp.LeetCode.question;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//Example 1:
//
//Input: [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
//             because they are adjacent houses.
//Example 2:
//
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.

//非环形的时候 dp[i] = Max(dp[i-1],dp[i-2]+house[i])
//环形的时候，若第0个房子被选中，则最后一个房子不能选
public class Q213_HouseRobberII {

    public static int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int n = nums.length;
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }

    public static int rob(int[] nums,int start,int end){
        int pre2=0,pre1=0;
        for(int i=start;i<=end;i++){
            int curr = Math.max(pre1,pre2+nums[i]);
            pre2 = pre1;
            pre1 = curr;
        }
        return pre1;
    }

    public static void test(int[] nums,int expected){
        System.out.println(rob(nums)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{2,3,2},3);
        test(new int[]{1,2,3,1},4);
    }
}

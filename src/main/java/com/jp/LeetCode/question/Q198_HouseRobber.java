package com.jp.LeetCode.question;

//You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house,
// determine the maximum amount of money you can rob tonight without alerting the police.
//
//Example 1:
//
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
//Example 2:
//
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.

//动态规划
//抢劫一排住户，抢劫某住户后，则不能抢劫邻居住户，求能抢劫到的最大金额数量
//dp[i] = Max(dp[i-1],dp[i-2]+house[i])

public class Q198_HouseRobber {

    public static int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
    //取出dp数组，迭代进行
    public static int rob2(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int pre2 = nums[0];
        int pre1 = Math.max(nums[1],nums[0]);
        for(int i=2;i<nums.length;i++){
            int curr = Math.max(pre2+nums[i],pre1);
            pre2 = pre1;
            pre1 = curr;
        }
        return pre1;
    }

    public static void test(int[] nums,int expected){
        System.out.println(rob(nums)==expected);
        System.out.println(rob2(nums)==expected);
        System.out.println("===");
    }

    public static void main(String[] args) {
        test(new int[]{1,2,3,1},4);
        test(new int[]{2,7,9,3,1},12);
        test(new int[]{2,1,1,2},4);
    }
}

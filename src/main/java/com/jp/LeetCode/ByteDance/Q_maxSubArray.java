package com.jp.LeetCode.ByteDance;

/**
 * @author zjp
 * @createTime 2020/7/25 19:57
 **/
public class Q_maxSubArray {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<n;i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static int maxSubArray2(int[] nums) {
        return maxSubArrayCore(nums, 0, nums.length - 1);
    }

    public static int maxSubArrayCore(int[] nums, int left, int right) {
        if(left < right){
            int mid = left + (right - left)/2;
            int leftMax = maxSubArrayCore(nums, left, mid);
            int rightMax = maxSubArrayCore(nums, mid + 1, right);
            int midMax = nums[mid];
            int currSum = nums[mid];
            for(int i = mid + 1; i <= right; i++){
                currSum += nums[i];
                midMax = Math.max(midMax, currSum);
            }
            currSum = midMax;
            for(int i = mid - 1; i >= left; i--){
                   currSum += nums[i];
                   midMax = Math.max(midMax, currSum);
            }
            return Math.max(Math.max(leftMax, rightMax), midMax);
        } else if(left == right){
            return nums[left];
        } else {
            return 0;
        }
    }

    public static void test(int[] nums, int expected){
        System.out.println(maxSubArray(nums) == expected);
        System.out.println(maxSubArray2(nums) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6);
    }
}

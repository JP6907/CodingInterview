package com.jp.LeetCode.question;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//Example:
//
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index.

//dp[k]表示经过多少跳能够到达最后的位置
//-1表示未知，-2表示不可达
public class Q45_JumpGameII {

    public static int jump(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int[] memo = new int[n];
        for(int i=0;i<n;i++)
            memo[i] = -1;//未知
        memo[n-1] = 0;
        //从后往前
        for(int i=n-2;i>=0;i--){
            int furtherPosition = i + nums[i];
            if(furtherPosition>=n-1)
                memo[i] = 1;//一次可达
            else{
                boolean flag = false;
                for(int j=i+1;j<=furtherPosition;j++){
                    //跳到j位置可达
                    if(memo[j]>0){
                        flag = true;
                        if(memo[i]<0)
                            memo[i] = memo[j]+1;
                        else {
                            memo[i] = Math.min(memo[i],memo[j]+1);
                        }
                    }
                }
                //不可达
                if(!flag)
                    memo[i] = -2;
            }
        }
        return memo[0];
    }

    public static void test(int[] nums,int expected){
        System.out.println(jump(nums)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{2,3,1,1,4},2);
    }
}

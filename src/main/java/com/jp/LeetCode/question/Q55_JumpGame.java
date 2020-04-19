package com.jp.LeetCode.question;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//Example 1:
//
//Input: [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//Example 2:
//
//Input: [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum
//             jump length is 0, which makes it impossible to reach the last index.
//从后往前找
//先找出能跳到最后一个位置的所有位置
//然后以这些位置为最后一个位置递归查找，直至第一个位置
public class Q55_JumpGame {

    static enum Index{
        GOOD,BAD,UNKNOWN
    }
    static Index[] memo;

//    public boolean canJump(int[] nums) {
//
//    }

    //方法一：回溯算法

    //方法二：动态规划：从前往后
    //memo[]数组表示从当前位置出发能够到达重点，记录每个位置，相比回溯法，不需要重复判断

    static boolean canJumpFromPosition(int position,int[] nums){
        if(memo[position]!= Index.UNKNOWN){
            return memo[position]== Index.GOOD?true:false;
        }else{
            int furtherPosition = Math.min(position + nums[position],nums.length-1);
            for(int i=position+1;i<=furtherPosition;i++){
                if(canJumpFromPosition(i,nums)) {
                    memo[position] = Index.GOOD;
                    return true;
                }
            }
            memo[position] = Index.BAD;
            return false;
        }
    }

    public static boolean canJump1(int[] nums) {
        memo = new Index[nums.length];
        for (int i=0;i<nums.length-1;i++)
            memo[i] = Index.UNKNOWN;
        memo[nums.length-1] = Index.GOOD;
        return canJumpFromPosition(0,nums);
    }

    //动态规划，从后往前
    public static boolean canJump2(int[] nums){
        memo = new Index[nums.length];
        for (int i=0;i<nums.length-1;i++)
            memo[i] = Index.UNKNOWN;
        memo[nums.length-1] = Index.GOOD;
        for(int i=nums.length-2;i>=0;i--){
            int furtherPosition = Math.min(i+nums[i],nums.length-1);
            for(int j=i+1;j<=furtherPosition;j++){
                if(memo[j]== Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0]== Index.GOOD;
    }

    public static void test(int[] nums,boolean expected){
        System.out.println("======");
        System.out.println(canJump1(nums)==expected);
        System.out.println(canJump2(nums)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{2,3,1,1,4},true);
        test(new int[]{3,2,1,0,4},false);
    }
}

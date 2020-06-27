package com.jp.CodingInterview.questions;

//数组中重复的数字
//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
public class Q03 {

    public int findRepeatNumber(int[] nums) {

        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }
}

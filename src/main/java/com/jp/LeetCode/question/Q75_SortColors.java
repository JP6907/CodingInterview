package com.jp.LeetCode.question;

//Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Note: You are not suppose to use the library's sort function for this problem.
//
//Example:
//
//Input: [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//Follow up:
//
//A rather straight forward solution is a two-pass algorithm using counting sort.
//First, iterate the array counting number of 0's, 1's, and 2's,
// then overwrite array with total number of 0's, then 1's and followed by 2's.
//Could you come up with a one-pass algorithm using only constant space?

import java.util.Arrays;

public class Q75_SortColors {
    //三个指针，两个指示0和2的位置
    //一个作为遍历
    public static void sortColors(int[] nums) {
        int index0 = -1,index2 = nums.length;
        for(int i=0;i<index2;i++){
            if(nums[i]==0){
                index0++;
                int temp = nums[i];
                nums[i] = nums[index0];
                nums[index0] = temp;
            }else if(nums[i]==2){
                index2--;
                int temp = nums[i];
                nums[i] = nums[index2];
                nums[index2] = temp;
                i--; //以防止交换过来的还是2
            }
        }
    }

    public static void test(int[] nums){
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        test(new int[]{2,0,2,1,1,0});
    }
}

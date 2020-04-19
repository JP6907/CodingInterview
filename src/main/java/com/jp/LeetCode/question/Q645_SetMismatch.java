package com.jp.LeetCode.question;

//The set S originally contains numbers from 1 to n. But unfortunately,
// due to the data error, one of the numbers in the set got duplicated to another number in the set,
// which results in repetition of one number and loss of another number.
//
//Given an array nums representing the data status of this set after the error.
// Your task is to firstly find the number occurs twice and then find the number that is missing.
// Return them in the form of an array.
//
//Example 1:
//Input: nums = [1,2,2,4]
//Output: [2,3]
//Note:
//The given array size will in the range [2, 10000].
//The given array's numbers won't have any order.

//寻找丢失和重复的数
public class Q645_SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        int dup=0,missing=0;
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
                dup = index+1;
            else
                nums[index] *= -1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) {
                missing = i + 1;
                break;
            }
        }
        int[] result = new int[2];
        result[0] = dup;
        result[1] = missing;
        return result;
    }

    public static void test(int[] nums,int[] expected){
        int[] result = findErrorNums(nums);
        System.out.println(result[0]==expected[0]&&result[1]==expected[1]);
    }

    public static void main(String[] args) {
        test(new int[]{1,2,2,4},new int[]{2,3});
    }
}

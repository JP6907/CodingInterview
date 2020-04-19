package com.jp.LeetCode.question;

//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//Note: The solution set must not contain duplicate subsets.
//
//Example:
//
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
//如果一个集合有 n 个元素，则其所有子集一共有 2^n 个。由此想到二进制的应用
//n个取1个、2个、.....n个
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q78_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(n==0)
            return result;
        for(int i=0;i<Math.pow(2,n);i++){
            int bitMask = i;
            List<Integer> subSet = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                if((bitMask&0x01)==0x01){
                    subSet.add(nums[j]);
                }
                bitMask = bitMask>>1;
            }
            result.add(subSet);
        }
        return result;
    }

    public static void test(int[] nums){
        List<List<Integer>> result = subsets(nums);
        for(List<Integer> l : result){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    public static void main(String[] args) {
        test(new int[]{1,2,3});
    }
}

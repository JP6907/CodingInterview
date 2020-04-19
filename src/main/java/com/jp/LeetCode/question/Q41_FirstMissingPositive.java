package com.jp.LeetCode.question;

//Given an unsorted integer array, find the smallest missing positive integer.
//
//Example 1:
//
//Input: [1,2,0]
//Output: 3
//Example 2:
//
//Input: [3,4,-1,1]
//Output: 2
//Example 3:
//
//Input: [7,8,9,11,12]
//Output: 1

//Note:
//
//Your algorithm should run in O(n) time and uses constant extra space.

//思路1：计数，从头开始遍历，对于>0的数计数，计数计数查找第一个count为0的数

//思路2：排序，二分法找到第一个大于0的数
//该数>1,则返回1，否则往右遍历
//空间复杂度不为常数

//就是把[1，n]范围内的数归位，nums数组中大于n的、或者小于等于0的数都不用管
public class Q41_FirstMissingPositive {

//    public int firstMissingPositive(int[] nums) {
//        Arrays.sort(nums);
//
//    }
}

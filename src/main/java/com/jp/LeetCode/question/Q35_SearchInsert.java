package com.jp.LeetCode.question;

/**
 * @author zjp
 * @Description
 * @createTime 2020/07/17
 **/
public class Q35_SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void test(int[] nums, int target, int expected){
        System.out.println(searchInsert(nums, target) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{1,3,5,6}, 5, 2);
        test(new int[]{1,3,5,6}, 2, 1);
        test(new int[]{1,3,5,6}, 7, 4);
    }
}

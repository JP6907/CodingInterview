package com.jp.LeetCode.ByteDance;

/**
 * @author shangqiu
 * @createTime 2020/7/23
 **/
public class Q_search {

    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return -1;
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] >= nums[left]){
                if(target <= nums[mid] && target >= nums[left]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void test(int[] nums, int target, int expected){
        System.out.println(search(nums, target) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{4,5,6,7,0,1,2}, 0, 4);
        test(new int[]{4,5,6,7,0,1,2}, 3, -1);
        test(new int[]{4,5,6,6,6,6,1},1, 6);
    }
}

package com.jp.LeetCode.question;

/**
 * @author shangqiu
 * @createTime 2020/8/3
 **/
public class Q162_findPeakElement {

    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return 0;
        }
        int left = 0;
        int right = len-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(((mid == 0) || (mid > 0 && nums[mid] > nums[mid-1]))
                && (mid == len-1 || (mid < len-1 && nums[mid] > nums[mid+1]))){
                return mid;
            }
            if(nums[mid] > nums[mid+1]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void test(int[] nums, int[] expected){
        int result = findPeakElement(nums);
        System.out.println(result);
        for(int i=0;i<expected.length;i++){
            if(result == expected[i]){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    public static void main(String[] args) {
        test(new int[]{1,2,3,1}, new int[]{2});
        test(new int[]{1,2,1,3,5,6,4}, new int[]{1, 5});
        test(new int[]{1,2}, new int[]{1});
        test(new int[]{3,2,1}, new int[]{0});
    }
}

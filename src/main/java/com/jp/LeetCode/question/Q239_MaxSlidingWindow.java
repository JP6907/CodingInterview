package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.MonotonicQueue;

import java.util.Arrays;

/**
 * @author zjp
 * @Description
 * @createTime 20:21
 **/
public class Q239_MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        int[] result = new int[nums.length-k+1];
        for(int i=0, j=0;i<nums.length;i++){
            if(i<k-1){//先填满前k-1个
                window.push(nums[i]);
            }else {//窗口滑动
                window.push(nums[i]);
                result[j++] = window.max();
                window.pop(nums[i-k+1]);
            }
        }
        return result;
    }

    public static void test(int[] nums, int k, int[] expected){
        System.out.println(Arrays.equals(maxSlidingWindow(nums, k), expected));
    }

    public static void main(String[] args) {
        test(new int[]{1,3,-1,-3,5,3,6,7}, 3, new int[]{3,3,5,5,6,7});
    }

}

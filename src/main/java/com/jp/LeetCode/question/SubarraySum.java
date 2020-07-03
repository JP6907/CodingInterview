package com.jp.LeetCode.question;

/**
 * @author zjp
 * @Description
 * @createTime 18:54
 **/
public class SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        //preSum[i] : 0...i-1
        preSum[0] = 0;
        for(int i=0;i<nums.length;i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                //（i...j）
                if( (i == j && nums[i] == k) || preSum[j+1] - preSum[i] == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void test(int[] nums, int k, int expected){
        System.out.println(subarraySum(nums, k) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{1,2,3,4,5,6,7}, 5, 2);
    }
}

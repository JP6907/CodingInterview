package com.jp.LeetCode.question;

import java.awt.*;
import java.util.Random;

/**
 * @author zjp
 * @Description 水塘抽样
 * @createTime 2020/07/14
 **/
//https://github.com/labuladong/fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/%E6%B0%B4%E5%A1%98%E6%8A%BD%E6%A0%B7.md
//当你遇到第 i 个元素时，应该有 1/i 的概率选择该元素，1 - 1/i 的概率保持原有的选择
public class ReservoirSampling {

    //随机选择 k 个数，只要在第 i 个元素处以 k/i 的概率选择该元素，以 1 - k/i 的概率保持原有选择即可
    public static int getRandom(int[] nums){
        Random random = new Random();
        int res = 0;
        for (int i=0;i<nums.length;i++){
            if(random.nextInt(i+1) == 0){
                res = nums[i];
            }
        }
        return res;
    }

    public static int[] getRandomK(int[] nums, int k){
        Random random = new Random();
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = nums[i];
        }
        int i = k;
        for(;i<nums.length;i++){
            int j = random.nextInt(i+1);
            if(j < k){
                res[j] = nums[i];
            }
        }
        return res;
    }

    public static void test(int[] nums){
        float count = 0;
        int total = 10000;
        for(int i=0;i<total;i++){
            if(getRandom(nums) == nums[0]){
                count++;
            }
        }
        System.out.println(count/total);
    }

    public static void main(String[] args) {
        test(new int[]{1,2,3,4,5});
    }
}

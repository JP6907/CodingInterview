package com.jp.LeetCode.question;

import java.util.Arrays;

/**
 * @author zjp
 * @createTime 2020/7/11 16:17
 **/
public class Q1011_ShipWithinDays {

    public static void main(String[] args) {
        System.out.println(canFinish(new int[]{1,2,3,1,1}, 2, 4));

        test(new int[]{1,2,3,4,5,6,7,8,9,10}, 5, 15);
        test(new int[]{3,2,2,4,1,4}, 3, 6);
        test(new int[]{1,2,3,1,1}, 4, 3);

    }

    public static void test(int[] weights, int D, int expected){
        System.out.format("%d   %d \n",shipWithinDays(weights, D), expected);
        System.out.println(shipWithinDays(weights, D) == expected);
        System.out.println("=======");
    }


    public static int shipWithinDays(int[] weights, int D) {
        int left = getMaxWeight(weights), right = getMaxCap(weights);
        while (left < right){
            int mid = left + (right - left)/2;
            if(canFinish(weights, mid, D)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    /**
     *
     * @param weights
     * @param cap 船的运载重量
     * @param D 最大允许天数
     * @return
     */
    public static boolean canFinish(int[] weights, int cap, int D){
        int day = 0;
        int countCap = 0;
        for(int i=0;i<weights.length;i++){
            if(countCap + weights[i] <= cap){
                countCap += weights[i];
            } else {
                day++;
                countCap = weights[i];
            }
        }
        day++;
        return day <= D;
    }

    public static int getMaxCap(int[] weights){
        int count = 0;
        for(int weight : weights){
            count += weight;
        }
        return count;
    }

    public static int getMaxWeight(int[] weights){
        int max = 0;
        for(int weight : weights){
            max = Math.max(max, weight);
        }
        return max;
    }
}

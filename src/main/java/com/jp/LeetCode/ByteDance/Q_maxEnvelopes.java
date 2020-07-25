package com.jp.LeetCode.ByteDance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zjp
 * @createTime 2020/7/25 20:45
 **/
public class Q_maxEnvelopes {

    public static int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if(len < 2){
            return len;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] height = new int[len];
        for(int i=0;i<len;i++){
            height[i] = envelopes[i][1];
        }
        return maxSubSeq(height);
    }

    public static int maxSubSeq(int[] array){
        int[] dp = new int[array.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1;i<array.length;i++){
            for(int j=i-1;j>=0;j--){
                if(array[j] < array[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public static void test(int[][] envelopes, int expected){
        System.out.println(maxEnvelopes(envelopes) == expected);
    }

    public static void main(String[] args) {
        test(new int[][]{{5,4},{6,4},{6,7},{2,3}}, 3);
    }
}

package com.jp.LeetCode.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zjp
 * @createTime 2020/7/25 20:09
 **/
public class Q_minimumTotal {

    public static int minimumTotal(List<List<Integer>> triangle) {
        minimumTotalCore(triangle, 0, 0, 0);
        return min;
    }

    public static int min = Integer.MAX_VALUE;
    public static void minimumTotalCore(List<List<Integer>> triangle, int currIndex, int currLevel, int currSum){
        if(currLevel == triangle.size()){
            min = Math.min(min, currSum);
        } else {
            if(currIndex < triangle.get(currLevel).size()){
                currSum += triangle.get(currLevel).get(currIndex);
                minimumTotalCore(triangle, currIndex, currLevel + 1, currSum);
                minimumTotalCore(triangle, currIndex + 1, currLevel + 1, currSum);
            }
        }
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<i+1;j++){
                int min = Integer.MAX_VALUE;
                if(j > 0){
                    min = Math.min(min, dp[i-1][j-1]);
                }
                if(j < i) {
                    min = Math.min(min, dp[i - 1][j]);
                }
                dp[i][j] = min + triangle.get(i).get(j);
            }
        }
        int result = dp[n-1][0];
        for(int i=1;i<n;i++){
            result = Math.min(result, dp[n-1][i]);
        }
        return result;
    }

    public static void test(int[][] triangleArray, int expected){
        List<List<Integer>> triangle = new ArrayList<>();
        for(int[] array : triangleArray){
            List<Integer> list = new ArrayList<>();
            for(int a : array){
                list.add(a);
            }
            triangle.add(list);
        }
        System.out.println(minimumTotal(triangle) == expected);
        System.out.println(minimumTotal2(triangle) == expected);
    }

    public static void main(String[] args) {
        test(new int[][]{{2},
                        {3,4},
                        {6,5,7},
                        {4,1,8,3}}, 11);
        test(new int[][]{{1},{2, 3}}, 3);
    }
}


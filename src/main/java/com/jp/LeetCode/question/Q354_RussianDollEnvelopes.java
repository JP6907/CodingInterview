package com.jp.LeetCode.question;
//You have a number of envelopes with widths and heights given as a pair of integers (w, h).
// One envelope can fit into another if and only if both the width and height of one envelope
// is greater than the width and height of the other envelope.
//
//What is the maximum number of envelopes can you Russian doll? (put one inside other)
//
//Note:
//Rotation is not allowed.
//
//Example:
//
//Input: [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

//二维的最大上升子序列问题

import java.util.Arrays;
import java.util.Comparator;

public class Q354_RussianDollEnvelopes {

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

        }
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void test(int[][] envelopes, int expected) {
        System.out.println(maxEnvelopes(envelopes) == expected);
        System.out.println(maxEnvelopes2(envelopes) == expected);
    }

    public static void main(String[] args) {
        test(new int[][]{{5,4},{6,4},{6,7},{2,3}},3);
        test(new int[][]{{1,1},{1,1},{1,1}},1);
        test(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}},4);
        test(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}}, 3);
    }

    public static int maxEnvelopes2(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] heights = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            heights[i] = envelopes[i][1];
        }
        return lcs(heights);
    }

    public static int lcs(int[] heights){
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(heights[i] > heights[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

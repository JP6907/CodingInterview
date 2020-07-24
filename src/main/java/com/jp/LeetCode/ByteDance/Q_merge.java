package com.jp.LeetCode.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author shangqiu
 * @createTime 2020/7/23
 **/
public class Q_merge {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        List<int[]> resultList = new ArrayList<>();
        int x = intervals[0][0];
        int y = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] > y){
                resultList.add(new int[]{x, y});
                x = intervals[i][0];
                y = intervals[i][1];
            } else {
                y = Math.max(y, intervals[i][1]);
            }
        }
        resultList.add(new int[]{x, y});
        int[][] result = new int[resultList.size()][2];
        for(int i=0;i<resultList.size();i++){
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }
        return result;
    }

    public static void test(int[][] intervals){
        int[][] result = merge(intervals);
        for(int[] interval : result){
            System.out.println(Arrays.toString(interval));
        }
        System.out.println("===");
    }

    public static void main(String[] args) {
        test(new int[][]{{1,4},{0,4}});
        test(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        test(new int[][]{{1,4},{4,5}});
    }

}

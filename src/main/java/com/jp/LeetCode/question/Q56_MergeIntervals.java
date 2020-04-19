package com.jp.LeetCode.question;

//Given a collection of intervals, merge all overlapping intervals.
//
//Example 1:
//
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//Example 2:
//
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Q56_MergeIntervals {
    //先排序，然后依次合并
    public static int[][] merge(int[][] intervals) {
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                else
                    return o1[0]-o2[0];
            }
        });
        //合并过程
        LinkedList<int[]> merged = new LinkedList<int[]>();
        for(int[] interval : intervals){
            //没有交集
            if(merged.size()==0||merged.getLast()[1]<interval[0]){
                merged.add(interval);
            }else{
                //有交集，右边界设置为两者最大值
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void test(int[][] intervals){
        int[][] result = merge(intervals);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
    }

    public static void main(String[] args) {
        test(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

}
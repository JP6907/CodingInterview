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

import java.util.*;

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
        System.out.println("--");
        result = merge2(intervals);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
        System.out.println("--");
        result = merge3(intervals);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
        System.out.println("========");
        result = merge4(intervals);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
        System.out.println("========");
    }

    public static void main(String[] args) {
        test(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }


    //按start排序
    public static int[][] merge2(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        List<int[]> result = new ArrayList<int[]>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        return res;
    }

    //按end排序
    public static int[][] merge3(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int x_end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= x_end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }else {
                result.add(new int[]{start, end});
                x_end = intervals[i][1];
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        return res;

    }

    public static int[][] merge4(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> resultList = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1], end);
            } else {
                resultList.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        resultList.add(new int[]{start, end});
        int[][] result = new int[resultList.size()][2];
        for(int i=0;i<resultList.size();i++){
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }
        return result;
    }

}
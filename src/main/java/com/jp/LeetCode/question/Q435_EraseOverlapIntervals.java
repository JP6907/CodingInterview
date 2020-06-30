package com.jp.LeetCode.question;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zjp
 * @Description
 * @createTime 15:30
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 **/
public class Q435_EraseOverlapIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //按照end排序
                return o1[1] == o2[1] ? (o1[0] - o2[0]) : (o1[1] - o2[1]);
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            if(start >= end){//找到下一个不重叠区间
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public static void test(int[][] intervals, int expected){
        System.out.println(eraseOverlapIntervals(intervals) == expected);
    }

    public static void main(String[] args) {
        test(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}}, 1);
        test(new int[][]{{1,2}, {1,2}, {1,2}}, 2);
        test(new int[][]{{1,2}, {2,3}}, 0);
    }

}

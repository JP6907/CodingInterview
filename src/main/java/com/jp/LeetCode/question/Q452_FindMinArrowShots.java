package com.jp.LeetCode.question;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zjp
 * @Description
 * @createTime 15:43
 **/
public class Q452_FindMinArrowShots {

    //求不重叠区间的数量
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }else if(points.length == 1){
            return 1;
        }else {
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1];
                }
            });
            int count = 1;
            int end = points[0][1];
            for(int i=1;i<points.length;i++){
                int start = points[i][0];
                if(start > end){
                    count++;
                    end = points[i][1];
                }
            }
            return count;
        }
    }

    public static void test(int[][] points, int expected){
        System.out.println(findMinArrowShots(points) == expected);
    }

    public static void main(String[] args) {
        test(new int[][]{{10,16}, {2,8}, {1,6}, {7,12}}, 2);
    }


}

package com.jp.LeetCode.question;

//Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
//
//Return the intersection of these two interval lists.
//
//(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
//

//Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.

//Note:
//
//0 <= A.length < 1000
//0 <= B.length < 1000
//0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
//NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

// 给定两组由闭区间组成的列表，返回这两个区间列表的交集

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q986_IntervalListIntersections {

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        Comparator<int[]> cmp = new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        };
        //排序
        Arrays.sort(A,cmp);
        Arrays.sort(B,cmp);
        //遍历求交集
        List<int[]> result = new ArrayList<int[]>();
        int indexA = 0, indexB = 0;
        while (indexA<A.length && indexB<B.length){
            int a1 = A[indexA][0];
            int a2 = A[indexA][1];
            int b1 = B[indexB][0];
            int b2 = B[indexB][1];
            //没有交集：a2<b1 || b2<a1 取反
            //如果有交集
            if(a2>=b1 && b2>=a1){
                result.add(new int[]{Math.max(a1,b1),Math.min(a2,b2)});
            }
            if(a2<b2)
                indexA++;
            else
                indexB++;
        }
        int[][] resultArr = new int[result.size()][2];
        result.toArray(resultArr);
        return resultArr;
    }

    public static void test(int[][] A,int[][] B){
        int[][] result = intervalIntersection(A,B);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
        System.out.println("---");
        result = intervalIntersection2(A,B);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
        System.out.println("=====");
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] B = new int[][]{{1,2},{5,5},{8,10},{15,23},{24,24},{25,25}};
        test(A,B);
    }

    public static int[][] intervalIntersection2(int[][] A, int[][] B) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        };
        Arrays.sort(A, comparator);
        Arrays.sort(B, comparator);
        List<int[]> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < A.length && index2 < B.length){
            if(!(A[index1][0] > B[index2][1] || A[index1][1] < B[index2][0])){
                result.add(new int[]{Math.max(A[index1][0], B[index2][0]), Math.min(A[index1][1], B[index2][1])});
            }
            if(A[index1][1] < B[index2][1]){
                index1++;
            }else {
                index2++;
            }
        }
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        return res;
    }

}
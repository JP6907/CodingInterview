package com.jp.question;

// 面试题53（三）：数组中数值和下标相等的元素
// 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
// 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1, 1, 3, 5}中，数字3和它的下标相等。
public class Q53_03_IntegerIdenticalToIndex {
    //二分法
    // a[i] = i
    // a[i+k] > i+k
    // a[i-k] < i-k
    static int GetNumberSameAsIndex(int[] data,int left,int right){
        if(left<0 || right>= data.length || left>right)
            return -1;
        while(left<=right) {
            int middle = (left + right) >> 1;
            if(data[middle]==middle)
                return middle;
            else if(data[middle]>middle)
                right = middle-1;
            else
                left = middle+1;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(GetNumberSameAsIndex(new int[]{-1,-1,0,3,5,6},0,5)); // 3
    }
}

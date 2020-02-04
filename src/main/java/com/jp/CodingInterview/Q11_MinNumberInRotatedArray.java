package com.jp.CodingInterview;

// 面试题11：旋转数组的最小数字
// 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
// {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
public class Q11_MinNumberInRotatedArray {

    public static int minNumberInRotateArray(int[] array){
        return minNumberInRotateArrayCore(array,0,array.length-1);
    }

    public static int minNumberInRotateArrayCore(int[] array,int left,int right){
        if(left==right)
            return array[left];
        int middle = (left+right)/2;
        if (array[middle]>array[right])
            return minNumberInRotateArrayCore(array,middle+1,right);
        else
            return minNumberInRotateArrayCore(array,left,middle);
    }

    public static void Test(int[] array,int expectedMin){
        System.out.println(minNumberInRotateArray(array)==expectedMin);
    }

    public static void main(String[] args){
        Test(new int[]{3, 4, 5, 1, 2},1);
        Test(new int[]{3, 4, 5, 1, 1, 2},1);
        Test(new int[]{3, 4, 5, 1, 2, 2},1);
        Test(new int[]{5, 6, 0, 1, 2, 3, 4},0);
        Test(new int[]{1, 0, 1, 1, 1},0);
    }
}

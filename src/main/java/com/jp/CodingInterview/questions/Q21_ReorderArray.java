package com.jp.CodingInterview.questions;

import java.util.Arrays;

// 21：调整数组顺序使奇数位于偶数前面
// 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
// 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
public class Q21_ReorderArray {


    //使用归并排序的思想
    public static void reOrderArray(int[] array){
        mergeSort(array,0,array.length-1);
    }

    //奇数小于偶数
    public static int compare(int n1,int n2){
        if((n1&0x01)==(n2&0x01))
            return 0;
        else if((n1&0x01)==1)
            return -1;
        else
            return 1;
    }

    public static void merge(int[] array,int low,int middle,int high){
        int[] tmp = new int[array.length];
        for(int i=low;i<=high;i++)
            tmp[i] = array[i];
        int i,j,k;
        for(i=low,j=middle+1,k=i;i<=middle&&j<=high;k++){
            if(compare(tmp[i],tmp[j])<=0)
                array[k]=tmp[i++];
            else
                array[k]=tmp[j++];
        }
        while (i<=middle)
            array[k++]=tmp[i++];
        while (j<=high)
            array[k++]=tmp[j++];
    }

    public static void mergeSort(int[] array,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }

    public static void Test(int[] array){
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args){
        Test(new int[]{1,4,2,6,1,-9,10,-5});
    }
}

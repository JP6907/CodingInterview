package com.jp.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSortTest {

    static int Partition(int[] data,int low,int high){
        int val = data[low];
        while (low < high){
            while (low < high && data[high] >= val){
                high--;
            }
            data[low] = data[high];
            while (low < high && data[low] <= val){
                low++;
            }
            data[high] = data[low];
        }
        data[low] = val;
        return low;
    }

    static void QuickSort(int[] data,int start,int end){
        if(start < end){
            int pivot = Partition(data, start, end);
            QuickSort(data, start, pivot-1);
            QuickSort(data, pivot+1, end);
        }
    }

    public static void main(String[] args){
        int[] data = {1,52,2,5,7,34,0,-1};
        QuickSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }
}

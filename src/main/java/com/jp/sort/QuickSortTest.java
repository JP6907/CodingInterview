package com.jp.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSortTest {

    static int Partition(int[] data,int low,int high){
        int index = (int)(Math.random()*(high-low)+low);
        int pivot = data[index];
        data[index] = data[low];
        data[low] = pivot;
        while(low<high){
            while(low<high && data[high]>=pivot)
                high--;
            data[low] = data[high];
            while(low<high && data[low]<= pivot)
                low++;
            data[high] = data[low];
        }
        data[low] = pivot;
        return low;
    }

    static void QuickSort(int[] data,int start,int end){
        if(start==end)
            return;
        int index = Partition(data,start,end);
        if(index>start)
            QuickSort(data,start,index-1);
        if(index<end)
            QuickSort(data,index+1,end);
    }

    public static void main(String[] args){
        int[] data = {1,52,2,5,7,34,0,-1};
        QuickSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }
}

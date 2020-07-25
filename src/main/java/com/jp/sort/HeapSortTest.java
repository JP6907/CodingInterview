package com.jp.sort;

import java.util.Arrays;

/**
 * @author zjp
 * @createTime 2020/7/25 9:37
 **/
public class HeapSortTest {

    public static void adjustDown(int[] array, int k, int len){
        int val = array[k];
        for (int i=2*k+1;i<len;i=2*k+1){
            if(i+1<len && array[i+1]>array[i]){
                i++;
            }
            if(array[i] > val){
                array[k] = array[i];
                k = i;
            } else {
                break;
            }
        }
        array[k] = val;
    }

    public static void buildMaxHeap(int[] array){
        for(int i=array.length/2;i>=0;i--){
            adjustDown(array, i, array.length);
        }
    }

    public static void HeadSort(int[] array){
        buildMaxHeap(array);
        for(int i=array.length-1;i>=1;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustDown(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] data = {1,52,2,5,7,34,0,-1};
        HeadSort(data);
        System.out.println(Arrays.toString(data));
    }

}

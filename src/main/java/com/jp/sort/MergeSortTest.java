package com.jp.sort;

import java.util.Arrays;

/**
 * @author zjp
 * @createTime 2020/7/25 9:58
 **/
public class MergeSortTest {

    public static void merge(int[] A, int low, int mid, int high){
        int[] B = Arrays.copyOfRange(A, low, high+1);
        int i = 0, j = mid - low + 1, k = low;
        while (i <= mid - low && j <= high - low && k <= high){
            if(B[i] < B[j]){
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= mid - low){
            A[k++] = B[i++];
        }
        while ((j <= high - low)){
            A[k++] = B[j++];
        }
    }

    public static void mergeSort(int[] A, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            mergeSort(A, low, mid);
            mergeSort(A, mid+1, high);
            merge(A, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] data = {1,52,2,5,7,34,0,-1};
        mergeSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }
}

package com.jp.CodingInterview;

// 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
// 如果有多对数字的和等于S，输出两个数的乘积最小的。
// 对应每个测试案例，输出两个数，小的先输出。

import java.util.ArrayList;

public class Q57_01_TwoNumbersWithSum {

    public static ArrayList<Integer> FindNumbersWithSum(int[] array,int sum){
        ArrayList<Integer> result = new ArrayList<>();
        if(array.length<2)
            return result;
        int low=0,high=array.length-1;
        boolean flag = false;
        int minProduct = 0;
        int currentProduct = 0;
        int currentSum = 0;
        int minLow=-1,minHigh=-1;
        while (low<high){
            currentSum = array[low] + array[high];
            if(currentSum == sum){
                currentProduct = array[low]*array[high];
                if(!flag||currentProduct<minProduct){
                    minLow = low;
                    minHigh = high;
                    minProduct = currentProduct;
                }
                flag = true;
                low++;
                high--;
            }else if(currentSum < sum){
                low++;
            }else{
                high--;
            }
        }
        if(flag){
            result.add(array[minLow]);
            result.add(array[minHigh]);
        }
        return result;
    }

    public static void Test(int[] array,int sum){
        ArrayList<Integer> result = FindNumbersWithSum(array,sum);
        System.out.println(result.toString());
    }

    public static void main(String[] args){
        Test(new int[]{1, 2, 4, 7, 11, 14},15);
    }
}

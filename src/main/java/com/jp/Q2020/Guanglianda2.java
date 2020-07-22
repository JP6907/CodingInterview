package com.jp.Q2020;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zjp
 * @createTime 2020/7/22 21:37
 **/
public class Guanglianda2 {

    //4
    //2 1 3 4
    //1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        int index1 = n-1, index2 = n-1;
        while (index1 >= 0 && index2 >= 0){
            if(sorted[index2] == nums[index1]){
                index1--;
                index2--;
            } else {
                index1--;
            }
        }
        System.out.println(index2+1);
    }
}

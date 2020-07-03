package com.jp.LeetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zjp
 * @Description
 * @createTime 9:22
 **/
public class Q969_PancakeSort {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        pancakeSortCore(A, A.length, result);
        return result;
    }

    public void pancakeSortCore(int[] A, int n, List<Integer> result){
        if(n == 1){
            return;
        }else {
            //找到最大值
            int maxIndex = 0;
            int max = A[0];
            for(int i=1;i<n;i++){
                if(A[i]>max){
                    max = A[i];
                    maxIndex = i;
                }
            }
            reverse(A, 0, maxIndex);
            result.add(maxIndex+1);
            reverse(A, 0, n-1);
            result.add(n);
            pancakeSortCore(A, n-1, result);
        }
    }

    public void reverse(int[] A, int left, int right){
        while (left < right){
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }

    public void test(int[] A, List<Integer> expected){
        List<Integer> result = pancakeSort(A);
        System.out.println(result.containsAll(expected) && expected.containsAll(result));
    }

    public static void main(String[] args) {
        Q969_PancakeSort sort = new Q969_PancakeSort();
        sort.test(new int[]{3,2,4,1}, Arrays.asList(3,4,2,3,1,2));
    }

}

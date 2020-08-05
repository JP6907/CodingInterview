package com.jp.LeetCode.question;

/**
 * @author shangqiu
 * @createTime 2020/7/31
 **/
public class Q88_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
        }
        int index1 = m - 1;
        int index2 = n - 1;
        int index3 = m + n - 1;
        while (index1 >= 0 && index2 >= 0 && index3 >=0){
            if(nums1[index1] > nums2[index2]){
                nums1[index3--] = nums1[index1--];
            } else {
                nums1[index3--] = nums2[index2--];
            }
        }
        while (index1 >= 0){
            nums1[index3--] = nums1[index1--];
        }
        while (index2 >= 0){
            nums1[index3--] = nums2[index2--];
        }
    }

}

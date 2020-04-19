package com.jp.LeetCode.question;

// There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
// You may assume nums1 and nums2 cannot be both empty.

//Example 1:
// nums1 = [1, 3]
// nums2 = [2]
// The median is 2.0

// Example 2:
// nums1 = [1, 2]
// nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5

//寻找两个有序数组的中位数
public class Q4_MedianofTwoSortedArrays {

    //偶数 len/2-1 len/2
    //奇数 len/2
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int med = (len1+len2)/2;
        int index1=0,index2=0,index=0;
        int num1=0,num2=0;
        while (index1<len1&&index2<len2&&index<=med){
            if(nums1[index1]<nums2[index2]) {
                num1 = num2;
                num2 = nums1[index1++];

            } else {
                num1 = num2;
                num2 = nums2[index2++];
            }
            index++;
        }
        while(index<=med&&index1<len1){
            num1 = num2;
            num2 = nums1[index1++];
            index++;
        }
        while(index<=med&&index2<len2){
            num1 = num2;
            num2 = nums2[index2++];
            index++;
        }
        //index = len/2    num2 = len/2
        if((len1+len2)%2!=0){
            return num2;
        }else{
            return ((double)num1+(double) num2)/2;
        }
    }

    public static void Test(int[] nums1,int[] nums2,double expected){
        System.out.println(findMedianSortedArrays(nums1,nums2)==expected);
    }

    public static void main(String[] args){
        Test(new int[]{1, 3},new int[]{2},2.0d);
        Test(new int[]{1, 2},new int[]{3, 4},2.5d);
        Test(new int[]{1},new int[]{3},2d);
    }


}
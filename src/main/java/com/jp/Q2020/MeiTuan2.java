package com.jp.Q2020;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MeiTuan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int max = maxSeqLength(nums,-1)-1;
        for(int i=0;i<n;i++){
            if(i==0||nums[i]<nums[i-1]) {
                int len = maxInDelete(nums,i);
                max = Math.max(max,len);
            }
        }
        System.out.println(max);
//        LinkedList<Integer> list = new LinkedList<>();
//        for(int i=0;i<n;i++){
//            list.add(sc.nextInt());
//        }
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            int len = maxSeqLen(list,i);
//            max = Math.max(max,len);
//        }
//        System.out.println(max);

    }

    public static int maxSeqLen(LinkedList<Integer> list,int deleteIndex){
        int del = list.get(deleteIndex);
        list.remove(deleteIndex);
        int len = 0;
        Iterator<Integer> iterator = list.iterator();
        int pre = 0;
        while (iterator.hasNext()){
            if(len==0){
                len++;
                pre = iterator.next();
            }else {
                int cur = iterator.next();
                if(cur>pre)
                    len++;
                else
                    len = 1;
                pre = cur;
            }
        }
        list.add(deleteIndex,del);
        return len;
    }

    public static int maxSeqLength(int[] nums,int deleteIndex){
        int maxLen = 0;
        int len = 0;
        int pre = 0;
        for(int i=0;i<nums.length;i++){
            if(i!=deleteIndex){
                if(len==0){
                    len++;
                    maxLen = Math.max(len,maxLen);
                    pre = nums[i];
                }else {
                    if(nums[i]>=pre){
                        len++;
                        maxLen = Math.max(len,maxLen);
                    }else {
                        len = 1;
                    }
                    pre = nums[i];
                }
            }
        }
        return maxLen;
    }

    public static int maxInDelete(int[] nums,int index){
        if(index==0){
            int len = 1;
            for(int i=2;i<nums.length&&nums[i-1]<=nums[i];i++){
                len++;
            }
            return len;
        }else if(index==nums.length-1){
            int len = 1;
            for(int i=nums.length-3;i>=0&&nums[i]<=nums[i+1];i--){
                len++;
            }
            return len;
        }else {
            int left = index-1;
            int right = index+1;
            if(left>right)
                return 0;
            else {
                int len = 2;
                for(int i=left-1;i>=0&&nums[i]<=nums[i+1];i--)
                    len++;
                for(int i=right+1;i<nums.length&&nums[i]>=nums[i-1];i++)
                    len++;
                return len;
            }

        }
    }
}

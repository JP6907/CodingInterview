package com.jp.CodingInterview.questions;

// 面试题53（一）：数字在排序数组中出现的次数
// 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,3, 3, 4, 5}和数字3，
// 由于3在这个数组中出现了4次，因此输出4。
public class Q53_01_NumberOfK {
   //使用二分法分别找出第一个K和最后一个K

   static int getFirstK(int[] data,int start,int end,int K){
       if(start<0 || end>=data.length || start>end)
           return -1;
       int middle = (start+end)/2;
       if(data[middle]==K){
           if(middle==0||data[middle-1]!=data[middle]) //是第一个K
               return middle;
           else
               end = middle-1;
       }else if(data[middle]>K){
           end = middle-1;
       }else{
           start = middle+1;
       }
       return getFirstK(data,start,end,K);
   }

    static int getLastK(int[] data,int start,int end,int K){
        if(start<0 || end>=data.length || start>end)
            return -1;
        int middle = (start+end)/2;
        if(data[middle]==K){
            if(middle==data.length-1||data[middle+1]!=data[middle]) //是最后一个K
                return middle;
            else
                start = middle+1;
        }else if(data[middle]>K){
            end = middle-1;
        }else{
            start = middle+1;
        }
        return getLastK(data,start,end,K);
    }

    static int getNumberOfK(int[] data,int K){
        assert data.length>0;
        if(data.length==1 && data[0]!=K)
            return 0;
        int first = getFirstK(data,0,data.length-1,K);
        int last = getLastK(data,0,data.length-1,K);
        if(first!=-1&&last!=-1)
            return last-first+1;
        else
            return -1;
    }

    public static void main(String[] args){
       int[] data = {1,2,3,3,3,3,4,5,5,5,6};
       assert getNumberOfK(data,3)==4;
        assert getNumberOfK(data,4)==1;
        assert getNumberOfK(data,5)==3;
        assert getNumberOfK(data,6)==1;

        System.out.println(getLeftK(new int[]{2,2,3,4,5},1)==-1);
        System.out.println(getLeftK(new int[]{2,2,3,4,5},2)==0);
        System.out.println(getLeftK(new int[]{2,2,3,4,5},4)==3);
        System.out.println(getRightK(new int[]{2,2,3,4,5},6)==-1);
        System.out.println(getRightK(new int[]{2,2,3,4,5},2)==1);

        test2(new int[]{5,7,7,8,8,10},8,2);
        test2(new int[]{5,7,7,8,8,10},6,0);
    }

    public static void test2(int[] nums, int target, int expected){
       System.out.println(search2(nums, target)==expected);
    }

    public static int search2(int[] nums, int target) {
       int left = getLeftK(nums,target);
       int right = getRightK(nums, target);
       if(left==-1 || right==-1) {
           return 0;
       }else {
           return right-left+1;
       }

    }

    //不存在则返回-1
    public static int getLeftK(int[] nums,int target){
       int left = 0;
       int right = nums.length-1;
       while (left<=right){
           int mid = left + (right-left)/2;
           if(nums[mid]==target){
               if(mid==0||nums[mid-1]!=target){
                   return mid;
               }else {
                   right = mid-1;
               }
           }else if(nums[mid]>target){
               right = mid-1;
           }else if(nums[mid]<target){
               left = mid+1;
           }
       }
       return -1;
    }

    public static int getRightK(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid+1]!=target){
                    return mid;
                }else {
                    left = mid+1;
                }
            }else if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        return -1;
    }

}

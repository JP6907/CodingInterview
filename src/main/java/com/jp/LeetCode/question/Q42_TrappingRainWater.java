package com.jp.LeetCode.question;

//Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.
//https://leetcode.com/problems/trapping-rain-water/

//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6

//每个位置能盛多少水和左右两侧的最大值有关
//为 min(lmax,rmax) - height[i]
public class Q42_TrappingRainWater {

    //方法1，记忆法
    public static int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        for(int i=1;i<n;i++)
            lmax[i] = Math.max(lmax[i-1],height[i-1]);
        for(int i=n-2;i>=0;i--)
            rmax[i] = Math.max(rmax[i+1],height[i+1]);
        int result = 0;
        for(int i=1;i<n-1;i++) {
            int diff = Math.min(lmax[i], rmax[i]) - height[i];
            result += (diff>0?diff:0);
        }
        return result;
    }

    //方法2，双指针法
    public static int trap2(int[] height) {
        int left=1,right=height.length-2;
        int lmax=0,rmax=0;
        int result = 0;
        while (left<=right){
            lmax = Math.max(lmax,height[left-1]);
            rmax = Math.max(rmax,height[right+1]);
            //只关心小者
            if(lmax<rmax){
                int diff = lmax - height[left];
                result += (diff>0?diff:0);
                left++;
            }else {
                int diff = rmax - height[right];
                result += (diff>0?diff:0);
                right--;
            }
        }
        return result;
    }


    public static void test(int[] height,int expected){
        System.out.println(trap(height)==expected);
        System.out.println(trap2(height)==expected);
        System.out.println(trap3(height)==expected);
        System.out.println(trap32(height)==expected);
        System.out.println(trap33(height)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{0,1,0,2,1,0,1,3,2,1,2,1},6);
    }


    public static int trap3(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftM, rightM;
        int count = 0;
        for(int i=1;i<n-1;i++){
            leftM = 0;
            rightM = 0;
            for(int j=i-1;j>=0;j--){
                leftM = Math.max(leftM, height[j]);
            }
            for(int j=i+1;j<n;j++){
                rightM = Math.max(rightM, height[j]);
            }
            int diff = Math.min(leftM, rightM) - height[i];
            if(diff > 0){
                count += diff;
            }
        }
        return count;
    }

    public static int trap32(int[] height) {
        int n = height.length;
        int[] leftM = new int[n];
        int[] rightM = new int[n];
        int count = 0;
        for(int i=1;i<n;i++){
            leftM[i] = Math.max(leftM[i-1], height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightM[i] = Math.max(rightM[i+1], height[i+1]);
        }
        for(int i=0;i<n;i++){
            int diff = (Math.min(leftM[i], rightM[i])) - height[i];
            if(diff > 0){
                count += diff;
            }
        }
        return count;
    }

    public static int trap33(int[] height) {
        int n = height.length;
        int leftM = 0, rightM = 0;
        int left = 1, right = height.length-2;
        int count = 0;
        while (left <= right){
            leftM = Math.max(leftM, height[left-1]);
            rightM = Math.max(rightM, height[right+1]);
            if(leftM < rightM){
                int diff = leftM - height[left];
                count += (diff > 0 ? diff : 0);
                left++;
            }else {
                int diff = rightM - height[right];
                count += (diff > 0 ? diff : 0);
                right--;
            }
        }
        return count;
    }
}

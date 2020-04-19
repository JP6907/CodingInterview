package com.jp.LeetCode.question;

//Given n non-negative integers a1, a2, ..., an ,
// where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
// such that the container contains the most water.
//
//Note: You may not slant the container and n is at least 2.

//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49
//说明：以8和7为边界，能获得最大面积为7*Min(8,7)=49，7为 8和7的距离

//思路：由a、b为边界组成的面积和 Min(a,b) 有关
//如果希望面积更大，则必定是和[a,b]内更高的点 c 组成的区域
//a、c组成的区域面积和a有关，c、b组成的区域面积和b有关

//贪心策略
//面积=宽度*最低高度
//从两边往中间收缩，宽度变小，则只有最低高度变大，面积才有可能变大
public class Q11_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0,right = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while (left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            maxArea = (area>maxArea?area:maxArea);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void Test(int[] height,int expected){
        System.out.println(maxArea(height)==expected);
    }

    public static void main(String[] args) {
        Test(new int[]{1,8,6,2,5,4,8,3,7},49);
    }
}

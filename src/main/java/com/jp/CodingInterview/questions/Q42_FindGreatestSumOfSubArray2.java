package com.jp.CodingInterview.questions;

// HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
// 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
// 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
// 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
// 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
// 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

public class Q42_FindGreatestSumOfSubArray2 {

    //求最大连续子集和
    //动态规划
    // 如果f(i) 表示到i为止的最大子集和，无法知道第i个数是否包含在子集合中，是否连续
    // f(i) 表示以第i个数字结尾的子数组的最大和,(第i个数一定包含)
    // i=0 | f(n-1)<0 , f(n) = a(n)
    // f(n-1)>0 , f(n) = f(n-1)+a(n)
    public static int FindGreatestSumOfSubArray(int[] array){
        if(array==null||array.length==0)
            return 0;
        int[] f = new int[array.length];
        f[0] = array[0];
        int max = f[0];
        for(int i=1;i<array.length;i++){
            if(f[i-1]<0)
                f[i] = array[i];
            else
                f[i] = f[i-1]+array[i];
            if(f[i]>max)
                max=f[i];
        }
        return max;
    }

    public static void Test(int[] array,int expected){
        System.out.println(FindGreatestSumOfSubArray(array)==expected);
    }

    public static void main(String[] args){
        Test(new int[]{6,-3,-2,7,-15,1,2,2},8);
        Test(new int[]{1, -2, 3, 10, -4, 7, 2, -5},18);
        Test(new int[]{-2, -8, -1, -5, -9},-1);
        Test(new int[]{2, 8, 1, 5, 9},25);
        Test(null,0);
    }
}

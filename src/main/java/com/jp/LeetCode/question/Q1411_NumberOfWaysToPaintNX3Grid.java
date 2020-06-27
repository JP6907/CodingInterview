package com.jp.LeetCode.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjp
 * @createTime 2020/6/21 14:35
 **/
//你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
//
//给你网格图的行数 n 。
//
//请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。

public class Q1411_NumberOfWaysToPaintNX3Grid {

    public static class ThreeTuple{
        public int color1;
        public int color2;
        public int color3;

        public ThreeTuple(int color1, int color2, int color3) {
            this.color1 = color1;
            this.color2 = color2;
            this.color3 = color3;
        }

        public boolean ableAdjacentWith(ThreeTuple other){
            if(this.color1==other.color1 || this.color2==other.color2 || this.color3==other.color3){
                return false;
            }else {
                return true;
            }
        }
    }

    public static class State{
        static int row;
        static long color;

    }

    //递推方法空间效率和时间效率都不行
//    public static int numOfWays(int n) {
//        //存放一行格子所有可能的涂色方案
//        //用ArrayList可能超出最大容量
//        //用LinkedList访问速度慢
//        //List<ThreeTuple> all = new ArrayList<ThreeTuple>();
//        Map<Long,ThreeTuple> all = new HashMap<>();
//        long size = 0;
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                for(int k=0;k<3;k++){
//                    if(i==j || j==k){
//                        continue;
//                    }
//                    all.put(size,new ThreeTuple(i,j,k));
//                }
//            }
//        }
//        //f(n)(i)表示前n行格子中，第n行涂色为第i中涂色方案的数量
//        //f(n)(i) = sum{f(n-1)(k)},k=1,....,size,all(i)和all(k)可以相邻
//
//        long[][] f = new long[n][size];
//        //初始状态
//        for(int i=0;i<size;i++){
//            f[0][i] = 1;
//        }
//        //状态转移
//        for(int currentRow=1;currentRow<n;currentRow++){//第i行
//            for(int currentColor=0;currentColor<size;currentColor++){ //当前行可能出现的涂色方案
//                for(int lastColor=0;lastColor<size;lastColor++){ //上一行的涂色方案
//                    if(all.get(currentColor).ableAdjacentWith(all.get(lastColor))){
//                        f[currentRow][currentColor] += f[currentRow-1][lastColor];
//                    }
//                }
//            }
//        }
//        long result = 0;
//        for(int i=0;i<size;i++){
//            result += f[n-1][i];
//        }
//        return (int) (result%((long) Math.pow(10,9)+7));
//    }

    //先提炼出规律，再进行递推
    //每一行有可能是双色或三色
    //双色：ABA
    //  下一行为双色的情况为：BAB、BCB、CAC
    //  下一行为三色的情况为：BAC、CAC
    //  总共5种情况
    //三色：ABC
    //  下一行为双色的情况为：BAB、BCB
    //  下一行为三色的情况为：BCA、CAB
    //   总共4种情况
    //不局限于下一行的规律，可以是相邻行的规律
    //f[n][0]表示第n行为双色的数量
    //f[n][1]表示第n行为三色的数量
    //初始状态：
    //f[0][0] = 3*2 = 6;
    //f[0][1] = 3*2 = 6
    public static int numOfWays(int n){
        long[][] f = new long[n][2];
        f[0][0] = 6;
        f[0][1] = 6;
        int mod = (int)(Math.pow(10,9)+7);
        for(int i=1;i<n;i++){
            f[i][0] = (f[i-1][0]*3+f[i-1][1]*2)%mod;
            f[i][1] = (f[i-1][0]*2+f[i-1][1]*2)%mod;
        }
        return (int) ((f[n-1][0] + f[n-1][1])%mod);
    }

    public static void test(int n, int expected){
        System.out.println(numOfWays(n)==expected);
    }

    public static void main(String[] args) {
        test(1,12);
        test(2,54);
        test(3,246);
        test(7,106494);
        test(5000,30228214);
    }
}

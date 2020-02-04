package com.jp.Q2019;

// 题目描述
//为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。
// 牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
// 在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。
// 牛牛的小伙伴太多了，于是他只好把这个任务交给了你。

// 输入描述:
//每个输入包含一个测试用例。
//每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
//接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
//接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
//保证不存在两项工作的报酬相同。

//输出描述:
//对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。

// 输入
//  3 3
//  1 100
//  10 1000
//  1000000000 1001
//  9 10 1000000000
//输出
//  100
//  1000
//  1001

import java.util.Arrays;
import java.util.Scanner;

//暴力破解，时间复杂度是O(mn)
//每个人选择的工作为不超过其能力的工作中报酬最高者
//先对工作按工作难度排序，然后将每个工作的报酬改为难度小于等于该工作的所有工作中的最高报酬 O(nlogn)
//在排序好的情况下，每个员工找到工作的时间复杂度只需要O(m)
//如果对员工的按能力进行排序O(mlogm)，则每个员工不需要从头开始遍历工作，只需要从上一个员工的位置开始
//则时间复杂度由O(mn) 缩短到O(m+n)
//最后将报酬按照原序输出
//因此，总时间复杂度为 Max{O(nlogn),O(mlogm),O(m+n)}

public class NetEase_FindJob {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //工作数量
        int M = sc.nextInt(); //人数
        int[][] Job = new int[N][2]; //工作难度,工作报酬
        int[][] Ability = new int[M][2]; //工作能力，输入的序号
        int[] Pay = new int[M]; //工作报酬

        for(int i=0;i<N;i++){
            Job[i][0] = sc.nextInt();
            Job[i][1] = sc.nextInt();
        }
        for(int i=0;i<M;i++){
            Ability[i][0] = sc.nextInt();
            Ability[i][1] = i;
        }
        //按工作难度排序
        Arrays.sort(Job, (j1,j2) -> (int)(j1[0]-j2[0]));
        //将每个工作的报酬改为难度小于等于该工作的所有工作中的最高报酬
        for(int i=1;i<N;i++){
            Job[i][1] = Math.max(Job[i-1][1],Job[i][1]);
        }
        int index=0;
        //按工作能力排序
        Arrays.sort(Ability,(a1,a2)->(int)(a1[0]-a2[0]));
        for(int i=0;i<M;i++){
            //难度不超过Ability
            int j=0;
            for(j=index;j<N && Job[j][0]<=Ability[i][0];j++);
            index = j;
            Pay[Ability[i][1]] = j==0?0:Job[j-1][1];
        }
        //Arrays.sort(Ability,(a1,a2) -> (int)(a1[1]-a2[1]));
        for(int i=0;i<M;i++)
            System.out.println(Pay[i]);


    }
}

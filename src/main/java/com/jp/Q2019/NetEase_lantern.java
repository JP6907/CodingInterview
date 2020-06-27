package com.jp.Q2019;

// 题目描述
//小Q正在给一条长度为n的道路设计路灯安置方案。
//
//为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
//
//小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
//
//小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。


// 输入描述:
//  输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
//  接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
//  第二行一个字符串s表示道路的构造,只包含'.'和'X'。
//输出描述:
//  对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。
//  示例1
// 输入
//  2
//  3
//  .X.
//  11
//  ...XX....XX
// 输出
//  1
//  3

import java.util.Scanner;

// 思路：如果都是 . ，每遇到一个 . ，可以跳过连续的3个格
// 考虑有 X 的情况，主要有四种情况
// 一：X     这种情况可以直接跳过第一个格(X)，从下一个格开始判断
// 二：.X.   这种情况将路灯安装在中间的X位置，同样是跳过连续的3个格
// 三：.XX   这种情况可以将路灯安装在第一个位置或第二个位置，然后跳过这三个格
// 四：..X   这种情况可以将路灯安装在第一个格或第二个格，然后跳过这三个格
// 总结：每遇到一个.,跳过连续三个格，路灯数加一，
//       每遇到一个X，跳过当前位置，从下一个位置开始判断
public class NetEase_lantern {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TestCount = sc.nextInt();
        for(int i=0;i<TestCount;i++){
            int length = sc.nextInt();
            String road = sc.next();
            int count = 0;
            int position = 0;
            while (position<length){
                if(road.charAt(position)=='.'){
                    position+=3;
                    count++;
                }else{
                    position++;
                }
            }
            System.out.println(count);
        }
    }

}

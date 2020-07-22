package com.jp.Q2020;



import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zjp
 * @createTime 2020/7/22 21:46
 **/
public class Guanglianda3 {

    //样例输入
    //3 5
    //1 10
    //10 5
    //22 3
    //样例输出
    //13
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long y = sc.nextLong();
        long[][] monster = new long[n][2];
        for (int i=0;i<n;i++){
            monster[i][0] = sc.nextLong();
            monster[i][1] = sc.nextLong();
        }
        Arrays.sort(monster, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                } else if(o1[0] < o2[0]){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(kill(monster, y, 0));
    }

    public static long kill(long[][] monster, long y, int index){
        if(index >= monster.length){
            return 0;
        } else {
            //x:伤害范围左边界
            long x = monster[index][0];
            long count = monster[index][1];
            monster[index][1] = 0;
            for(int i=index+1;i<monster.length && x+2*y>=monster[i][0];i++){
                monster[i][1] -= (count>monster[i][1]?monster[i][1]:count);
            }
            index++;
            for(int i=index+1;i<monster.length;i++){
                if(monster[i][1]!=0){
                    break;
                }
                index++;
            }
            return count + kill(monster, y, index);
        }
    }
}

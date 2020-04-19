package com.jp.CodingInterview.questions;


import java.util.LinkedList;

// 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
// HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
// 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
// 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
// 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
// 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？
// (注：小朋友的编号是从0到n-1)
//
//如果没有小朋友，请返回-1
public class Q62_LastNumberInCircle2 {

    //方法一：使用链表，边遍历边移除
    public static int LastRemaining_Solution1(int n,int m){
        if(n<1 || m<1)
            return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++)
            list.add(i);
        int index = 0;
        while (list.size()>1){
            index = (index+m-1)%list.size();
            list.remove(index);
        }
        return list.get(0);
    }
    //方法二：使用数组，设置标志位
    public static int LastRemaining_Solution2(int n,int m){
        if(n<1 || m<1)
            return -1;
        boolean[] isOut = new boolean[n];
        for(int i=0;i<n;i++)
            isOut[i] = false;
        int index = 0;
        int count = 0;
        while (count<n-1){
            for(int i=1;i<m;i++){
                index = (index+1)%n;
                while (isOut[index])
                    index = (index+1)%n;
            }
            isOut[index]=true;
            count++;
            index = (index+1)%n; //从下一个人开始
            while (isOut[index])
                index = (index+1)%n;
        }
        for(int i=0;i<isOut.length;i++){
            if(!isOut[i])
                return i;
        }
        return -1;
    }

    public static void Test(int n,int m,int expected){
        System.out.println(LastRemaining_Solution1(n,m)==expected);
        System.out.println(LastRemaining_Solution2(n,m)==expected);
        System.out.println("=====");
    }


    public static void main(String[] args){
        Test(5,3,3);
        Test(5, 2, 2);
        Test(6, 7, 4);
        Test(6, 6, 3);
        Test(0, 0, -1);
        Test(4000, 997, 1027);
    }

}

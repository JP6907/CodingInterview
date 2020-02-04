package com.jp.CodingInterview;

// 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到
// 第一个   只出现一次的字符,并返回它的位置,
// 如果没有则返回 -1（需要区分大小写）.

public class Q50_01_FirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str){
        int size = 256;
        int[] table = new int[size];
        for(int i=0;i<size;i++)
            table[i]=0;
        for(int i=0;i<str.length();i++){
            table[Integer.valueOf(str.charAt(i))]++;
        }
        for(int i=0;i<str.length();i++){
            if(table[Integer.valueOf(str.charAt(i))]==1)
                return i;
        }
        return -1;

    }

    public static void Test(String str,int expected){
        System.out.println(FirstNotRepeatingChar(str)==expected);
    }

    public static void main(String[] args){
        //g o o g  l e
        //0 0 0 -1 4 4
        StringBuffer sb = new StringBuffer();
        sb.append("g");
        Test(sb.toString(),0);
        sb.append("o");
        Test(sb.toString(),0);
        sb.append("o");
        Test(sb.toString(),0);
        sb.append("g");
        Test(sb.toString(),-1);
        sb.append("l");
        Test(sb.toString(),4);
        sb.append("e");
        Test(sb.toString(),4);

    }
}

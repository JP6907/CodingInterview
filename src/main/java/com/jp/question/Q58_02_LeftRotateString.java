package com.jp.question;

// 面试题58（二）：左旋转字符串
// 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
// 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
// 字2，该函数将返回左旋转2位得到的结果"cdefgab"。

public class Q58_02_LeftRotateString {

    static void reverse(StringBuilder sb,int begin,int end){
        while(begin<end){
            char tmp = sb.charAt(begin);
            sb.setCharAt(begin,sb.charAt(end));
            sb.setCharAt(end,tmp);
            begin++;
            end--;
        }
    }

    static String LeftRotateString(String str,int n){
        if(n>str.length())
            return "";
        assert n>=0 && n<str.length();
        StringBuilder sb = new StringBuilder(str);
        reverse(sb,0,n-1);
        reverse(sb,n,str.length()-1);
        reverse(sb,0,str.length()-1);
        return sb.toString();
    }

    public static void main(String[] args){
        String str = "abcdefg";
        System.out.println(LeftRotateString(str,2));
        System.out.println("==");
        System.out.println(LeftRotateString(new String(),6));
        System.out.println("==");
    }

}

package com.jp.CodingInterview;


import java.util.ArrayList;

// 面试题38：字符串的排列
// 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
// 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
public class Q38_StringPermutation {
    //1.求第一个位置的字符，即把第一个字符和后面所有字符交换
    //2.递归求后面的字符可能的组合
    static void Permutation(String str){
        if(str==null||str.length()==0)
            return;
        PermutationRecursively(str,0);
    }

    static void PermutationRecursively(String str,int index){
        if(index==str.length()-1) {
            System.out.println(str);
        }else{
            StringBuffer sb = new StringBuffer(str);
            for(int i=index;i<str.length();i++){
                if(i>index&&sb.charAt(i)!=sb.charAt(index))
                    StrExchange(sb,index,i);
                PermutationRecursively(sb.toString(),index+1);
            }
        }
    }
    //交换两个字符
    static void StrExchange(StringBuffer sb,int i,int j){
        char tmp = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,tmp);
    }

    //============
    public static ArrayList<String> Permutation2(String str){
        ArrayList<String> result = new ArrayList<>();
        if(str==null||str.length()==0)
            return result;
        PermutationCore(str,0,result);
        return result;
    }

    public static void PermutationCore(String str,int index,ArrayList<String> result){
        if(index==str.length()){
            result.add(str);
        }else{
            StringBuffer sb = new StringBuffer(str);
            for(int i=index;i<str.length();i++) {
                if(i>index&&sb.charAt(i)==sb.charAt(index))
                    continue;
                StrExchange(sb,index,i);
                PermutationCore(sb.toString(),index+1,result);

            }
        }
    }



    public static void main(String[] args){
        Permutation("abc");
        System.out.println("====");
        System.out.println(Permutation2("abc").toString());
        System.out.println(Permutation2("aa").toString());
    }
}
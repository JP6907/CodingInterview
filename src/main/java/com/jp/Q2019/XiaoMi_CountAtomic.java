package com.jp.Q2019;

//题目描述
//给出一个字符串格式的化学分子式，计算原子的个数
//每个化学元素都是由一个大写字母，或者一个大写字母后跟着若干个小写字母组成，例如H是一个化学元素，Mg也是一个化学元素。
//每个分子式中，原子的个数写在元素后面，如果原子个数是1，那么原子个数省略。例如H2O和H2O2都是有效的分子式，但H1O2不是有效分子式。
//每个分子式中包含若干括号，为简单起见，分子式中只有小括号。
//每次输入一个分子式，对每个给定的分子式，求出每个原子的个数，按照原子字母表的顺序排列，并输出。
//输入描述:
//一行，一个字符串表示输入的分子式

//输出描述:
//按要求输出答案

//示例1
//输入
//H2O
//输出
//H2O

//示例2
//输入
//Mg(OH)2
//输出
//H2MgO2

//示例3
//输入
//K4(ON(SO3)2)2
//输出
//K4N2O14S4

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class XiaoMi_CountAtomic {

    public static void main(String[] args) {

    }

    static class Result{
        TreeMap<String,Integer> treeMap;
        int index;

        public Result(TreeMap<String, Integer> treeMap, int index) {
            this.treeMap = treeMap;
            this.index = index;
        }
    }

    //如果是左括号，递归
    public static Result parse(String str,int index){
        if(index>=str.length())
            return null;
        else{
            TreeMap<String,Integer> treeMap = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char c = str.charAt(index);
            while (c!=')'){
                if(isDigit(c)){
                    count = count*10+Integer.parseInt(c+"");
                }else if(c=='('){
                    //递归
                    Result result1 = parse(str,index+1);
                    while (isDigit(str.charAt(index))){
                        count = count*10 + Integer.parseInt(str.charAt(index++)+"");
                    }
                    for(Map.Entry<String, Integer> entries : result1.treeMap.entrySet()){
                        treeMap.put(entries.getKey(),entries.getValue()*count);
                    }
                    count = 0;
                    index = result1.index;
                } else{
                    if(sb.length()!=0){
                        treeMap.put(sb.toString(),count);
                        sb.delete(0,sb.length());
                        count = 0;
                    }else{
                        sb.append(c);
                    }
                }
                c = str.charAt(++index);
            }
            return new Result(treeMap,index+1);
        }
    }

    public static boolean isDigit(char c){
        return c>='0'&&c<='9';
    }
}

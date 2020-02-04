package com.jp.CodingInterview;

// 面试题5：替换空格
// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。
public class Q05_ReplaceSpaces {

    public static void ReplaceBlank(StringBuffer str){
        //计算空格数量
        int oldLen = str.length();
        int blankCount = 0;
        for(int i=0;i<oldLen;i++)
            if(str.charAt(i)==' ')
                blankCount++;
        //扩展长度
        int newLen = oldLen + blankCount*2;
        for(int i=oldLen;i<newLen;i++)
            str.append(' ');
        //从尾部开始置换
        int index1 = oldLen-1;
        int index2 = newLen-1;
        while(index1>=0){
            if(str.charAt(index1)==' '){
                str.setCharAt(index2--,'0');
                str.setCharAt(index2--,'2');
                str.setCharAt(index2--,'%');
            }else{
                str.setCharAt(index2--,str.charAt(index1));
            }
            index1--;
        }
    }

    public static boolean Test(String source,String target){
        StringBuffer sb = new StringBuffer(source);
        ReplaceBlank(sb);
        return sb.toString().equals(target);
    }

    public static void main(String[] agrs){
        System.out.println(Test("hello world","hello%20world"));
        System.out.println(Test(" hello world","hello%20world"));
        System.out.println(Test("helloworld ","helloworld%20"));
    }


}

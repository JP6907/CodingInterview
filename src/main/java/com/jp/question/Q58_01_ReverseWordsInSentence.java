package com.jp.question;


// 面试题58（一）：翻转单词顺序
// 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
// 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
// 则输出"student. a am I"。
// 先翻转整个句子。然后翻转每个单词
public class Q58_01_ReverseWordsInSentence {

    static void reverse(StringBuilder sb,int begin,int end){
        while(begin<end){
            char tmp = sb.charAt(begin);
            sb.setCharAt(begin,sb.charAt(end));
            sb.setCharAt(end,tmp);
            begin++;
            end--;
        }
    }

    static String reverseSentence(String str){
        StringBuilder sb = new StringBuilder(str);
        reverse(sb,0,sb.length()-1);
        int begin = 0;
        int end = 0;
        while(begin<str.length()){
            if (sb.charAt(begin)==' '&&begin<str.length()){
                begin++;
                end++;
            }else if(sb.charAt(end)==' '||end==str.length()-1){
                reverse(sb,begin,end-1);
                begin = ++end;
            }else{
                end++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String str = "I am a student.";
        System.out.println(reverseSentence(str));
    }

}

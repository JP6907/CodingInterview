package com.jp.question;

// 20：表示数值的字符串
// 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
// 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
// “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是

// [S1][A.B][E][S2|C]
public class Q20_NumericStrings {

    public static boolean isNumeric(char[] str){
        if(str==null||str.length==0)
            return false;
        int[] result = new int[1];
        int index = 0;
        boolean isNumber = false;
        //三种合理情况
        //A.B
        //.B
        //A.
        //不合理的情况：整数和小数部分都不存在，只有小数点

        //整数部分
        isNumber = scanInteger(str,0,result);
        index = result[0];
        if(isNumber&&index==str.length)
            return true;
        //小数点
        if(str[index]=='.'){
            //小数部分
            //小数部分和整数部分至少有一个存在
            isNumber = scanUnsignedInteger(str,index+1,result) || isNumber;
            index = result[0];
            if(!isNumber)
                return false;
            if(index==str.length)
                return true;
        }
        //e
        index = result[0];
        if(str[index]=='e'||str[index]=='E'){
            //指数部分
            isNumber = isNumber && scanInteger(str,index+1,result);
            if(!isNumber||result[0]!=str.length)
                return false;
        }
        return true;
    }

    // result[0]: true/false  1/0
    // result[1]: index
    public static boolean scanUnsignedInteger(char[] str,int start,int[] result){
        if(start>=str.length) {
            return false;
        }
        int index = start;
        while (index<str.length&&str[index]>='0'&&str[index]<='9')
            index++;
        result[0] = index;
        return index!=start;
    }

    public static boolean scanInteger(char[] str,int start,int[] result){
        if(start>=str.length) {
            result[0] = 0;
            return false;
        }
        if(str[start]=='+'||str[start]=='-')
            start++;
        return scanUnsignedInteger(str,start,result);
    }

    public static void Test(char[] str,boolean expected){
        System.out.println(isNumeric(str)==expected);
    }

    public static void main(String[] args){
        //“”、“”、“”、“”及“”都表示数值，但“”、
        //// “”、“”、“”及“”都不是
        Test("+100".toCharArray(),true);
        Test("5e2".toCharArray(),true);
        Test("-123".toCharArray(),true);
        Test("3.1416".toCharArray(),true);
        Test("-1E-16".toCharArray(),true);

        Test("12e".toCharArray(),false);
        Test("1a3.14".toCharArray(),false);
        Test("1.2.3".toCharArray(),false);
        Test("+-5".toCharArray(),false);
        Test("12e+5.4".toCharArray(),false);
    }
}

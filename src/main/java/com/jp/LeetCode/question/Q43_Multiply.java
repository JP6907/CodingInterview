package com.jp.LeetCode.question;

/**
 * @author zjp
 * @Description
 * @createTime 19:19
 **/
public class Q43_Multiply {

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2+1];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                int mul = charToInt(num1.charAt(len1-i-1)) * charToInt(num2.charAt(len2-j-1));
                result[i+j] += mul;
            }
        }
        //统一处理进位
        for(int i=0;i<len1+len2;i++){
            result[i+1] += result[i]/10;
            result[i] %= 10;
        }
        //转字符串
        StringBuilder sb = new StringBuilder();
        int index = len1+len2;
        while (index>=0&&result[index]==0){
            index--;
        }
        if(index == -1){
            return "0";
        }
        for(int i=index;i>=0;i--){
            sb.append((char)('0'+result[i]));
        }
        return sb.toString();
    }

    public static int charToInt(char c){
        return c - '0';
    }

    public static void test(String num1, String num2, String expected){
        System.out.println(multiply(num1, num2));
//        System.out.println(multiply(num1, num2).equals(expected));
    }

    public static void main(String[] args) {
        test("12", "12", "144");
        test("2", "3", "6");
    }

}

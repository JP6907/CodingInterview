package com.jp.LeetCode.ByteDance;

/**
 * @author zjp
 * @createTime 2020/7/21 23:24
 **/
public class Q_multiply {

    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(n1 == 0 || n2 == 0){
            return "";
        }
        int[] result = new int[n1+n2+1];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                result[n1-1-i + n2-1-j] += digit1*digit2;
            }
        }
        for(int i=0;i<n1+n2;i++){
            result[i+1] += result[i]/10;
            result[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i=0;i<=n1+n2;i++){
            if(result[n1+n2-i] != 0){
                flag = false;
            }
            if(!flag) {
                sb.append((char) (result[n1 + n2 - i] + '0'));
            }
        }
        return flag?"0":sb.toString();
    }

    public static void test(String num1, String num2, String expected){
        String result = multiply(num1, num2);
        System.out.println(result);
        System.out.println(result.equals(expected));
        System.out.println("===");
    }

    public static void main(String[] args) {
        test("2", "3", "6");
        test("123", "456", "56088");
        test("0", "0", "0");
    }

}

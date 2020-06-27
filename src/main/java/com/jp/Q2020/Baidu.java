package com.jp.Q2020;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Baidu {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
//        System.out.println("Hello World!");
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println(toBinary(num));

//        Man man = new Man();
//        ManProxy proxy = new ManProxy(man);
//        man.say();
//        proxy.say();
//        System.out.println("=====");
//        Handler handler = new Handler(man);
//        Man proxy2 = (Man)handler.getProxy();
//        proxy2.say();


        System.out.println(lss("abcde2f", "1bcd2f"));
    }

    public static String toBinary(int num) {
        int index = 1;
        int flag = 1;
        StringBuilder strBuilder = new StringBuilder();
        while (index <= 32) {
            int bit = ((num & flag) == 0 ? 0 : 1);
            strBuilder.append((bit + ""));
            flag = flag << 1;
            index++;
        }
        return strBuilder.reverse().toString();
    }

    static interface speak {
        public void say();
    }

    static class Man implements speak {
        public void say() {
            System.out.println("Hello World");
        }
    }

    static class ManProxy implements speak {
        private Man man;

        public ManProxy(Man man) {
            this.man = man;
        }

        @Override
        public void say() {
            System.out.println("proxy");
            this.man.say();
        }
    }

    public static class Handler implements InvocationHandler {
        private Object object;

        public Handler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy");
            method.invoke(this.object, args);
            return null;
        }

        public Object getProxy() {
            return this.object;
        }

    }

    public static String lss(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++)
            Arrays.fill(dp[i], -1);
        longestSubString(str1, str2, 0, 0, dp);
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    index = i;
                }
            }
        }
        if (index != -1) {
            return str1.substring(index - max + 1, index + 1);
        } else {
            return "";
        }
    }

    public static void longestSubString(String str1, String str2, int index1, int index2, int[][] dp) {
        if (index1 >= str1.length() || index2 >= str2.length())
            return;
        if (dp[index1][index2] != -1)
            return;
        if (str1.charAt(index1) == str2.charAt(index2)) {
            if (dp[index1][index2] != -1)
                dp[index1][index2] = dp[index1 - 1][index2 - 1] + 1;
            else dp[index1][index2] = 1;
            longestSubString(str1, str2, index1 + 1, index2 + 1, dp);
        } else {
            dp[index1][index2] = 0;
            longestSubString(str1, str2, index1 + 1, index2 + 1, dp);
        }

    }
}

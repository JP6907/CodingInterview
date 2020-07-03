package com.jp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {

    //https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
    public String reverseWords(String s) {
        //去除首位空格
        char[] chars = s.trim().toCharArray();
        //去除中间重复空格
        int slow=0,fast=0;
        while (fast<chars.length){
            if(chars[fast]==' '&&fast!=0&&chars[fast-1]==' '){
                fast++;
            }else {
                chars[slow] = chars[fast];
                slow++;
                fast++;
            }
        }
        //反转
        int len = slow;
        int left = 0,right = 0;
        while (right<len){
            while (right<len&&chars[right]!=' ')
                right++;
            if(right<=len){
                reverse(chars,left,right-1);
                left = right+1;
                right = left;
            }
            if(left>=len)
                break;
        }
        reverse(chars,0,slow-1);
        return new String(chars,0,slow);

    }

    public void reverse(char[] chars,int start,int end){
        while (start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public void test(){
        System.out.println(reverseWords("  hello   world!  "));
    }

    public static void main(String[] args) {

        class FutureResult{};

        FutureResult result = new FutureResult();

        System.out.println(result.hashCode());
        Future<FutureResult> future = new CompletableFuture<>();
        Integer timeout = 1500;
        try {
            result = future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(result.hashCode());

//        double tmp = 1.33;
//        System.out.println(tmp%1);
//
//        class Parent{};
//        class Child extends Parent{};
//
//        Parent parent = new Parent();
//        Child child = new Child();
//        System.out.println(parent==child);
//
//        parent = child;
//        child = (Child) parent;
//        System.out.println(parent==child);

        //new Test().test();
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        System.out.println(list);
//        for(int i=1;i<1000;i++){
//            if(i%11==7&&i%7==5)
//                System.out.println(i);
//        }
//        int a = 43;
//        int b = 65;
//        int c = 19;
//        int m = 76;
//        int k = 746;//方法倍数
//        long A = a*k;
//        long B = b*k;
//        long C = c*k;
//        System.out.println(fun(a,b,c,m));
//        System.out.println(Fun(A,B,C,m,k)/(k*k*k));
//
//        for(int i=1;i<100000;i++){
//            if((28*i)%197==124){
//                System.out.println(i);
//            }
//        }
    }

    //f(a,b,c) = (a*b+a+m)*c
    public static int fun(int a,int b,int c,int m){
        return (a*b+a+m)*c;
    }

    public static long Fun(long A,long B,long C,int m,int k){
        return (A*B+k*A+k*k*m)*C;
    }



    void knapscakTest(){

    }

}

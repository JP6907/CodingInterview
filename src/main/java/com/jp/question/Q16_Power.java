package com.jp.question;

// 16：数值的整数次方
// 题目：实现函数double Power(double base, int exponent)，求base的exponent
// 次方。不得使用库函数，同时不需要考虑大数问题。
// 保证base和exponent不同时为0

public class Q16_Power {

    public static double Power(double base,int exponent){
        if(exponent==0)
            return 1;
        if(base==0)
            return 0;
        if(exponent>0)
            return UnSignedPower(base,exponent);
        else
            return 1/UnSignedPower(base,-exponent);
    }

    public static double UnSignedPower(double base,int exponent){
        if(exponent==1)
            return base;
        if(exponent%2==0)
            return Power(base,exponent/2)*Power(base,exponent/2);
        else
            return Power(base,exponent/2)*Power(base,exponent/2)*base;
    }

    public static boolean Equal(double d1,double d2){
        if((d1-d2<0.0000001)&&(d1-d2)>-0.0000001)
            return true;
        else
            return false;
    }

    public static void Test(double base,int exponent,double expected){
        System.out.println(Equal(Power(base,exponent),expected));
    }

    public static void main(String[] args){
        Test(2, 3, 8);
        Test(-2,3,-8);
        Test(2, -3, 0.125);
        Test(2, 0, 1);
        Test( 0, 0, 1);
        Test( 0, 4, 0);
        Test( 0, -4, 0);

    }
}

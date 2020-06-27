package com.jp.Q2019;

// 题目描述
//小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
//并且小Q对于能否被3整除这个性质很感兴趣。
//小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。

// 输入描述:
//   输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
// 输出描述:
//   输出一个整数, 表示区间内能被3整除的数字个数。
// 示例1
//   输入
// 2 5
//   输出
// 3
// 说明
//   12, 123, 1234, 12345...
//   其中12, 123, 12345能被3整除。

//思路：一个数所有位数的和相加如果等于3的倍数，则这个整数是3的倍数。
//注意：数字可能为大数，需要用字符串表示

import java.util.Scanner;

public class NetEase_Divide3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        int count = 0;
        int sum = 0;
        for(int i=left;i<=right;i++){
            if(CanDividedBy3(i))
                count++;
        }
        System.out.println(count);

    }

    public static int GetDigitSum(String number){
        int sum = 0;
        for(int i=0;i<number.length();i++){
            sum += (number.charAt(i)-'0');
        }
        return sum;

    }

    //如果一个数能够被3整除，则该数的每一位相加的和能够被3整除
    //所以这个数用字符串表示后，每一位相加能够被3整除
    //即 如果123...L能被3整除 则（1+2+3+ ...+L）能被3整除
    //ABCD....XYZ=A*1000....0+B*1000...+....+X*100+Y*10+C
    //10^n %3 = 1
    //所以
    //A*1000...0÷3余A
    //B*100...0÷3余B
    //....
    //Y*10÷3余Y
    //所以
    //ABCD....XYZ÷3与A+B+...+X+Y+Z同余
    // 1234...count
    //A[i]=(1+2+3+....+i)%3
    //    =(1+2+0+2+....)%3
    //    =(1+2+0)*(i%3)%3 + (1+...+i%3)%3
    //    = 0 + (1+...+i%3)%3
    // i%3=1  = 1   false
    // i%3=2  = 1+2 =0  true
    // i%3=0  =0 true

    public static boolean CanDividedBy3(int count){
        return count%3==1?false:true;
    }

}

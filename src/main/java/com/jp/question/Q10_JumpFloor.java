package com.jp.question;

// 变态跳台阶
// 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
public class Q10_JumpFloor {

    //  f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
    //  f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    //  f(n) = 2*f(n-1)
    //  f(0) = 0;
    //  f(1) = 1;
    //  f(2) = 2;
    //  f(3) = 4;
    public static int JumpFloorII(int target){
        if(target<=2)
            return target;
        else
            return 2*JumpFloorII(target-1);
    }
}

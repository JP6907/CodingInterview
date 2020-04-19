package com.jp.CodingInterview.questions;

// 面试题56（一）：数组中只出现一次的两个数字
// 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
// 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

public class Q56_01_NumbersAppearOnce {

    static class Result{
        int num1;
        int num2;

        public Result(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    static Result findNumbersAppearOnce(int[] data){
        //所有数字异或
        int resultXOR = 0;
        for(int d : data)
            resultXOR ^= d;
        //异或结果找出第一个bit为1
        int firstBit1 = findFirstBitIs1(resultXOR);
        //根据该为是否为1分为两组，分别异或
        int num1 = 0;
        int num2 = 0;
        for(int d : data){
            if(isBit1(d,firstBit1))
                num1 ^= d;
            else
                num2 ^= d;
        }
        return new Result(num1,num2);
    }

    /**
     * 找到num中最右边第一个是1的位
     * @param num
     * @return
     */
    static int findFirstBitIs1(int num){
        int indexBit = 0;
        while((num&1)==0&&indexBit<8*Integer.SIZE){
            num = num>>1;
            indexBit++;
        }
        return indexBit;
    }

    /**
     * 判断右起第indexBit位是否为1
     * @param num
     * @param indexBit
     * @return
     */
    static boolean isBit1(int num,int indexBit){
        num = num>>indexBit;
        return (num&1)==1;
    }

    public static void main(String[] args){
        System.out.println(Integer.lowestOneBit(1));
        System.out.println(Integer.lowestOneBit(2));
        System.out.println(Integer.lowestOneBit(3));
        System.out.println(Integer.lowestOneBit(4));
        System.out.println(Integer.lowestOneBit(5));
        System.out.println(Integer.lowestOneBit(6));

        int[] data = {2,4,3,6,3,2,5,5};
        Result result = findNumbersAppearOnce(data);
        System.out.println(result.num1 + " " + result.num2);
    }

}

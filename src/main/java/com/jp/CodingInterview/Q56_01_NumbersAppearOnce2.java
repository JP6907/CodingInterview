package com.jp.CodingInterview;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

public class Q56_01_NumbersAppearOnce2 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0] num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int[] array,int[] num1,int[] num2){
        //所有数字异或
        int XOROfAll = 0;
        for(int a : array){
            XOROfAll ^= a;
        }
        int index = FindFirstBit1(XOROfAll);
        //根据异或结果切分成两个数组分别异或
        num1[0] = 0;
        num2[0] = 0;
        for(int i=0;i<array.length;i++){
            if(IsBit1(array[i],index))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    public static int FindFirstBit1(int number){
        int bit = 1;
        int index = 0;
        while (index<8*Integer.SIZE&&(number&bit)==0){
            index++;
            bit = bit<<1;
        }
        return index;
    }

    public static boolean IsBit1(int number,int index){
        return ((number>>index)&1)==1;
    }

    public static void main(String[] args){
        System.out.println(FindFirstBit1(1)); //001
        System.out.println(FindFirstBit1(2)); //010
        System.out.println(FindFirstBit1(3)); //011
        System.out.println(FindFirstBit1(4)); //100
        System.out.println(FindFirstBit1(5)); //101
        System.out.println(FindFirstBit1(6)); //110
        System.out.println(IsBit1(1,0));
        System.out.println(IsBit1(2,1));
        System.out.println(IsBit1(3,0));
        System.out.println(IsBit1(4,2));
        System.out.println(IsBit1(5,0));
        int[] data = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(data,num1,num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}

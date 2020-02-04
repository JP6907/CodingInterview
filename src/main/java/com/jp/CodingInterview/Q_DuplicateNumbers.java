package com.jp.CodingInterview;

// 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
// 数组中某些数字是重复的，但不知道有几个数字是重复的。
// 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
// 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

public class Q_DuplicateNumbers {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,
    //                  length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    //数字的范围在 0到n-1
    //以数字为下标索引，
    //从头遍历数组的过程中，获取以数字为索引对应位置的值，减去n
    //如果发现该值小于0，则说明出现过，直接返回该数
    //否则将该值减去n，表示该数字已经出现过
    //不能用加法，否则可能出现溢出
//    public static boolean duplicate(int numbers[],int length,int [] duplication){
//        duplication[0]=-1;
//        if(numbers.length==0||numbers.length!=length||length<2) {
//            return false;
//        }
//        int data = 0;
//        for(int i=0;i<length;i++){
//            data = numbers[i];
//            if(data<0){
//                data += length;
//            }
//            if(numbers[data]<0){
//                duplication[0] = data;
//                return true;
//            }else{
//                numbers[data] -= length;
//            }
//        }
//        return false;
//    }

    public static boolean duplicate2(int numbers[],int length,int [] duplication){
        duplication[0]=-1;
        if(numbers.length==0||numbers.length!=length||length<2) {
            return false;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<numbers.length;i++){
            sb.append(numbers[i]+"");
        }
        for(int i=0;i<numbers.length;i++){
            if(sb.indexOf(numbers[i]+"")!=sb.lastIndexOf(numbers[i]+"")){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void Test(int numbers[]){
        int[] duplication = new int[1];
        boolean result = duplicate2(numbers,numbers.length,duplication);
        System.out.println(result + ","+duplication[0]);
    }

    public static void main(String[] args){
        Test(new int[]{2,3,1,3,0,2,5,3});
        Test(new int[]{2,3,1,0,2,5,3});
        Test(new int[]{1,4,0,2,2});
        Test(new int[]{});
    }
}

package com.jp.CodingInterview;

// 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
// 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
// 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

// 8->18

public class Q14_CuttingRope {

    //2 1*1=1                           1
    //3 1*2=2 1*1*1=1                   2
    //4 1*f(3)=2 2*f(2)=2 1*3=3         3
    //5 1*f(4)=3 2*f(3)=4 3*f(2)=3 1*4=4
    // 动态规划
    // f(n)=max(f(i)*f(n-i),1*n-1)
    public static int cutRope(int target){
        if(target<=1)
            return target;
        if(target<=3){
            return target-1;
        }
        int[] products = new int[target+1];
        //以下3行是n>=4的情况，跟n<=3不同，
        //4可以分成很多段，
        //下面的循环分成两部分，每部分都允许不切分
        //n<=3时进行切分的乘积小于n，所以不切分
        products[1]=1;
        products[2]=2;
        products[3]=3;
        int maxProduct = 0;
        for(int i=4;i<=target;i++){
            for(int j=1;j<=i/2;j++){
                int product = products[j]*products[i-j];
                if(product>maxProduct)
                    maxProduct = product;
            }
            products[i]=maxProduct;

        }
        return products[target];
    }

    // n<=3时，再进行切分，乘积会变小
    // 当n>=5时，尽可能多切长度为3的绳子
    // 剩下的长度为4时，把绳子切分成2
//    public static int cutRope2(int target){
//
//    }

    public static void Test(int target,int expected){
        System.out.println(cutRope(target)==expected);
    }

    public static void main(String[] args){
        Test(8,18);
        Test(2,1);
        Test(3,2);
        Test(4,4);
        Test(5,6);
        Test(6,9);
        Test(7,12);
        Test(8,18);
        Test(9,27);
    }
}

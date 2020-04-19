package com.jp.LeetCode.question;

// Reverse bits of a given 32 bits unsigned integer.
// Input: 00000010100101000001111010011100
//Output: 00111001011110000010100101000000 （倒序）
//Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
// so return 964176192 which its binary representation is 00111001011110000010100101000000.

// Input: 11111111111111111111111111111101
//Output: 10111111111111111111111111111111
//Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
// so return 3221225471 which its binary representation is 10111111111111111111111111111111.
public class Q190_ReverseBits {

    // you need treat n as an unsigned value
    public static int reverseBits(int n){
        int LEN = 32;
        int bit = 0;
        int m = 0;
        for(int i=0;i<LEN;i++){
            bit = n&0x01;
            n = n>>1;

            m = (m|bit);
            if(i<LEN-1)
                m = m << 1;

        }

        return m;
    }

    public static void Test(int n,int expected){
        System.out.println(reverseBits(n)==expected);
    }

    public static void main(String[] args) {
        Test(43261596,964176192);
        //Test(4294967293,3221225471);
    }
}

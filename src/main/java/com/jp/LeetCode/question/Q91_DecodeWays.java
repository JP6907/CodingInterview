package com.jp.LeetCode.question;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
//Example 1:
//
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//Example 2:
//
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

//最大能转化的数字为26
//0不能表示！！！！！！！！！！
//关键判断k-1和k位能不能组合
//不能，则dp[k]=dp[k-1]
//可以，dp[k]=dp[k-1]+dp[k-2]
//k-1和k的组合超过26，或者k-1位位0，则不能组合
//需要判断k-1位和k位是否为0
//k-1为0，且k为0，连续两个0，无法表示dp[k]=0
//k-1为0，k不为0，dp[k]=dp[k-1]
//k-1不为0，dp[k]+=dp[k-1]，如果后面两位组合不超过26，则dp[k]+=dp[k-2]
//表示范围为1到26，0无法表示
//最后一个数字为1到9，则 dp[k+1] 最少有 dp[k] 种情况
//再判断最后一个数字能够和前一位数字组合
//如果前面一位不为0，两个数组合不超过26，则可以 dp[k+1] = dp[k] + dp[k-1]
//如果前面一位数字为0，或者两位组合超过26，则无法组合
public class Q91_DecodeWays {

    public static int numDecodings(String s) {
        if(s==null||s.length()==0)
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0)=='0'?0:1;
        for(int i=1;i<s.length();i++){//对应dp的索引位i+1
            char prec = s.charAt(i-1);
            char curc = s.charAt(i);
            if(prec=='0'){//无法和后面一位组合
                //最后两位同时为0，无法表示
                dp[i] = (curc=='0'?0:dp[i-1]);
            }else{//前面一位不为0
                //前面一位和当前位组合的结果
                int two = Integer.parseInt(s.substring(i-1,i+1));
                if(curc=='0'){//当前一位为0，则只能和前面一位组合
                    if(two>26)
                        dp[i] = 0;
                    else
                        dp[i] = dp[i-1] + dp[i-2];
                }else{
                    if(two>26)
                        dp[i] = dp[i-1];
                    else{
                        if(i>1)
                            dp[i] = dp[i-1] + dp[i-2];
                        else
                            dp[i] = dp[i-1];
                    }

                }
            }
        }
        return dp[s.length()-1];
    }

    public static void test(String s,int expected){
        System.out.println(numDecodings(s)==expected);
    }

    public static void main(String[] args) {
        test("12",2);
        test("226",3);
    }
}

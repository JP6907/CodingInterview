package com.jp.LeetCode.question;

//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
//Example:
//
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

//选一个作为根节点，小于的全部作为左子树，大于的全部作为右子树，分别计算左右子树的数量
//递归
public class Q96_UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        return numTreesCOre(1,n);
    }

    public static int numTreesCOre(int min,int max){
        if(min>=max)
            return 1;
        int sum = 0;
        //i作为根节点
        for(int i=min;i<=max;i++){
            int left = numTreesCOre(min,i-1);
            int right = numTreesCOre(i+1,max);
            sum += left*right;
        }
        return sum;
    }

    //动态规划
    //dp[k]表示1到k可以有多少棵二叉树
    //dp[k+1]，分别让1到k+1作为根节点
    //dp[k+1]=dp[k]*dp[0]+dp[k-1]*dp[1]+dp[k-2]*dp[2]+.....+dp[0]*dp[k]
    public static int numTrees2(int n) {
        if(n<2)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=i-1;j++){
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }

    public static void test(int n,int expected){
        System.out.println(numTrees(n)==expected);
        System.out.println(numTrees2(n)==expected);
    }

    public static void main(String[] args) {
        test(3,5);
    }
}

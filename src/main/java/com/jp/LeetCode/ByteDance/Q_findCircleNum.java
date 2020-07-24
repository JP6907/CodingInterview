package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.UnionFind;

/**
 * @author shangqiu
 * @createTime 2020/7/23
 **/
public class Q_findCircleNum {

    public static int findCircleNum(int[][] M) {
        int n = M.length;
        if(n <= 1){
            return n;
        }
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j] == 1){
                    if(!uf.isConnected(i, j)){
                        uf.union(i, j);
                    }
                }
            }
        }
        return uf.count();
    }

    public static void test(int[][] M, int expected){
        System.out.println(findCircleNum(M) == expected);
    }

    public static void main(String[] args) {
        test(new int[][]{{1,1,0},
                        {1,1,0},
                        {0,0,1}}, 2);
        test(new int[][]{{1,1,0},
                        {1,1,1},
                        {0,1,1}}, 1);
    }


}

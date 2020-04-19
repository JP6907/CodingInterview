package com.jp.CodingInterview.datastruct;

//并查集
//判断连桶性，O(1)
public class UnionFind {
    //连通分量的个数
    private int count;

    private int[] parent;
    //以i为根节点的树的重量
    private int[] size;

    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p,int q){
        //将小的树连接到大的树的根节点上
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ)
            return;
        if(size[rootP]>size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public boolean isConnected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP==rootQ;
    }

    //寻找根节点
    public int find(int x){
        while (parent[x]!=x){
            //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count(){
        return count;
    }

    //判断合法等式
    //https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/UnionFind%E7%AE%97%E6%B3%95%E5%BA%94%E7%94%A8.md
    //给你一个数组 equations，装着若干字符串表示的算式。每个算式 equations[i] 长度都是 4，而且只有这两种情况：a==b 或者 a!=b，
    // 其中 a,b 可以是任意小写字母。你写一个算法，如果 equations 中所有算式都不会互相冲突，返回 true，否则返回 false。
    //
    //比如说，输入 ["a==b","b!=c","c==a"]，算法返回 false，因为这三个算式不可能同时正确。
    //
    //再比如，输入 ["c==c","b==d","x!=z"]，算法返回 true，因为这三个算式并不会造成逻辑冲突。
    public boolean equationsPossible(String[] equations){
        //先处理“==”构建连通性
        UnionFind uf = new UnionFind(26);
        for(String eq : equations){
            if(eq.charAt(1)=='='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x-'a',y-'a');
            }
        }
        //检查“!=”是否打破连桶性
        for(String eq : equations){
            if(eq.charAt(1)=='!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if(uf.isConnected(x-'a',y-'a'))
                    return false;
            }
        }
        return true;
    }

    public void equationTest(String[] equations,boolean expected){
        System.out.println(equationsPossible(equations)==expected);
    }


    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(0,1);
        uf.union(1,2);
        System.out.println(uf.isConnected(0,2));
        System.out.println(uf.count);

        uf.equationTest(new String[]{"a==b","b!=c","c==a"},false);
        uf.equationTest(new String[]{"c==c","b==d","x!=z"},true);
    }
}

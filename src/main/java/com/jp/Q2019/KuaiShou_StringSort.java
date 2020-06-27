package com.jp.Q2019;

// 月神拿到一个新的数据集，其中每个样本都是一个字符串（长度小于100），样本的的后六位是纯数字，月神需要将所有样本的后六位数字提出来，转换成数字，并排序输出。
//月神要实现这样一个很简单的功能确没有时间，作为好朋友的你，一定能解决月神的烦恼，对吧。

//输入描述:
//每个测试用例的第一行是一个正整数M（1<=M<=100)，表示数据集的样本数目
//
//接下来输入M行，每行是数据集的一个样本，每个样本均是字符串，且后六位是数字字符。

//输出描述:
//对每个数据集，输出所有样本的后六位构成的数字排序后的结果（每行输出一个样本的结果）

//示例1
//输入
//4
//abc123455
//boyxx213456
//cba312456
//cdwxa654321

import java.util.*;

//输出
//123455
//213456
//312456
//654321
public class KuaiShou_StringSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Total = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<Total;i++){
            String line = sc.next();
            int num = Integer.parseInt(line.substring(line.length()-6,line.length()));
            insert(list,num);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    public static void insert(List<Integer> list,int num){
        if(list.size()==0)
            list.add(num);
        else {
            int index = 0;
            while (index<list.size()&&list.get(index) < num)
                index++;
            if (index == list.size())
                list.add(num);
            else
                list.add(index, num);
        }
    }
}

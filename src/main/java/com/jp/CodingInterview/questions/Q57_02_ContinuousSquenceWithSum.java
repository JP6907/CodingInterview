package com.jp.CodingInterview.questions;

// 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
// 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
// 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
// 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
// Good Luck!

// 输出所有和为S的连续正数序列。
// 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

import java.util.ArrayList;

public class Q57_02_ContinuousSquenceWithSum {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        int maxRight = sum/2;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int left = 0;left<maxRight;left++){
            //(left+right)/2 = squenceSum
            //(right-left+1)(left+right)/2
            for(int right=left+1;right<=maxRight;right++){
                int squenceSum = (right-left+1)*(left+right)/2;
                if(squenceSum==sum)
                    AddSquence(result,left,right);
                else if(squenceSum>sum)
                    break;
            }
        }
        return result;

    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum){
        int left = 1,right = 2;
        int mid = (sum+1)/2;
        int currentSum = left+right;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (left<=mid){
            if(currentSum==sum) {
                AddSquence(result, left, right);
            }
            while (currentSum>sum){
                currentSum -= left;
                left++;
                if(currentSum==sum&&left!=right) {
                    AddSquence(result, left, right);
                }
            }
            right++;
            currentSum+=right;
        }
        return result;
    }

    public static void AddSquence(ArrayList<ArrayList<Integer>> result,int left,int right){
        ArrayList<Integer> list = new ArrayList<>();
        while (left<=right) {
            list.add(left);
            left++;
        }
        result.add(list);
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> result = FindContinuousSequence2(100);
        for(ArrayList<Integer> list : result)
            System.out.println(list.toString());
        result = FindContinuousSequence2(3);
        for(ArrayList<Integer> list : result)
            System.out.println(list.toString());
    }
}

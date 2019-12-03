package com.jp.question;

import java.util.List;
import java.util.Stack;

// 面试题31：栈的压入、弹出序列
// 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
// 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
// 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
// 4、3、5、1、2就不可能是该压栈序列的弹出序列。
public class Q31_StackPushPopOrder {

    /**
     * @param pPush 压入顺序
     * @param pPop 可能的弹出顺序
     * @return
     */
//    static boolean isPopOrder(List<Integer> pPush,List<Integer> pPop){
//        Stack<Integer> dataStack = new Stack<Integer>();
//        assert (pPush.size() == pPop.size())&&(pPush.size()>0);
//        int pushIndex = 0;
//        for(int i=0;i<pPop.size()&&pushIndex<pPush.size();i++){
//            while(pushIndex<pPush.size()&&pushIndex<pPush.size()&&pPush.get(pushIndex)!=pPop.get(i)){
//                dataStack.push(pPush.get(pushIndex++));
//            }
//
//        }
//    }
}

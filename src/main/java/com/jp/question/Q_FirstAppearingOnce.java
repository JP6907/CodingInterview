package com.jp.question;

// 请实现一个函数用来找出字符流中第一个只出现一次的字符。
// 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
// 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

// 如果当前字符流没有存在出现一次的字符，返回#字符。

public class Q_FirstAppearingOnce {

    int index = 0;
    int[] occurrence = new int[256];

    Q_FirstAppearingOnce(){
        for(int i=0;i<256;i++)
            occurrence[i] = -1;
    }

    //Insert one char from stringstream
    public void Insert(char ch){
        if(occurrence[ch]==-1)
            occurrence[ch]=index++;
        else if(occurrence[ch]>=0)
            occurrence[ch]=-2;
    }

    //return the first appearence once char in current stringstrea
    public char FirstAppearingOnce(){
        int minIndex = Integer.MAX_VALUE;
        char ch = '#';
        for(int i=0;i<256;i++){
            if(occurrence[i]>=0){
                if(occurrence[i]<minIndex){
                    minIndex = occurrence[i];
                    ch = (char)i;
                }
            }
        }
        if(minIndex==Integer.MAX_VALUE)
            return '#';
        else
            return ch;
    }

    public static void main(String[] args){
        Q_FirstAppearingOnce fao = new Q_FirstAppearingOnce();
        fao.Insert('g');
        fao.Insert('o');
        System.out.println(fao.FirstAppearingOnce());
        fao.Insert('o');
        fao.Insert('g');
        System.out.println(fao.FirstAppearingOnce());
        fao.Insert('l');
        fao.Insert('e');
        System.out.println(fao.FirstAppearingOnce());
    }

}

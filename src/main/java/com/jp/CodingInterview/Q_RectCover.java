package com.jp.CodingInterview;

public class Q_RectCover {

    public static int RectCover(int target){
        if(target<4)
            return target;
        else
            return RectCover(target-2)+RectCover(target-1);
    }

}
package com.jp.question;

// 67：把字符串转换成整数
// 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
// 数值为0或者字符串不是一个合法的数值则返回0

// 输入一个字符串,包括数字字母符号,可以为空
// 如果是合法的数值表达则返回该数字，否则返回0

public class Q67_StringToInt {

    public static int StrToInt(String str){
        if(str==null||str.length()==0)
            return 0;
        if(str.charAt(0)=='+'){
            return StringToIntCore(str,1,1);
        }else if(str.charAt(0)=='-'){
            return StringToIntCore(str,1,-1);
        }else{
            return StringToIntCore(str,0,1);
        }
    }

    //不考虑符号
    public static int StringToIntCore(String str,int start,int flag){

        if(str.length()<start+1)
            return 0;
        int num = 0;
        for(int i=start;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                int current = str.charAt(i)-'0';
                //(res << 1) + (res << 3)
                num = (num<<1)+(num<<3) + flag*current;
                //num = num*10+flag*current;  //负数的范围比正数大，加上符号
                if((flag==1&&num<0)||(flag==-1&&num>0))
                    return 0;
            }else{
                return 0;
            }
        }
        return num;
    }

    public static void Test(String str,int expected){
        System.out.println(StrToInt(str)==expected);
    }

    public static void main(String[] args){
        Test("+2147483647",2147483647);
        Test("    1a33",0);
        Test("-123",-123);
        Test("-0",0);
        Test("+0",0);
        Test("+2147483647",2147483647); //最大正数
        Test("-2147483648",-2147483648); //最大负数
        Test("+2147483649",0);  //超过最大正数

        //2147483647
        System.out.println("=============");
        int n = 214748364;
        System.out.println((n*10+9)>0x7FFFFFFF);
        System.out.println(0x7FFFFFFF);  //2147483647
        System.out.println(0x80000000>0x7FFFFFFF);  //-2147483648
        System.out.println(0x80000000-1);

    }
}

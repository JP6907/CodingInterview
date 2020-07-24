package com.jp.LeetCode.ByteDance;

import java.util.Stack;

/**
 * @author shangqiu
 * @createTime 2020/7/22
 **/
public class Q_simplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        if(path.length() == 0 || path.charAt(0) != '/'){
            return "/";
        }
        int index = 1;
        StringBuilder curr = new StringBuilder();
        StringBuilder point = new StringBuilder();
        while (index < path.length()){
            char c = path.charAt(index);
            if(c == '/'){
                if(path.charAt(index-1) == '/'){
                    index++;
                    continue;
                }
                if(point.length() != 0 && curr.length() == 0) {
                    if (point.length() == 2) {
                        if (!stack.empty()) {
                            stack.pop();
                        }
                    }
                    if (point.length() > 2) {
                        stack.push(point.toString());
                    }
                    point.delete(0, point.length());
                }else if(curr.length() != 0 && point.length() == 0) {
                    stack.push(curr.toString());
                    curr.delete(0, curr.length());
                } else {
                    point.delete(0, point.length());
                    curr.delete(0, curr.length());
                }
                index++;
            } else if(c == '.'){
                point.append('.');
                index++;
            } else {
                curr.append(path.charAt(index++));
            }
        }
        if(curr.length() != 0 && point.length() == 0){
            stack.push(curr.toString());
        }
        if(point.length() != 0 && curr.length() == 0) {
            if (point.length() == 2 && !stack.empty()) {
                stack.pop();
            }
            if (point.length() > 2) {
                stack.push(point.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()){
            result.insert(0, stack.pop());
            result.insert(0, "/");
        }
        if(result.length() == 0){
            result.append("/");
        }
        return result.toString();
    }

    public static String simplifyPath2(String path) {
        String[] fields = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String field : fields){
            if(field.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            } else if(!field.equals("") && !field.equals(".")){
                stack.push(field);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()){
            result.insert(0, stack.pop());
            result.insert(0, "/");
        }
        if(result.length() == 0){
            result.append("/");
        }
        return result.toString();
    }

    public static void test(String path, String expected){
        String result = simplifyPath2(path);
        //System.out.println(result);
        System.out.println(result.equals(expected));
        //System.out.println("==");
    }

    public static void main(String[] args) {
        test("/home/" , "/home");
        test("/../" , "/");
        test("/home//foo/", "/home/foo");
        test("/a/./b/../../c/", "/c");
        test("/a/../../b/../c//.//", "/c");
        test("/a//b////c/d//././/..", "/a/b/c");
        test("/...", "/...");
        test("/.", "/");
        test("/.../", "/...");
        test("/..hidden", "/..hidden");
    }

}

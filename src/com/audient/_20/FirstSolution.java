package com.audient._20;

import java.util.Stack;

public class FirstSolution {

    public static void main(String[] args) {
        boolean res = isValid("()[]{}");
        System.out.println(res);
    }

    /**
     *
     * 用栈来解
     * 遇到右括号就取出栈顶元素进行匹配，如果可以匹配，则正确，反之错误
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int len = arr.length;
        // 字符数组的长度不是偶数
        if (len % 2 != 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char ch = stack.pop();
                if (arr[i] == ')' && ch != '(') {
                    return false;
                } else if (arr[i] == ']' && ch != '[') {
                    return false;
                } else if (arr[i] == '}' && ch != '{') {
                    return false;
                } else {

                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}

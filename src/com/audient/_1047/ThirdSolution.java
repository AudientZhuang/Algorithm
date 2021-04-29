package com.audient._1047;



import java.util.Stack;

public class ThirdSolution {

    public static void main(String[] args) {
        String res = removeDuplicates("abbaca");
        System.out.println(res);
    }


    /**
     * 使用Stack进行解题
     *
     * 遍历字符串，逐个判断
     * 如果当前字符与栈顶元素相同，那么就不加入栈，同时删除栈顶元素
     * 如果当前字符与栈顶元素不相同，那么就加入栈
     *
     * @param S
     * @return
     */
    public static String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack();

        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) {
                stack.push(arr[i]);
            }else {
                if (arr[i] == (char)stack.peek()) {
                    stack.pop();
                }else {
                    stack.push(arr[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character s: stack) {
            sb.append(s);
        }

        return sb.toString();

    }



}

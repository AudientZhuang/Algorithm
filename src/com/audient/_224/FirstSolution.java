package com.audient._224;

import java.util.Stack;

public class FirstSolution {

    public static void main(String[] args) {

        //String res = op(1, 2, '-');
        //System.out.println(res);

        int value = calculate("2-(5-6)");
        System.out.println(value);

    }

    /**
     * 基本计算器
     *
     * 用栈来解
     *
     * 将给出的表达式转换为数组，逐个放入栈中，遇到' '不放入，遇到')'则从原来的栈（到'('为止的数据）放到另一个栈中进行运算
     *
     * @param s
     * @return
     */

    public static int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> calStack = new Stack<>();
        String value = "";
        // 将表达式转换为数组形式，便于遍历
        char[] arr = s.toCharArray();
        // 遍历表达式数组，将字符放入栈中
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {    // 如果字符为' '，不执行任何操作

            } else if (arr[i] >= '0' && arr[i] <= '9') { // 如果字符为数字，放入栈中
                stack.push(arr[i]);
            } else if (arr[i] == '(') {  // 如果字符为'('，放入栈中
                stack.push(arr[i]);
            } else if (arr[i] == '+' || arr[i] == '-') {    // 如果字符为'+'或者'-'，放入栈中
                stack.push(arr[i]);
            } else if (arr[i] == ')') { // 如果字符为')'，先把到'('为止的数据放入另一个栈中，再进行运算操作
                while(stack.peek() != '(') {
                    calStack.push(stack.pop());
                }
                // 把'('弹出栈
                stack.pop();

                // 打印一下
                //System.out.println("Stack : " + calStack);

                String valueStr = cal(calStack);
                // 将返回的数字字符串转为字符数组，并放入栈中
                char[] valueArr = valueStr.toCharArray();
                for (int j = 0; j < valueArr.length; j++) {
                    stack.push(valueArr[j]);
                }

            } else {

            }
        }

        if (stack.contains(Character.valueOf('+')) || stack.contains(Character.valueOf('-'))) { // 如果栈里面还有正负号，再进行一次运算
            while (!stack.empty()) {
                calStack.push(stack.pop());
            }
            value = cal(calStack);

        } else {    // 栈里面没有正负号就直接拼接字符串返回
            while (!stack.empty()) {
                value = stack.pop() + value;
            }
        }
        return Integer.valueOf(value);
    }

    public static String cal(Stack<Character> s) {
        String str1 = "";    // 存储第一个数
        String str2 = "";    // 存储第二个数
        char ch = ' ';        // 存储运算符
        char tempChar;
        //System.out.println(s);
        if (!s.contains(Character.valueOf('+')) && !s.contains(Character.valueOf('-'))) {
            while(!s.empty()) {
                tempChar = s.pop();
                str1 += tempChar;
            }
            return str1;


        }
        boolean flag = false;   // 用来标识是不是刚刚取出的字符为运算符
        while (!s.empty()) {
            tempChar = s.pop();
            if (tempChar == '+' || tempChar == '-') {   //当前字符是运算符'+'/'-'

                if ("".equals(str1)) {  // 当前的运算符表示第一个操作数的正负号
                    str1 += tempChar;
                    continue;
                }

                if (flag) { // 上一个字符是运算符，则当前字符表示第二个操作数的正负号
                    str2 += tempChar;
                    continue;
                }

                if (!"".equals(str1) && !"".equals(str2)) { // 当前有需要进行运算的数，先运算，然后把结果赋给第一个数，在记录运算符
                    str1 = op(Integer.parseInt(str1), Integer.parseInt(str2), ch);
                    str2 = "";

                }

                ch = tempChar;
                flag = true;
            } else {    // 当前字符不是运算符
                if (ch == ' ') {    // 还没有运算符，说明当前字符是第一个数的一部分
                    str1 += tempChar;
                } else {    // 有运算符，说明当前字符是第二个数的一部分
                    str2 += tempChar;
                }
                flag = false;
            }
        }
        String res = "";
        if (!"".equals(str1) && !"".equals(str2)) {
            res = op(Integer.parseInt(str1),Integer.parseInt(str2), ch);
        }else {
            res = str1.toString();
        }


        return res;
    }

    /**
     * 根据运算符进行运算操作
     * @param first     第一个数
     * @param second    第二个数
     * @param ch        运算符
     * @return
     */
    public static String op(int first, int second, char ch) {
        //System.out.println("first:" + first + " ,second:" + second + " ,ch:" + ch);
        int res = 0;
        if (ch == '+') {    // 加法运算
            res = first + second;
        } else if (ch == '-') { // 减法运算
            res = first - second;
        }else {

        }
        return String.valueOf(res);
    }

}

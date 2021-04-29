package com.audient._227;

import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstSolution {

    public static void main(String[] args) {

        /*String res = op(1,2,'+');
        System.out.println(res);*/
        System.out.println(calculate(" 31+5 / 2 "));

    }

    /**
     * 使用栈来解题，将字符中的字符逐个遍历
     * ' ' 不入栈
     * 数字 入栈
     * '+'/'-' 入栈
     * '*'/'/' 不入栈，取得两个数之后进行运算，把结果入栈
     * @param s
     * @return
     */
    public static int calculate(String s) {
        //Queue<Character> queue = new LinkedList();

        Stack<Character> stack = new Stack<>();
        Stack<Character> subStack = new Stack<>();
        char[] arr = s.toCharArray();

        int len = arr.length;
        // 遍历数组
        for (int i = 0; i < len; i++) {
            if (arr[i] == ' ') {    // ' '，不入栈
                continue;
            } else if (arr[i] >= '0' && arr[i] <= '9') {    // 数字，入栈
                stack.push(arr[i]);
                //queue.offer(arr[i]);
            } else if (arr[i] == '+' || arr[i] == '-') {    // '+'/'-'， 入栈
                stack.push(arr[i]);
                //queue.offer(arr[i]);
            } else if (arr[i] == '*' || arr[i] == '/') {    // '*'/'/'，记录当前运算符，获取下一个操作数进行运算
                char ch = arr[i];   // 记录当前运算符
                // 从栈中取出第一个操作数
                String num1 = "";
                while (!stack.empty() && stack.peek() != null && stack.peek() >= '0' && stack.peek() <= '9') {
                    num1 = stack.pop() + num1;
                    //num1 += queue.poll();
                }
                // 从剩余的字符串中取出第二个操作数
                // 第二个操作数有两个位置，
                // 1.最后一个数，截取后面整个字符串，去掉空格
                // 2.中间的数，截取到下一个运算符前一个位置，去掉空格
                boolean flag = true;
                String num2 = "";
                while (flag) {
                    i++;
                    if (i >= len) {
                        break;
                    }
                    if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
                        i -= 1;
                        break;
                    }
                    if (arr[i] == ' ') {
                        continue;
                    }
                    if (arr[i] >= '0' || arr[i] <= '9') {
                        num2 += arr[i];
                    }
                }
                // 进行运算
                String value = op(Integer.parseInt(num1), Integer.parseInt(num2), ch);
                // 将结果入栈
                char[] valueStr = value.toCharArray();
                for (int j = 0; j < valueStr.length; j++) {
                    stack.push(valueStr[j]);
                }
            } else {

            }
        }

        while (!stack.empty()) {
            subStack.push(stack.pop());
        }
        String res = cal(subStack);
        return Integer.parseInt(res);
    }

    /**
     * 对栈进行运算，栈中的情况有：
     * 1.只有一个数（有可能有正负号）
     * 2.有两个数，一个运算符
     * @param s
     * @return
     */
    public static String cal(Stack<Character> s) {
        //System.out.println(s);
        String num1 = "";
        String num2 = "";
        char ch = ' ';
        String value = "";
        while (s.contains(Character.valueOf('+')) || s.contains(Character.valueOf('-'))) {
            char temp = s.pop();
            if (temp >= '0' && temp <= '9') {
                if (ch == ' ') {
                    num1 += temp;
                }else {
                    num2 += temp;
                }
            }
            if (temp == '+' || temp == '-') {
                //System.out.println(num1 + "," + num2 + "," + ch);
                if (!"".equals(num1) && !"".equals(num2)) { // 当前已经有操作符，需要先进行运算，然后把运算结果赋给第一个数
                    num1 = op(Integer.parseInt(num1), Integer.parseInt(num2), ch);
                    num2 = "";
                }

                if ("".equals(num1)) {
                    num1 += temp;
                } else {
                    ch = temp;
                }
            }
        }
        // 结束循环之后，栈不为空，里面有一个数，
        // 有几种情况：
        // 1.有两个数，一个运算符
        // 2.有一个数，一个运算符
        // 3.有一个数，没有运算符
        // 将stack里的数取出来
        String lastNum = "";
        while (!s.empty()) {
            lastNum += s.pop();
        }
        // 1.有两个数，一个运算符
        if (!"".equals(num1) && ch != ' ') {
            value = op(Integer.parseInt(num1), Integer.parseInt(lastNum), ch);
        } else if (!"".equals(num1) && ch == ' ') {
            value = num1;
        }
        else if ("".equals(num1) && ch != ' ') {
            value = ch + lastNum;
        } else if ("".equals(num1) && ch == ' ') {
            value = lastNum;
        }


        return value;
    }


    /**
     * 根据运算符对两个数进行运算
     * @param num1
     * @param num2
     * @param ch
     * @return
     */
    public static String op(int num1, int num2, char ch) {
        int value = 0;
        switch (ch) {
            case '+' :
                value = num1 + num2;
                break;
            case '-' :
                value = num1 - num2;
                break;
            case '*' :
                value = num1 * num2;
                break;
            case '/' :
                value = num1 / num2;
                break;
            default:
                value = 0;
        }
        return String.valueOf(value);
    }
}

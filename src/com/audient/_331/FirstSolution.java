package com.audient._331;

import java.util.*;

public class FirstSolution {

    public static void main(String[] args) {

        System.out.println(isValidSerialization("#"));


    }

    public static boolean isValidSerialization(String preorder) {

        String[] strings = preorder.split(",");
        int len = strings.length;

        // 根节点为空
        // 有两种情况
        // 1.字符串数组只有一个元素 true
        // 2.字符串数组有两个或两个以上元素 false

        if ("#".equals(strings[0])) {
            if (len == 1) {
                return true;
            } else {
                return false;
            }

        }


        // 字符串数组长度为0或1，或者（长度-1）%2不等于0，不是正确的二叉树的前序序列化
        if (len <= 1 || (len - 1) % 2 != 0) {
            return false;
        }

        /**
         * 使用栈来解题
         *
         * 定义槽位
         *
         * 如果当前字符不是“#”，则将栈顶元素-1，再压入2
         * 如果当前字符是“#”，则将栈顶元素-1
         * 当栈顶元素=0时，弹栈
         *
         */
        // 9,3,4,#,#,1,#,#,2,#,6,#,#
        Stack<Integer> stack = new Stack<>();
        stack.push(2);  // 根节点不为空，栈顶元素为2
        try {
            for (int i = 1; i < len; i++) {

                int top = stack.pop();
                if (top - 1 != 0) {
                    stack.push(top - 1);
                }
                if (!"#".equals(strings[i])) {

                    stack.push(2);
                }
                //System.out.println(stack);

            }
            //System.out.println(stack);
            if (stack.empty()) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }

    }




}

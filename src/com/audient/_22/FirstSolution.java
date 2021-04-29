package com.audient._22;

import java.util.ArrayList;
import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }


    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        generate(res,"", n, n);

        return res;

    }

    public static void generate(List<String> res, String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }


        if (left == right) {    // 剩余左右括号数相等时，下一个是左括号
            generate(res, str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                generate(res, str + "(", left - 1, right);
            }
            generate(res, str + ")", left, right - 1);
        }
    }

}

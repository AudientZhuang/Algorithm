package com.audient._171;

public class FirstSolution {

    public static void main(String[] args) {
        int res = titleToNumber("FXSHRXW");
        System.out.println(res);
    }


    public static int titleToNumber(String columnTitle) {

        char[] array = columnTitle.toCharArray();
        int len = array.length; // 记录长度
        int num = 0;    // 序号
        // 从后往前遍历数组，每次序号加上当前数字x26^(位数-1)
        for (int i = len - 1; i >= 0; i--) {

            num += (array[i] - 'A' + 1) * Math.pow(26, len - i - 1);

        }
        return num;
    }

}

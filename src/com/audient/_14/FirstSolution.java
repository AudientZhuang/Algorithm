package com.audient._14;

import java.util.Arrays;
import java.util.Comparator;

public class FirstSolution {

    public static void main(String[] args) {
        String[] strs = {"ab","b"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }

    public static String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        // 如果字符串数组为空，返回""
        if (len == 0) {
            return "";
        }
        // 如果字符串数组只有一个字符串，返回该字符串
        if (len == 1) {
            return strs[0];
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? 1 : -1;
            }
        });

        // 取第一个字符串
        String firstStr = strs[0];
        char[] arr = firstStr.toCharArray();

        boolean flag = true;    // 用来标识当前字符串是否是公共前缀

        // 对后面的字符串逐一进行比较，最长公共前缀不会超过第一个字符串的长度
        int i;
        for (i = 0; i < arr.length; i++) {
            for (int j = 1; j < len; j++) {
                // 如果发现不匹配的字符，跳出循环，flag=false
                if (strs[j].toCharArray()[i] != arr[i]) {
                    flag = false;
                    break;
                }
            }
            // 如果发现不匹配的字符，跳出循环
            if (!flag) {
                break;
            }
        }

        if (flag) { // 第一个字符串就是最长公共前缀
            return firstStr;
        } else {    // 第一个字符串的0 到 i-1 就是最长公共前缀
            return firstStr.substring(0, i);
        }
    }

}

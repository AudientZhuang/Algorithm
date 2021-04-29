package com.audient._1047;

import java.util.Arrays;

public class FirstSolution {

    public static void main(String[] args) {

        String res = removeDuplicates("abbaca");
        System.out.println(res);

    }

    public static String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        int len = arr.length;
        arr = duplicateRemoval(arr, len);
        return String.valueOf(arr);
    }

    /**
     * 删除相邻重复项
     * @param arr   待删除相邻重复项的数组
     * @param len   数组长度
     */
    public static char[] duplicateRemoval(char[] arr,int len) {
        // 当数组长度小于等于1的时候，返回
        if (len <= 1) {
            return arr;
        }
        // 遍历当前数组
        int i;
        for (i = 1; i < len; i++) {
            // 存在相邻重复项
            if (arr[i - 1] == arr[i]) {
                arr = deleteElementByIndex(arr, i - 1, i, len);
                arr = duplicateRemoval(arr, len - 2);
                break;
            }
        }
        return arr;

    }

    public static char[] deleteElementByIndex(char[] arr, int begin, int end, int len) {
        char[] newArr = new char[len - end + begin - 1];
        int route = 0;
        for (int i = 0; i < len; i++) {
            if (i < begin || i > end) {
                newArr[route++] = arr[i];
            }
        }
        return newArr;
    }


}

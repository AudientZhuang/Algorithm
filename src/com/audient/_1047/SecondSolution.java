package com.audient._1047;

public class SecondSolution {

    public static void main(String[] args) {
        String res = removeDuplicates("abbaca");
        System.out.println(res);
    }

    private static String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        int len = arr.length;
        // 数组长度小于等于1，不存在相邻重复项
        if (len <= 1) {
            return S;
        }
        int begin = 0;
        int next = 1;
        while (next < len) {
            if (arr[begin] == arr[next]) {
                arr = deleteElementByIndex(arr, begin, next, len);
                len -= 2;
                if (begin != 0) {
                    begin -= 1;
                    next -= 1;
                }

            }else {
                begin++;
                next++;
            }

        }
        return String.valueOf(arr);
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

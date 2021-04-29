package com.audient._12;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstSolution {

    public static void main(String[] args) {

        String res = intToRoman(1994);
        System.out.println(res);
    }

    public static String intToRoman(int num) {

        int sum = 0;    // 用来计算当前已经转换为罗马数字的整数值
        int now = num;  // 用来计算当前还有多少数值没有转换为罗马数字
        StringBuilder sb = new StringBuilder();

        while (sum != num) {
            Map<String, Integer> map = getMap(now);
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry: entries) {
                sb.append(entry.getKey());
                sum += entry.getValue();
                now -= entry.getValue();
            }
        }

        return sb.toString();
    }

    /**
     * 根据给定的整数取得当前的最大的罗马数字
     * @param num
     * @return
     */
    public static Map<String,Integer> getMap(int num) {
        Map<String, Integer> map = new HashMap<>();
        if (num >= 1000) {
            map.put("M", 1000);
        } else if (num >= 900 && num < 1000){
            map.put("CM", 900);
        } else if (num >= 500 && num < 900) {
            map.put("D", 500);
        } else if (num >= 400 && num < 500) {
            map.put("CD", 400);
        } else if (num >= 100 && num < 400) {
            map.put("C", 100);
        } else if (num >= 90 && num < 100) {
            map.put("XC", 90);
        } else if (num >= 50 && num < 90) {
            map.put("L", 50);
        } else if (num >= 40 && num < 50) {
            map.put("XL", 40);
        } else if (num >= 10 && num < 40) {
            map.put("X", 10);
        } else if (num >= 9 && num < 10) {
            map.put("IX", 9);
        } else if (num >= 5 && num < 9) {
            map.put("V", 5);
        } else if (num >= 4 && num < 5) {
            map.put("IV", 4);
        } else if (num >= 1 && num < 4) {
            map.put("I", 1);
        } else {

        }
        return map;
    }


}

package com.audient._516;

import java.util.HashMap;
import java.util.Set;

public class FirstSolution {

    public static void main(String[] args) {

        int res = longestPalindromeSubseq("cbbd");
        System.out.println(res);

    }


    public static int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        Set<Character> keySet = map.keySet();
        for (Character key:
             keySet) {
            int len = map.get(key);
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }

}

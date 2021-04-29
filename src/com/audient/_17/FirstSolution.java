package com.audient._17;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;

public class FirstSolution {


    public static void main(String[] args) {
        List<String> list =  letterCombinations("234");
        System.out.println(list);
    }


    public static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        List<String> res = letterList(list, digits);


        return res;
    }


    public static List<String> letterList(List<String> list, String digits) {
        //System.out.println("list : " + list);
        int len = digits.length();
        if (len == 0) {
            return list;
        }

        String str = digits.substring(len - 1, len);
        List<String> newList = new ArrayList<>();
        if (list.size() == 0) {
            if ("2".equals(str)) {
                list.add("a");
                list.add("b");
                list.add("c");
            } else if ("3".equals(str)) {
                list.add("d");
                list.add("e");
                list.add("f");
            } else if ("4".equals(str)) {
                list.add("g");
                list.add("h");
                list.add("i");
            } else if ("5".equals(str)) {
                list.add("j");
                list.add("k");
                list.add("l");
            } else if ("6".equals(str)) {
                list.add("m");
                list.add("n");
                list.add("o");
            } else if ("7".equals(str)) {
                list.add("p");
                list.add("q");
                list.add("r");
                list.add("s");
            } else if ("8".equals(str)) {
                list.add("t");
                list.add("u");
                list.add("v");
            } else if ("9".equals(str)) {
                list.add("w");
                list.add("x");
                list.add("y");
                list.add("z");
            } else {

            }
        } else {

            if ("2".equals(str)) {
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    newList.add("a" + s);
                    newList.add("b" + s);
                    newList.add("c" + s);
                }
            } else if ("3".equals(str)) {
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    newList.add("d" + s);
                    newList.add("e" + s);
                    newList.add("f" + s);
                }
            } else if ("4".equals(str)) {
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    newList.add("g" + s);
                    newList.add("h" + s);
                    newList.add("i" + s);
                }
            } else if ("5".equals(str)) {
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    newList.add("j" + s);
                    newList.add("k" + s);
                    newList.add("l" + s);
                }
            } else if ("6".equals(str)) {
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    newList.add("m" + s);
                    newList.add("n" + s);
                    newList.add("o" + s);
                }
            } else if ("7".equals(str)) {
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    newList.add("p" + s);
                    newList.add("q" + s);
                    newList.add("r" + s);
                    newList.add("s" + s);
                }
            } else if ("8".equals(str)) {
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    newList.add("t" + s);
                    newList.add("u" + s);
                    newList.add("v" + s);
                }
            } else if ("9".equals(str)) {
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    newList.add("w" + s);
                    newList.add("x" + s);
                    newList.add("y" + s);
                    newList.add("z" + s);
                }
            } else {

            }
            list = newList;
        }
        return letterList(list, digits.substring(0,len - 1));

    }

}

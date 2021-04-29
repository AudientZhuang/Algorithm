package com.audient._13;

public class FirstSolution {

    public static void main(String[] args) {
        int res = romanToInt("MCMXCIV");
        System.out.println(res);
    }



    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int sum = 0;    // 用来计算数字
        for (int i = 0; i < len; i++) {
            switch (arr[i]){
                case 'I':
                    {
                        if (i < len - 1) {  // 当前字符不是最后一个字符
                            if (arr[i + 1] == 'V') {    //下一个字符是'V'，'IV'表示4
                                sum += 4;
                                i++;
                            } else if (arr[i + 1] == 'X') { //下一个字符是'X'，'IX'表示9
                                sum += 9;
                                i++;
                            } else {
                                sum += 1;
                            }
                        } else {
                            sum += 1;
                        }
                    }
                    break;
                case 'V':
                    {
                        sum += 5;
                    }
                    break;
                case 'X':
                    {
                        if (i < len - 1) {  // 当前字符不是最后一个字符
                            if (arr[i + 1] == 'L') {    //下一个字符是'L'，'XL'表示40
                                sum += 40;
                                i++;
                            } else if (arr[i + 1] == 'C') { //下一个字符是'C'，'XC'表示90
                                sum += 90;
                                i++;
                            } else {
                                sum += 10;
                            }
                        } else {
                            sum += 10;
                        }
                    }
                    break;
                case 'L':
                    {
                        sum += 50;
                    }
                    break;
                case 'C':
                    {
                        if (i < len - 1) {  // 当前字符不是最后一个字符
                            if (arr[i + 1] == 'D') {    //下一个字符是'D'，'CD'表示400
                                sum += 400;
                                i++;
                            } else if (arr[i + 1] == 'M') { //下一个字符是'M'，'CM'表示900
                                sum += 900;
                                i++;
                            } else {
                                sum += 100;
                            }
                        } else {
                            sum += 100;
                        }
                    }
                    break;
                case 'D':
                    {
                        sum += 500;
                    }
                    break;
                case 'M':
                    {
                        sum += 1000;
                    }
                    break;
            }

        }

        return sum;
    }

}

package com.audient._36;

import java.util.ArrayList;
import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {
        char[][] board = {
                            {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}
                        };
        boolean result = isValidSudoku(board);
        System.out.println(result);
    }


    public static boolean isValidSudoku(char[][] board) {

        // 1.数字 1-9 在每一行只能出现一次。
        // 2.数字 1-9 在每一列只能出现一次。
        // 3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
        List rowList = new ArrayList(); // 存储行
        List colsList = new ArrayList();    // 存储列
        List square1List = new ArrayList();  // 存储九宫格的值
        List square2List = new ArrayList();  // 存储九宫格的值
        List square3List = new ArrayList();  // 存储九宫格的值

        for (int i = 0; i < 9; i++) {
            rowList.clear();
            colsList.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 检查行
                    if (rowList.contains(board[i][j])) {
                        return false;
                    } else {
                        rowList.add(board[i][j]);
                    }
                    if (j / 3 == 0) {
                        // 检查九宫格
                        if (square1List.contains(board[i][j])) {
                            return false;
                        } else {
                            square1List.add(board[i][j]);
                        }
                        if (i != 0 && (i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                            square1List.clear();
                        }
                    } else if (j / 3 == 1) {
                        // 检查九宫格
                        if (square2List.contains(board[i][j])) {
                            return false;
                        } else {
                            square2List.add(board[i][j]);
                        }
                        if (i != 0 && (i + 1) % 3 == 0 && (j + 1) % 3 == 0) {

                            square2List.clear();
                        }
                    } else if(j / 3 == 2){
                        // 检查九宫格
                        if (square3List.contains(board[i][j])) {
                            return false;
                        } else {
                            square3List.add(board[i][j]);
                        }
                        if (i != 0 && (i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                            square3List.clear();
                        }
                    } else {

                    }

                } else {
                    if (j / 3 == 0) {
                        // 检查九宫格
                        if (i != 0 && (i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                            square1List.clear();
                        }
                    } else if (j / 3 == 1) {
                        // 检查九宫格
                        if (i != 0 && (i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                            square2List.clear();
                        }
                    } else if(j / 3 == 2){
                        if (i != 0 && (i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                            square3List.clear();
                        }
                    } else {

                    }
                }

                if (board[j][i] != '.') {
                    // 检查列
                    if (colsList.contains(board[j][i])) {
                        return false;
                    } else {
                        colsList.add(board[j][i]);
                    }
                }

            }
        }

        return true;
    }
}

package com.audient._11;

import java.util.*;

public class FirstSolution {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }


    /**
     * 暴力，会超时
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int nowArea = minHeight * (j - i);
                maxArea = Math.max(maxArea,nowArea);
            }
        }
        return maxArea;
    }
}

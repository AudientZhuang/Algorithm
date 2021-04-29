package com.audient._11;

public class SecondSolution {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    /**
     * 双指针法 求最大面积
     *
     * 每次移动高度较小的一边
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int minValue;
        while (left < right) {
            minValue = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minValue * (right - left));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }


        return maxArea;
    }


}

package com.audient._27;

public class FirstSolution {

    public static void main(String[] args) {

        int[] nums = {3,2,2,3};
        int val = 3;
        int result = removeElement(nums,val);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }


    public static int removeElement(int[] nums, int val) {
        int len = 0;    // 既是长度，又是下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}

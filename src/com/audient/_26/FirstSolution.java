package com.audient._26;

public class FirstSolution {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }


    public static int removeDuplicates(int[] nums) {

        // 0,0,1,1,1,2,2,3,3,4


        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int len = 0;    // 新长度，也就是有多少个不重复的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[len] != nums[i]){
                len++;
                nums[len] = nums[i];
            }
        }
        return len + 1;
    }



}

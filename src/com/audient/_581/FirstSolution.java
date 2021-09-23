package com.audient._581;

import java.util.Arrays;

public class FirstSolution {

    public static void main(String[] args) {

        //int[] nums = {2,6,4,8,10,9,15};
        //int[] nums = {1,2};
        int[] nums = {1,3,2,2,2};
        int res = findUnsortedSubarray(nums);
        System.out.println("res:" + res);
    }


    public static int findUnsortedSubarray(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int left = 0, right = nums.length - 1;    // 标记左右指针的索引
        boolean l = false, r = false; // 标记左右指针是否找到不符合升序的数
        for (int i = 0; i < nums.length; i++) {
            // 左右指针都找到不符合升序的数，结束循环
            if (l && r) {
                break;
            }
            // 左右指针已经重叠了，结束循环
            if (left >= right) {
                break;
            }

            if (!l) {
                if (nums[left] > nums[left + 1]) {
                    l = true;
                }else {
                    left++;
                }
            }

            if (!r) {
                if (nums[right] < nums[right - 1]) {
                    r = true;
                }else {
                    right--;
                }
            }

        }

        if (l && left > 0) {

            while (nums[left] == nums[left - 1] && left > 0){
                left--;
            }
        }

        if (r && right < nums.length - 1) {

            while (right < nums.length - 1 &&nums[right] == nums[right + 1]){
                right++;
            }
        }


        //System.out.println("left:" + left + " right:" + right);
        /*int[] res = Arrays.copyOfRange(nums, left, right);
        for (int i = 0; i < res.length; i++) {
            System.out.print(" " + i);
        }*/
        //System.out.println("");
        return right - left > 0 ? right - left + 1 : 0;
    }


}




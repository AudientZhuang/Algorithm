package com.audient._16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class FirstSolution {


    public static void main(String[] args) {

        //int[] nums = {-1,2,1,-4};
        int[] nums = {0,1,2};
        int res = threeSumClosest(nums, 0);
        System.out.println(res);
    }


    public static int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        // 三重循环，找到三个数的组合
        for (int i = 0; i < len - 2; i++) {

            for (int j = i + 1; j < len - 1; j++) {


                for (int k = len - 1; k >= j + 1; k--) {

                    int sum = nums[i] + nums[j] + nums[k];

                    //System.out.println("sum:" + sum + " , min:" + min + " ,max:" + max);
                    if (sum <= target) {
                        if (sum > min) {
                            min = sum;
                        }
                    } else {
                        if (sum < max) {
                            max = sum;
                        }
                    }
                    if (min != Integer.MIN_VALUE && max != Integer.MAX_VALUE) {
                        if (target - min < max - target) {
                            res = min;
                        } else {
                            res = max;
                        }
                    } else if (min == Integer.MIN_VALUE) {
                        res = max;
                    } else if (max == Integer.MAX_VALUE) {
                        res = min;
                    }



                }
            }
        }

        


        return res;
    }


}

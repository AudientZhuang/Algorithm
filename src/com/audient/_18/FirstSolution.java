package com.audient._18;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res);
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        int len = nums.length;
        if (len < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int x = j + 1; x < len - 1; x++) {
                    if (x > j + 1 && nums[x] == nums[x - 1]) {
                        continue;
                    }
                    for (int y = x + 1; y < len; y++) {
                        if (y > x + 1 && nums[y] == nums[y - 1]) {
                            continue;
                        }

                        if (nums[i] + nums[j] + nums[x] + nums[y] == target) {
                            path.add(nums[i]);
                            path.add(nums[j]);
                            path.add(nums[x]);
                            path.add(nums[y]);
                            res.add(new ArrayList<>(path));
                            path.clear();
                        }
                    }
                }
            }
        }
        return res;
    }

}

package com.audient._47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};

        List<List<Integer>> lists = permuteUnique(nums);

        System.out.println(lists);

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];

        dfs(nums, len, 0, path, used, res);

        return res;
    }

    public static void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}

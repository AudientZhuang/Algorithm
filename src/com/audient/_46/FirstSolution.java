package com.audient._46;

import java.util.ArrayList;
import java.util.List;

public class FirstSolution {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];


        dfs(nums,len,0,path, used, res);


        return res;
    }

    public static void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len,depth + 1, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }


}

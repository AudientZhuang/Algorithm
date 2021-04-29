package com.audient._15;

import java.util.*;

public class FirstSolution {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }


    /**
     * 用dfs暂时只能过一半的用例
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }

        boolean[] used = new boolean[len];
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, len, 0, 0, used, path, res);

        return res;
    }

    public static void dfs(int[] nums, int len, int depth, int sum, boolean[] used, List<Integer> path, List<List<Integer>> res) {

        if (depth == 3) {
            if (sum == 0) {
                if (path.get(0) + path.get(1) + path.get(2) == 0) {
                    Collections.sort(path, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 > o2 ? 1 : -1;
                        }
                    });
                    if (!res.contains(path)) {
                        res.add(new ArrayList<>(path));
                    }
                }
            }
            return;
        }

        for (int i = 0; i < len; i++) {

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                sum += nums[i];
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, len, depth + 1, sum, used, path, res);
                path.remove(path.size() - 1);
                used[i] = false;
                sum -= nums[i];
            }
        }
    }

}


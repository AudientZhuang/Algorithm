package com.audient._39;

import java.util.*;

public class FirstSolution {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);


    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        int len = candidates.length;
        List<Integer> path = new ArrayList<>();

        dfs(candidates, target, len, 0, 0, path, res);

        for (List<Integer> list : res) {
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 > o2 ? 1 : -1;
                }
            });
        }

        Set set = new HashSet<List<Integer>>(res);

        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>(set);

        return lists;
    }

    public static void dfs(int[] candidates, int target, int len, int depth, int sum, List<Integer> path, List<List<Integer>> res) {
        // 得到满足总数的结果
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 当深度大于总数，即使是1，当深度等于总数的时候已经能够得出结果了
        if (depth > target) {
            return;
        }

        for (int i = 0; i < len; i++) {
            // 如果sum + candidates[i] 小于target， 则a[i]可以加入到结果集中
            if (sum + candidates[i] <= target) {
                path.add(candidates[i]);
                dfs(candidates, target, len, depth + 1, sum + candidates[i], path, res);
                path.remove(path.size() - 1);
            }
        }

    }


}

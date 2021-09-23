package com.audient._137;

import java.util.*;

public class FirstSolution {

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        int res = singleNumber(nums);
        System.out.println(res);
    }

    /**
     * 遍历数组，用一个map来存放值和它对应出现的次数
     *
     * @param nums
     * @return
     */

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();    // 记录值和它出现的次数
        // 遍历数组nums
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) { // 如果map里没有当前值
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return 0;
    }

}

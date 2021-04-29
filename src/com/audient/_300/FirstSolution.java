package com.audient._300;

public class FirstSolution {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int result = lengthOfLIS(nums);
        System.out.println(result);
    }


    /**
     * LTS 最长递增子序列
     *
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        /**
         * 用来记录开头到当前位置最长子序列的数字个数
         */
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];    // 最长子序列的个数
        for (int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j <= i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }

        return max;


    }

}

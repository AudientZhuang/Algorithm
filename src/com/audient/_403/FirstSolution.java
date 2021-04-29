package com.audient._403;

public class FirstSolution {

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }

    /**
     * 动态规划
     * 状态转移方程：dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1]
     *
     * @param stones
     * @return
     */

    public static boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i = 1; i < n; i++) {

            for (int j = i - 1; j >= 0; j--) {

                int k = stones[i] - stones[j];

                if (k > j + 1) {
                    break;
                }

                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];

                if (i == n - 1 && dp[i][k]) {
                    return true;
                }

            }
        }

        return false;


    }

}

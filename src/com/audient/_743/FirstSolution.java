package com.audient._743;

import java.util.Arrays;

public class FirstSolution {

    public static void main(String[] args) {
        //int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int[][] times = {{1,2,1}};
        int res = networkDelayTime(times,2,2);
        System.out.println(res);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF); // 初始化g
        }
        for (int[] t: times) {
            int x = t[0] - 1;
            int y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? - 1 : ans;
    }



}

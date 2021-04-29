package com.audient._354;

import java.util.Arrays;
import java.util.Comparator;

public class FirstSolution {

    public static void main(String[] args) {
        int[][] envelopes = {{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
        int result = maxEnvelopes(envelopes);
        System.out.println(result);
    }

    /**
     * 用贪心算法来解
     * 对信封进行排序，找到最小的信封，再往上找到能够容纳当前信封的最小信封
     *
     * 如何排序？
     * 两个基点，长度和宽度
     * 1.以长度为主，宽度为辅.
     * 2.以宽度为主，长度为辅
     *
     * 分别计算出信封数，再进行比较
     *
     * 如何计算信封数？
     *
     *
     *
     *
     * 用贪心只过了一半的用例，还是得用动态规划来解
     *
     * 选择两个维度（长度、宽度）之一进行排序，另一个作为辅助
     * 之后用最长递增子序列（LTS）的解法来计算信封数
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0){
            return 0;
        }
        if (envelopes.length == 1){
            return 1;
        }
        int[] now;  // 用来记录当前信封
        int maxLength = 1;  // 信封数，以长度为主，宽度为辅
        int maxWidth = 1;   // 信封数，以宽度为主，长度为辅

        /**
         * 以长度为主，宽度为辅，将信封从小到大进行排序
         */
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //System.out.println(o1[0] + "," + o1[1] + "; " + o2[0] + "," + o2[1]);
                //System.out.println(o1[0] >= o2[0] && o1[1] >= o2[1]);

                if (o1[0] > o2[0]){
                    return 1;
                }
                if (o1[0] == o2[0]){
                    if (o1[1] >= o2[1]){
                        return 1;
                    }
                    return -1;
                }
                return -1;
            }
        });

        /*for (int i = 0; i < envelopes.length - 1; i++){
            now = envelopes[i];
            int count = 1;
            for (int j = i + 1; j < envelopes.length; j++){
                if (envelopes[j][0] > now[0] && envelopes[j][1] > now[1]){
                    count++;
                    now = envelopes[j];
                }
            }
            if (count > maxLength){
                maxLength = count;
            }
        }*/
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }



        /*System.out.println("After sort");
        for(int i = 0; i < envelopes.length; i++){
            System.out.println(envelopes[i][0] + "," +  envelopes[i][1]);
        }*/

        //System.out.println("Length:" + maxLength);

        /**
         * 以宽度为主，长度为辅，将信封从小到大进行排序
         */
        /*Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //System.out.println(o1[0] + "," + o1[1] + "; " + o2[0] + "," + o2[1]);
                //System.out.println(o1[0] >= o2[0] && o1[1] >= o2[1]);

                if (o1[1] > o2[1]){
                    return 1;
                }
                if (o1[1] == o2[1]){
                    if (o1[0] >= o2[0]){
                        return 1;
                    }
                    return -1;
                }
                return -1;
            }
        });

        for (int i = 0; i < envelopes.length - 1; i++){
            now = envelopes[i];
            int count = 1;
            for (int j = i + 1; j < envelopes.length; j++){
                if (envelopes[j][1] > now[1] && envelopes[j][0] > now[0]){
                    count++;
                    now = envelopes[j];
                }
            }
            if (count > maxWidth){
                maxWidth = count;
            }
        }
        //System.out.println("width:" + maxWidth);

        System.out.println("宽度为主：");
        for(int i = 0; i < envelopes.length; i++){
            System.out.println(envelopes[i][0] + "," +  envelopes[i][1]);
        }*/

        //return Math.max(maxLength,maxWidth);

        return max;
    }

}

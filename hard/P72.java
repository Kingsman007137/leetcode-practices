//72. 编辑距离
//https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked

public class P72 {
    // 这道题本来是hard的，降级成了medium，但是我觉得还是very hard
    // 详细讲解：https://www.bilibili.com/video/BV1qv4y1q78f/?vd_source=7dad1fb91342de946e45a4b84f0c2d0a
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 转成字符数组，性能会好一些
        char[] cWord1 = word1.toCharArray();
        char[] cWord2 = word2.toCharArray();
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }
        // dp[i][j]表示 word1[0...i] 与 word2[0...j] 之间的编辑距离
        // 这里本来想初始化成int[m][n]，但是处理不了m=1或者n=1的情况，多一行和一列更方便
        int[][] dp = new int[m + 1][n + 1];
        // 初始化，因为动规是看左、上和左上，所以要初始化第一列和第一排
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (cWord1[i - 1] == cWord2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 左，上，左上三个当中取最小，再加上当前一次操作
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

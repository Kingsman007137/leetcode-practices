//62. 不同路径
//https://leetcode.cn/problems/unique-paths/?envType=study-plan-v2&envId=top-100-liked

public class P62 {
    // 比较简单的动态规划，就是if那个优化一开始没想到
    public int uniquePaths(int m, int n) {
        // 多加个“1”不用考虑边界
        int[][] dp = new int[m+1][n+1];
        //看自己的上面和左面的个数之和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //初始条件，左边界和上边界都是1，因为只有一种走法
                if (i == 1 || j == 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}

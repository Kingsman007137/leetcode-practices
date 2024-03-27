//279. 完全平方数
//https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked

public class P279 {
    // 动态规划，还是想不出状态转移方程，还是多研究一下题解的算法
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //dp[0]是状态边界
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j*j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}

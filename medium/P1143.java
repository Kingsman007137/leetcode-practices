//1143. 最长公共子序列
//https://leetcode.cn/problems/longest-common-subsequence/?envType=study-plan-v2&envId=top-100-liked

public class P1143 {
    // 二维动态规划，状态转移方程还是要多思考和理解
    // 看：https://leetcode.cn/problems/longest-common-subsequence/solutions/67460/dong-tai-gui-hua-zhi-zui-chang-gong-gong-zi-xu-lie
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        //变成数组快一点
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        //dp[i][j] == text1[0...i-1]和text2[0...j-1]的最长公共子序列(多加一个1解决下标小于0越界问题)
        int[][] dp = new int[n + 1][m + 1];
        //别忘了从1开始到字符串长度结束
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //这里的逻辑要再思考一下
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //不用考虑dp[i-1][j-1]，它永远是三者中最小的，max 根本不可能取到它
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        P1143 p = new P1143();
        System.out.println(p.longestCommonSubsequence("abcde", "ace"));
    }
}

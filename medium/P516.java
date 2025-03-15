// 516. 最长回文子序列
// https://leetcode.cn/problems/longest-palindromic-subsequence/description/

public class P516 {
    // 直接把字符串翻转一下，就变成最长公共子序列问题了 (P1143)
    public int longestPalindromeSubseq(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int n = s1.length();
        // 用数组比charAt()快很多
        char[] arr1 = s.toCharArray();
        char[] arr2 = s1.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        // 这里要设置成1开始，不然涉及到i-1,j-1情况很难处理
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] =dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] =Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

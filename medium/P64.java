//64. 最小路径和
//https://leetcode.cn/problems/minimum-path-sum/?envType=study-plan-v2&envId=top-100-liked

import java.util.Arrays;

public class P64 {
    // 递归 + 备忘录法，可以研究一下
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(m - 1, n - 1, grid, cache);
    }

    //备忘录法递归
    public int dfs(int x, int y, int[][] grid, int[][] cache) {
        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        if (x == 0 && y == 0) return grid[0][0];
        if (cache[x][y] != -1) return cache[x][y];
        cache[x][y] = Math.min(dfs(x - 1, y, grid, cache), dfs(x, y - 1, grid, cache)) + grid[x][y];
        return cache[x][y];
    }

    // 自己想出来的动态规划方法，只不过一开始没考虑边界情况
    // public int minPathSum(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][] dp = new int[m+1][n+1];
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 1; j <= n; j++) {
    //             int down = dp[i-1][j] + grid[i-1][j-1];
    //             int right = dp[i][j-1] + grid[i-1][j-1];
    //             if (i == 1) {
    //                 dp[i][j] = right;
    //             } else if (j == 1) {
    //                 dp[i][j] = down;
    //             } else {
    //                 dp[i][j] = Math.min(down, right);
    //             }
    //         }
    //     }
    //     return dp[m][n];
    // }
}

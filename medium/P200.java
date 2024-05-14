//200. 岛屿数量
//https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked

public class P200 {
    // 正确的思路应该是见到一个'1'就将计数器加一，然后把它连成的一个岛都变成'0'
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    recursion(grid, i, j);
                    cnt ++;
                }
            }
        }
        return cnt;
    }
    // 这里的判断逻辑很有意思，一直到越出边界了才返回，但也不会让数组用越界的下标
    private void recursion(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        recursion(grid, row - 1, col);
        recursion(grid, row, col - 1);
        recursion(grid, row + 1, col);
        recursion(grid, row, col + 1);
    }
}

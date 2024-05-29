//994. 腐烂的橘子
//https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.LinkedList;
import java.util.Queue;

public class P994{
    // 关键：题目转化为求腐烂橘子到所有新鲜橘子的最短路径，所以用BFS
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;// 记录一开始新鲜橘子数量，看看最后还有没有剩
                } else if (grid[i][j] == 2) {
                    // 一开始腐烂橘子的坐标，BFS的第一层
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minute = 0;
        // 一开始忘了还要判断 count > 0，否则如果一开始全是腐烂的就会出错
        while (count > 0 && !queue.isEmpty()) {
            minute++; // 一分钟遍历一"层"
            int size = queue.size();
            // 要遍历完这一"层"才到下一轮循环
            for (int i = 0; i < size; i++) {
                int[] index = queue.poll();
                int r = index[0], c = index[1];
                if (r + 1 < m && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    queue.add(new int[]{r + 1, c});
                }
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count--;
                    queue.add(new int[]{r - 1, c});
                }
                if (c + 1 < n && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    count--;
                    queue.add(new int[]{r, c + 1});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    count--;
                    queue.add(new int[]{r, c - 1});
                }
            }
        }

        return count == 0 ? minute : -1;
    }
}
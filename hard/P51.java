//51. N 皇后
//https://leetcode.cn/problems/n-queens/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51 {
    // https://leetcode.cn/problems/n-queens/solutions/2566744/dai-ma-sui-xiang-lu-leetcode51nhuang-hou-hcat
    // 方法2：使用boolean数组表示已经占用的直(斜)线 （这个效率高，但不太懂）
    List<List<String>> res = new ArrayList<>();
    boolean[] usedCol, usedDiag45, usedDiag135;    // boolean数组中的每个元素代表一条直(斜)线
    public List<List<String>> solveNQueens(int n) {
        usedCol = new boolean[n];                  // 列方向的直线条数为 n
        usedDiag45 = new boolean[2 * n - 1];       // 45°方向的斜线条数为 2 * n - 1
        usedDiag135 = new boolean[2 * n - 1];      // 135°方向的斜线条数为 2 * n - 1
		//用于收集结果, 元素的index表示棋盘的row，元素的value代表棋盘的column
        int[] board = new int[n];
        backTracking(board, n, 0);
        return res;
    }
    
    private void backTracking(int[] board, int n, int row) {
        if (row == n) {
            //收集结果
            List<String> temp = new ArrayList<>();
            for (int i : board) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[i] = 'Q';
                temp.add(new String(str));
            }
            res.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (usedCol[col] | usedDiag45[row + col] | usedDiag135[row - col + n - 1]) {
                continue;
            }
            board[row] = col;
			// 标记该列出现过
            usedCol[col] = true;
			// 同一45°斜线上元素的row + col为定值, 且各不相同
            usedDiag45[row + col] = true;
			// 同一135°斜线上元素row - col为定值, 且各不相同
			// row - col 值有正有负, 加 n - 1 是为了对齐零点
            usedDiag135[row - col + n - 1] = true;
            // 递归
            backTracking(board, n, row + 1);
            usedCol[col] = false;
            usedDiag45[row + col] = false;
            usedDiag135[row - col + n - 1] = false;
        }
    }

    // --------------------------------------------------------------------
    // 看完代码随想录后用的蠢方法，AC了但性能不佳
    // List<List<String>> res = new ArrayList();
    // public List<List<String>> solveNQueens(int n) {
    //     // 先初始化棋盘，用List<String>太难操作，先转成char[][]
    //     char[][] board = new char[n][n];
    //     for (int i = 0; i < n; i++) {
    //         Arrays.fill(board[i], '.');
    //     }
    //     // 从第0行开始回溯，每行试n种排列
    //     backtrace(n, 0, board);
    //     return res;
    // }

    // private void backtrace(int n, int row, char[][] board) {
    //     if (row == n) {
    //         List<String> result = toResult(board);
    //         res.add(new ArrayList(result));
    //     }
    //     // 这一行的每一列都试一下
    //     for (int i = 0; i < n; i++) {
    //         if (isValid(board, row, i)) {
    //             board[row][i] = 'Q';
    //             backtrace(n, row + 1, board);
    //             board[row][i] = '.'; // 回溯
    //         }
    //     }
    // }

    // private boolean isValid(char[][] board, int row, int col) {
    //     // 不需要判断此行及一下行，因为还没遍历到那里，不可能有Q
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < board[0].length; j++) {
    //             if ((j == col || j + i == row + col || i - j == row - col) && board[i][j] == 'Q') {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // private List<String> toResult(char[][] board) {
    //     List<String> list = new ArrayList();
    //     for (int i = 0; i < board.length; i++) {
    //         String str = String.valueOf(board[i]);
    //         list.add(str);
    //     }
    //     return list;
    // }
}

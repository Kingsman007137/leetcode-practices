//36. 有效的数独
//https://leetcode.cn/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150

public class P36 {
    //还是用哈希表的思想更好，但是难想到
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10], col = new boolean[10][10], area = new boolean[10][10];        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if (c == '.') {
                    continue;
                }

                int u = c - '0';
                int idx = i / 3 * 3 + j / 3; // idx就是给九个块从上到下，从左到右编号（0索引）
                if (row[i][u] || col[j][u] || area[idx][u]) return false;
                row[i][u] = col[j][u] = area[idx][u] = true;
            }
        }
        return true;
    }

    // 1ms搞定，但代码质量太垃圾，各种if，for嵌套太多，不会合为一体。
    // public static boolean isValidSudoku(char[][] board) {
    //     for (int i = 0; i < 9; i++) {
    //         for (int j = 0; j < 9; j++) {
    //             char c = board[i][j];
    //             if (c == '.') {
    //                 continue;
    //             }
    //             for (int k = i + 1; k < 9; k++) {
    //                 if (c == board[k][j]) {
    //                     return false;
    //                 }
    //             }
    //             for (int l = j + 1; l < 9; l++) {
    //                 if (c == board[i][l]) {
    //                     return false;
    //                 }
    //             }

    //             //3 x 3判断，比较麻烦，但同行同列的就不用判断了
    //             for (int k = i/3 * 3; k < (i/3 + 1) * 3; k++) {
    //                 for (int l = j/3 * 3; l < (j/3 + 1) * 3; l++) {
    //                     if (k == i || l == j) {
    //                         continue;
    //                     }
    //                     if (c == board[k][l]) {
    //                         return false;
    //                     }
    //                 }
    //             } 
                
    //         }
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        char[][] board = 
        {{'.','.','.','1','8','.','.','.','7'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','.','.','.','.','.','3'},
        {'4','.','3','.','.','.','.','1','9'},
        {'.','.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'1','.','.','.','5','.','.','.','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'.','.','.','5','.','.','.','.','6'}};
        System.out.println(isValidSudoku(board));
    }
}

//73. 矩阵置零
//https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked

public class P73 {
    // 用第一行和第一列来记录对应行和列是否需要置零，但是第一行和第一列本身也需要置零，所以需要额外的标记
    // 这里只用了一个变量来标记第一列是否需要置零，这个标记重要，因为它可以防止第一行被提前置零，影响第一行
    // 其他的的元素，画一下图就明白
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

    // 我一开始使用两个Set来记录需要置零的行和列，但是这样时间和空间复杂度都比较差
    // 其实可以用两个标记数组来记录，再遍历一次矩阵，碰到元素行或列有标记过的就置零
    // public void setZeroes(int[][] matrix) {
    //     int m = matrix.length, n = matrix[0].length;
    //     boolean[] row = new boolean[m];
    //     boolean[] col = new boolean[n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == 0) {
    //                 row[i] = col[j] = true;
    //             }
    //         }
    //     }
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (row[i] || col[j]) {
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }
}

//48. 旋转图像
//https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked

public class P48 {
    // 四方位交换来旋转，对左上角操作就可以整个矩阵搞定。注意边界条件
    // n为偶数，取前n/2行，n为奇数，取前(n+1)/2行，所以 j < (n+1)/2 都符合
    // https://leetcode.cn/problems/rotate-image/solutions/1228078/48-xuan-zhuan-tu-xiang-fu-zhu-ju-zhen-yu-jobi
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

    // 直接用了一个辅助数组，但题目更希望我们连辅助数组都不用，直接原地来
    // public void rotate(int[][] matrix) {
    //     int n = matrix.length;
    //     int[][] copy = new int[n][n];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             copy[i][j] = matrix[i][j];
    //         }
    //     }
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             matrix[j][n-1-i] = copy[i][j];
    //         }
    //     }
    // }
}

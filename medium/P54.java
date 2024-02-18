//54. 螺旋矩阵
//https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.ArrayList;
import java.util.List;

public class P54 {
    // 定义左和右，上和下，每个内层循环前先判断是否还能继续，不能就是遍历完了
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;

        int u = 0, d = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;

        while (true) {
            for (int i = l; i <= r; i++) { // 左->右
                ans.add(matrix[u][i]);
            }
            if (++u > d) break;
            for (int i = u; i <= d; i++) { // 上->下
                ans.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) { // 右->左
                ans.add(matrix[d][i]);
            }
            if (--d < u) break;
            for (int i = d; i >= u; i--) { // 下->上
                ans.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return ans;
    }

    // 代码太过复杂，把自己都绕晕了，还是完不成所有测试用例
    // public static List<Integer> spiralOrder(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     List<Integer> res = new ArrayList();
    //     int idx1 = 0, idx2 = 0;
    //     //右下左上状态
    //     int status = 0;
    //     //每个方向各已返回多少列 0:上，1:右，2:下，3:左
    //     int[] times = new int[4];
    //     for (int i = 0; i < m * n;) {
    //         if (status == 0) {
    //             if (!res.isEmpty()) {
    //                 idx1++;
    //                 idx2++;
    //             }
    //             while (idx2 < n - times[1]) {
    //                 res.add(matrix[idx1][idx2++]);
    //                 i++;
    //             }
    //             System.out.println(res + " " + idx1 + " " + idx2 + " " + status);
    //             times[0]++;
    //             status = 1;
    //         } else if (status == 1) {
    //             if (idx2 >= n) {
    //                 idx2--;
    //             }
    //             ++idx1;
    //             while (idx1 < m - times[2]) {
    //                 res.add(matrix[idx1++][idx2]);
    //                 i++;
    //             }
    //             System.out.println(res + " " + idx1 + " " + idx2 + " " + status);
    //             times[1]++;
    //             status = 2;
    //         } else if (status == 2) {
    //             if (idx1 >= m) {
    //                 idx1--;
    //             }
    //             --idx2;
    //             while (idx2 >= times[3]) {
    //                 res.add(matrix[idx1][idx2--]);
    //                 i++;
    //             }
    //             System.out.println(res + " " + idx1 + " " + idx2 + " " + status);
    //             times[2]++;
    //             status = 3;
    //         } else if (status == 3) {
    //             if (idx2 < 0) {
    //                 idx2++;
    //             }
    //             --idx1;
    //             while (idx1 >= times[0]) {
    //                 res.add(matrix[idx1--][idx2]);
    //                 i++;
    //             }
    //             System.out.println(res + " " + idx1 + " " + idx2 + " " + status);
    //             times[3]++;
    //             status = 0;
    //         }
    //     }
    //     return res;
    // }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] matrix = {{1, 2}, {3, 4}};
        //int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        //int[][] matrix = {{2, 5, 8}, {4, 0, -1}};
        System.out.println(spiralOrder(matrix));
    }
}

//240. 搜索二维矩阵 II
//https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked

public class P240 {
    // 最优雅的解，从左下角开始，如果当前值大于target，那么往上走，消去这一行，否则往右走，消去这一列
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length) {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    // 我的思路是对整个矩阵二分查找，但这样每一次会朝着两个方向改变，有时会漏掉情况
    // 原来答案是每一行二分查找，不过这样时间复杂度是O(mlogn)，不是最优解
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     for (int[] row : matrix) {
    //         int index = search(row, target);
    //         if (index >= 0) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public int search(int[] nums, int target) {
    //     int low = 0, high = nums.length - 1;
    //     while (low <= high) {
    //         int mid = (high - low) / 2 + low;
    //         int num = nums[mid];
    //         if (num == target) {
    //             return mid;
    //         } else if (num > target) {
    //             high = mid - 1;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return -1;
    // }
}

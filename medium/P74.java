//74. 搜索二维矩阵
//https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked

public class P74 {
    // 一次二分查找，将二维数组首位相接变成一维数组，然后进行二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            // 最关键的一步
            int x = matrix[mid / m][mid % m];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // 两次二分查找，判断较乱，性能较差
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int n = matrix.length, m = matrix[0].length;
    //     int head1 = 0, tail1 = n - 1;
    //     int head2 = 0, tail2 = m - 1;
    //     int mid1 = 0, mid2 = 0;
    //     while(head1 <= tail1) {
    //         mid1 = (head1 + tail1) / 2;
    //         System.out.println(mid1 + " " + head1 + " " + tail1);
    //         if (matrix[mid1][0] == target) {
    //             return true;
    //         } else if (matrix[mid1][0] > target) {
    //             if (mid1 > 0 && mid1 - 1 == head1) {
    //                 //此时就算有也肯定在head1这一行
    //                 mid1 = head1;
    //                 break;
    //             }
    //             tail1 = mid1 - 1;
    //         } else {
    //             if (matrix[mid1][tail2] >= target) {
    //                 //只可能在mid1这一行
    //                 break;
    //             }
    //             head1 = mid1 + 1;
    //         }
    //     }

    //     while (head2 <= tail2) {
    //         mid2 = (head2 + tail2) / 2;
    //         if (matrix[mid1][mid2] == target) {
    //             return true;
    //         } else if (matrix[mid1][mid2] > target) {
    //             tail2 = mid2 - 1;
    //         } else {
    //             head2 = mid2 + 1;
    //         }
    //     }

    //     return false;
    // }
}

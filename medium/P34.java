//34. 在排序数组中查找元素的第一个和最后一个位置
//https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-100-liked

public class P34 {
    // 两次二分查找，分开查找第一个和最后一个
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        // 找第一个等于target的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                first = middle;
                right = middle - 1; // 重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // 最后一个等于target的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                last = middle;
                left = middle + 1; // 重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[]{first, last};
    }

    // 二分查找，找到一个target后，再向左右两边查找，但是最坏情况下时间复杂度为O(n)
    // public int[] searchRange(int[] nums, int target) {
    //     int n = nums.length;
    //     if (n == 0) {
    //         return new int[]{-1, -1};
    //     }
    //     int begin = 0, end = n - 1;
    //     int mid = 0;
    //     while (begin <= end) {
    //         mid = (begin + end) / 2;
    //         int x = nums[mid];
    //         if (x > target) {
    //             end = mid - 1;
    //         } else if (x < target) {
    //             begin = mid + 1;
    //         } else {
    //             //这里的判断可能有点啰嗦
    //             for (begin = mid; begin >= 0; begin--) {
    //                 if (nums[begin] != target) {
    //                     begin++;
    //                     break;
    //                 } else if (begin == 0) {
    //                     break;
    //                 }
    //             }
    //             for (end = mid; end < n; end++) {
    //                 if (nums[end] != target) {
    //                     end--;
    //                     break;
    //                 } else if (end == n - 1) {
    //                     break;
    //                 }
    //             }
    //             return new int[]{begin, end};                
    //         }
    //     }
    //     return new int[]{-1, -1};
    // }
}

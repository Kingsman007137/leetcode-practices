//153. 寻找旋转排序数组中的最小值
//https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-100-liked

public class P153 {
    // 比较简洁的写法，一直跟最后一个值比较，如果比最后一个值大，说明最小值在右边，反之在左边
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = -1;
        int right = n - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[n - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right];
    }

    // 我的方法，理解了思路，但是还是有很多繁杂的判断
    // public int findMin(int[] nums) {
    //     int n = nums.length;
    //     int left = 0, right = n - 1;
    //     int mid;
    //     // 先判断整个数组都是升序的
    //     if (nums[left] <= nums[right]) {
    //         return nums[left];
    //     }
    //     while (left < right) {
    //         mid = (left + right) / 2;
    //         // 如果左边值大于中间值，说明最小值左边区间
    //         if (nums[left] > nums[mid]) {
    //             right = mid - 1;
    //             if (nums[right] > nums[mid]) {
    //                 return nums[mid];
    //             }
    //         } else { //反之，左边区间是升序，最小值在右边区间
    //             left = mid + 1;
    //             if (nums[left] < nums[mid]) {
    //                 return nums[left];
    //             }
    //         }
    //     }

    //     return nums[left];
    // }
}

//33. 搜索旋转排序数组
//https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked

public class P33 {
    // 把数组一分为二，肯定有一边是升序排列好的，如果目标数在这个范围内就去二分查找
    // 不在的话去另一边继续一分为二
    public int search(int[] nums, int target) {
        int n = nums.length;
        int begin = 0, end = n - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 这里必须用到 <=，因为除以2朝前进位
            if (nums[begin] <= nums[mid]) { //左边是递增顺序
                if (target >= nums[begin] && target < nums[mid]) {
                    end = mid - 1;
                } else { // 不在这个范围里面，就去右边继续一分为二
                    begin = mid + 1;
                }
            } else { //右边是递增顺序
                if (target > nums[mid] && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}

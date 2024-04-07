//35. 搜索插入位置
//https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked

public class P35 {
    // 原来如此简单，只是要想清楚为啥没查找到就返回left
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //----------------------------------------------------------------
    // 自己实现的二分查找，就是逻辑判断那里有点混乱
    // int res = 0;
    // public int searchInsert(int[] nums, int target) {        
    //     int left = 0, right = nums.length - 1;
    //     binarySearch(left, right, nums, target);
    //     return res;
    // }

    // public void binarySearch(int left, int right, int[] nums, int target) {
    //     int mid = (left + right) / 2;
    //     if (nums[mid] == target || (mid == 0 && nums[0] > target)) {
    //         // 找到相等的或者此数应该插入到0下标位置
    //         res = mid;
    //         return;
    //     } else if (mid == nums.length - 1 || (nums[mid] < target && nums[mid + 1] > target)) {
    //         // 应该插入到mid+1下标位置或者已经到最后一个（也是插入到mid+1下标位置）
    //         res = mid + 1;
    //         return;
    //     } else if (nums[mid] > target) {
    //         binarySearch(left, mid - 1, nums, target);
    //     } else {
    //         binarySearch(mid + 1, right, nums, target);
    //     }
    // }
}

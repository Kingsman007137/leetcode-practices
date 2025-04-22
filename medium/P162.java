// 162. 寻找峰值
// https://leetcode.cn/problems/find-peak-element/description/

public class P162 {
    // 因为左右两端无穷小，而且相邻元素不相等，所以数组内必然有峰值
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            // 此时num[mid] 可能为峰值，而 nums[mid+1] 必然不为峰值
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    // 我自己的答案，还是想多了
    // public int findPeakElement(int[] nums) {
    //     int n = nums.length;
    //     if (n == 1) {
    //         return 0;
    //     }
    //     int left = 0, right = n - 1;
    //     int lefti, righti; //mid紧挨的左右两边索引
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         lefti = mid - 1; righti = mid + 1; //mid的左右两边，如果比mid小，mid就是峰顶
    //         if (lefti != -1 && righti != n) {
    //             if (nums[mid] > nums[lefti] && nums[mid] > nums[righti]) {
    //                 return mid;
    //             }
    //         } else if (lefti != -1 && nums[mid] > nums[lefti]) { //边界也算峰顶
    //             return mid;
    //         } else if (righti != n && nums[mid] > nums[righti]) {
    //             return mid;
    //         }

    //         // 如果lefti或righti越界了，说明mid是边界，mid不是峰顶，那只能是另一边了
    //         if (lefti == -1) {
    //             return righti;
    //         } else if (righti == n) {
    //             return lefti;
    //         } else if (nums[lefti] > nums[righti]) { 
    //             // 没到边界的话，那肯定大的那一端有峰顶
    //             //（小的也可能有，比如mid是谷底的情况，但大的那边是必定有）
    //             right = lefti;
    //         } else {
    //             left = righti;
    //         }
    //     }

    //     return 0;
    // }
}

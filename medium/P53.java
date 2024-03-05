//53. 最大子数组和
//https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked

public class P53 {
    // 分治法见题解吧，理解不了

    // 动态规划, 但就是关键的更新步骤没想到
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 这是整个步骤关键，以第 i 个数结尾的「连续子数组的最大和」，就只有两种可能
            // 要不就是以第 i - 1 个数结尾的「连续子数组的最大和」加上这个数，要不就是这个数
            pre = Math.max(nums[i], nums[i] + pre);
            max = Math.max(max, pre);
        }
        return max;
    }

    // 我这完全就是瞎蒙双指针，哪边小就减去哪边再比较，肯定有测试用例过不了
    // public int maxSubArray(int[] nums) {
    //     int sum = 0;
    //     for (int i =0; i < nums.length; i++) {
    //         sum += nums[i];
    //     }
    //     int max = sum;
    //     int low = 0, high = nums.length - 1;
    //     while (low < high) {
    //         if (nums[low] < nums[high]) {
    //             sum -= nums[low];
    //             low++;
    //         } else {
    //             sum -= nums[high];
    //             high--;
    //         }
    //         max = Math.max(max, sum);
    //     }
    //     return nums.length == 1 ? nums[0] : max;
    // }

    public static void main(String[] args) {
        System.out.println(new P53().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}

//300. 最长递增子序列
//https://leetcode.cn/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=top-100-liked

import java.util.Arrays;

public class P300 {
    // 自己想出的动态规划，dp[i]表示以nums[i]结尾的最长递增子序列的长度
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //每个子序列最少都有一个元素
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //如果nums[i]比nums[j]大，那么dp[i]可以更新为dp[j] + 1
                    //但dp[i]要取前面所有的dp[j] + 1的最大值
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max == Integer.MIN_VALUE ? 1 : max;
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        //最大的长度不一定是dp[n - 1]
        return res;
    }

    // 二分法求长度，但是看不太懂
    // https://writings.sh/post/longest-increasing-subsequence-revisited#%E5%88%86%E5%B1%82-dag-%E5%BB%BA%E6%A8%A1
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] d = new int[n];
    //     //每个子序列最少都有一个元素
    //     Arrays.fill(d, 1);
    //     int res = 0;
    //     for (int i = 0; i < n; i++) {
    //         int left = 0;
    //         int right = res;
    //         while (left < right) {
    //             int mid = left + (right - left) / 2;
    //             if (d[mid] < nums[i]) {
    //                 left = mid + 1;
    //             } else {
    //                 right = mid;
    //             }
    //         }
    //         d[left] = nums[i];
    //         if (right == res) {
    //             res++;
    //         }
    //     }
    //     return res;
    // }
}

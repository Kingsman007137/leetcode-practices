//416. 分割等和子集
//https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.Arrays;

public class P416 {
    // 以下两个方法都是将其转化为类似0-1背包问题，只不过这个是把二维dp数组压缩成了一维
    // 这个背包容量为sum/2，每个物品的重量为nums[i]，价值为nums[i]
    // 可以看看视频：https://www.bilibili.com/video/BV1rt4y1N7jE/?spm_id_from=333.788&vd_source=7dad1fb91342de946e45a4b84f0c2d0a
    // 仔细研究题解：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution/
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        // 这里的初始化只需要dp[0] = true，其他的都是false
        dp[0] = true;
        for (int num: nums) {
            for (int x = target; x >= num; x--) {
                if (dp[x - num]){
                    dp[x] = true;
                }
            }
        }
        return dp[target];
    }

    // public boolean canPartition(int[] nums) {
    //     int n = nums.length;
    //     int sum = 0, maxNum = 0;
    //     for (int i = 0; i < n; i++) {
    //         sum += nums[i];
    //         maxNum = Math.max(maxNum, nums[i]);
    //     }
    //     if (sum % 2 == 1 || maxNum > sum / 2) {
    //         return false;
    //     }
        
    //     int target = sum / 2;
    //     boolean[][] dp = new boolean[n][target + 1];
    //     // 初始化, 很有讲究的
    //     for (int i = 0; i < n; i++) {
    //         dp[i][0] = true;
    //     }
    //     dp[0][nums[0]] = true;
    //     for (int i = 1; i < n; i++) {
    //         int num = nums[i];
    //         for (int j = 1; j <= target; j++) {
    //             if (j >= num) {
    //                 dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
    //             } else {
    //                 dp[i][j] = dp[i - 1][j];
    //             }
    //         }
    //     }
    //     return dp[n - 1][target];
    // }
}

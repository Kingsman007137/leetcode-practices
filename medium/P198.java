//198. 打家劫舍
//https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked

public class P198 {
    // 类似斐波那契和爬楼梯，滚动数组省空间
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p = 0, q = 0, r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            p = q;
            q = r;
            r = Math.max(q, p + nums[i]);
        }
        return r;
    }

    // 动态规划，状态转移方程中dp与nums的下标关系要注意
    // 其实就是每个房子都判断偷还是不偷更划算，偷的话就是dp[i-2]+nums[i-1]，不偷的话就是dp[i-1]
    // public int rob(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     int[] dp = new int[nums.length + 1];
    //     dp[1] = nums[0];
    //     for (int i = 2; i <= nums.length; i++) {
    //         dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
    //     }
    //     return dp[nums.length];
    // }
}

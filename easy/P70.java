//70. 爬楼梯
//https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-100-liked

public class P70 {
    // 和下方思路一样，但由于只需要涉及三个数，我们可以用三个变量设计一个“滚动数组”
    int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q; 
            q = r; 
            r = p + q;
        }
        return r;
    }

    // 动态规划，重点找状态转换方程，怎么一步步解决问题
    // public int climbStairs(int n) {
    //     int[] dp = new int[n + 1];
    //     //初始化一下条件，dp[0]无意义，是为了让dp[2]为2，也可以不管dp[0]，初始化dp[2]为2，循环从3开始
    //     dp[0] = 1; 
    //     dp[1] = 1; //第一层台阶有一种方案
    //     for (int i = 2; i <= n; i++) {
    //         //等于 2 部分之和： 1、先爬一步，加上后面的n-1阶楼梯爬法 
    //         //2、先爬两步，加上后面的n-2阶楼梯爬法。
    //         dp[i] = dp[i - 1] + dp[i - 2];
    //     }
    //     return dp[n];
    // }
}

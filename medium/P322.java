//322. 零钱兑换
//https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.Arrays;

public class P322 {
    //动态规划：选一个coin构成amount - coin的最少硬币数，然后加上1就是amount的最少硬币数
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        //先用amount + 1填充数组，因为不可能答案是amount + 1
        Arrays.fill(dp, amount + 1);
        //状态边界，可以理解为0元钱要0张零钱
        dp[0] = 0; //注意要先fill再设边界为0
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >=0) {
                    //状态转移方程是想出来了，但一开始像P279一样引入了个min就有很多边界情况考虑不到。
                    //而直接用dp[i]则没事，因为如果dp[i -coins[j]]无解的话dp[i -coins[j]] + 1就是
                    //amount + 2，比dp[i]初值大
                    dp[i] = Math.min(dp[i], dp[i -coins[j]] + 1);
                }
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}

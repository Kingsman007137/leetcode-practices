// 32. 最长有效括号
// https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.Arrays;

public class P32 {
    // 题解：https://leetcode.cn/problems/longest-valid-parentheses/solutions/314683/zui-chang-you-xiao-gua-hao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
    public int longestValidParentheses(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 0; // 一个括号成不了有效子串
        for (int i = 1; i < n; i++) {
            if (charArray[i] == ')') {
                if (charArray[i - 1] == '(') {
                    dp[i] = i - 2 > 0 ? dp[i - 2] + 2 : 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && charArray[i - dp[i - 1] - 1] == '(') {
                        dp[i] = i - dp[i - 1] - 2 > 0 
                                ? dp[i-1] + dp[i-dp[i-1]-2] + 2 // 例如"()(())"最后一个右括号
                                : dp[i-1] + 2; // 例如"(())"最后一个右括号
                    } else { // "())"最后一个右括号
                        dp[i] = 0;
                    }
                }
            }
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }
}

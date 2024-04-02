//139. 单词拆分
//https://leetcode.cn/problems/word-break/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.List;

public class P139 {
    //动态规划，dp[i]表示字符串s的前i个字符能否拆分成wordDict里的单词
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //默认值是false
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                //dp[i]是false的话就说明单词集没办法匹配到这个字符之前的字符串
                continue;
            }
            for (String word : wordDict) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i + len).equals(word)) {
                    dp[i + len] = true;
                }
            }
        }
        return dp[n];
    }
}

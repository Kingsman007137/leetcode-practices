//131. 分割回文串
//https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.List;

public class P131 {
    // 回溯法，看了题解后自己做出，这个动态规划先判断回文串的方法很巧妙
    // https://leetcode.cn/problems/palindrome-partitioning/solutions/640189/wei-sha-yao-zhe-yang-bao-sou-ya-shi-ru-h-41gf
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] huiwen = new boolean[n][n];
        List<String> cur = new ArrayList();
        List<List<String>> res = new ArrayList();
        //动态规划，huiwen[i][j]判断s[i...j]是否为回文
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    huiwen[i][j] = true;
                } else if (j - i == 1) {
                    //一开始漏了这种情况
                    huiwen[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    //状态转移方程
                    huiwen[i][j] = s.charAt(i) == s.charAt(j) && huiwen[i+1][j-1];
                }
            }
        }
        backtrack(res, cur, huiwen, s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> cur, boolean[][] huiwen, String s, int i) {
        if (i == s.length()) res.add(new ArrayList(cur));
        for (int j = i; j < s.length(); j++) {
            if (huiwen[i][j]) {
                cur.add(s.substring(i, j + 1));
                //注意这里是j+1，不是i+1，要从回文串的下一个字符开始
                backtrack(res, cur, huiwen, s, j + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

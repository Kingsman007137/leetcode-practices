//5. 最长回文子串
//https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked

public class P5 {
    // 中心扩散 由长度为1或长度为2的回文子串同时向左右两边不断延伸，直到不是回文串
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            // 为什么不是当前的回文串长度len大于end-start+1现在的最长回文子串长度因为刚开始1=0+0+1
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 返回回文串的长度
    public int expandFromCenter(String s, int left, int right) {
        int n = s.length();
        // 当传入i,i charAt(left)=charAt(right) 当i,i+1 charAt(left)!=charAt(right)跳出循环
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        // 当跳出循环时char[left]!=char[right]不是回文串多2
        return right - left - 1;
    }

    // 对我的动态规划方法的极致简化，但性能也一般般
    // public String longestPalindrome(String s) {
    //     int len = s.length();
    //     int left = 0, right = 0, max = 0;// 记录左右边界和右-左的长度
    //     boolean[][] dp = new boolean[len][len];
    //     for (int i = len - 1; i >= 0; i--) {
    //         for (int j = i; j < len; j++) {// j = i这步就将每个单个字符dp赋为了true
    //             if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {// 如果j - i <= 1，必是回文串
    //                 dp[i][j] = true;
    //                 if (j - i > max) {
    //                     max = j - i;// res记得也得更新！
    //                     left = i;
    //                     right = j;
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(left, right + 1);// 左闭右开
    // }

    // -------------------------------------------------------------------------------------
    // 思路倒是对了，性能非常烂
    // public String longestPalindrome(String s) {
    //     int n = s.length();
    //     char[] c = s.toCharArray();
    //     int begin = 0, end = 0, max = 1;
    //     //dp[i][j] 表示从 i 到 j 为回文
    //     boolean[][] dp = new boolean[n][n];
    //     //没想到的初始化方式，长度为一的全部为true
    //     for (int i = 0; i < n; i++) {
    //         dp[i][i] = true;
    //     }
    //     for (int i = n - 1; i >= 0; i--) {
    //         for (int j = 1; j < n; j++) {
    //             if (i + 1 < n) {
    //                 dp[i][j] = (dp[i + 1][j - 1] && c[i] == c[j]) || isPalindrome(c, i, j);
    //             } else {
    //                 dp[i][j] = isPalindrome(c, i, j);
    //             }
    //             //是回文的话则判断长度
    //             if (dp[i][j] && j - i + 1 > max) {
    //                 max = j - i + 1;
    //                 begin = i;
    //                 end = j;
    //             }
    //         }
    //     }
    //     return s.substring(begin, end + 1);
    // }

    // private boolean isPalindrome(char[] c, int begin, int end) {
    //     int i = begin, j = end;
    //     while (i <= j) {
    //         if (c[i] != c[j]) {
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}

//392.判断子序列
//https://leetcode.cn/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150

public class P392 {
    // 遍历s，更新index，前面已经符合的就不管了，在t后面的子串中判断是否有下一个s中的字符
    // 我觉得我的解法很不错了，不过用到了很多jdk自带方法
    public static boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            String thisCharStr = s.charAt(i) + "";
            if (!t.substring(index).contains(thisCharStr)) {//每次判断从更新的index开始的子串，保证了顺序。
                return false;
            }
            // index的更新算法很关键，因为子串的索引又是从0开始，所以要加上index，从已经判断过的下一个开始，所以又加一
            index = t.substring(index).indexOf(thisCharStr) + index + 1;
        }
        return true;
    }

    // 官方双指针题解，时间复杂度O(m + n)，空间复杂度O(1)
    // public boolean isSubsequence(String s, String t) {
    //     int n = s.length(), m = t.length();
    //     int i = 0, j = 0;
    //     while (i < n && j < m) {
    //         if (s.charAt(i) == t.charAt(j)) {
    //             i++;
    //         }
    //         j++;
    //     }
    //     return i == n;
    // }

    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }
}

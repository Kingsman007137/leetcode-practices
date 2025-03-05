//3. 无重复字符的最长子串
//https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked

// import java.util.HashMap;
// import java.util.Map;

public class P3 {
    // 动态规划，性能更强。
    public int lengthOfLongestSubstring(String s) {
        int m = s.length();
        int num = 1; // 初始值表示以s的第一个字符为结束的不重复的最长子串的长度
        int max = 1;
        for (int i = 1; i < m; i++) {
            //好好看看这个indexOf方法，第二个参数是指从哪个位置开始找
            int index = s.indexOf(s.charAt(i), i - num);
            if (index < i) { // 如果找到的位置在i之前，说明s.charAt(i)在前面已经出现过
                // num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                num = i - index;
            } else { // 如果找到的位置在i之后或者没有找到，说明s.charAt(i)是新出现的字符，增大窗口
                num = num + 1;
            }
            max = Math.max(max, num);
        }
        return m == 0 ? 0 : max;
    }

    // 性能还不错的方法，但其实也参考了别人的题解
    // public int lengthOfLongestSubstring(String s) {
    //     //储存字符最后出现的位置
    //     Map<Character, Integer> map = new HashMap();
    //     int ans = 0;
    //     int start = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (map.containsKey(c)) {
    //             ans = Math.max(ans, i - start);
    //             /* 比如 "abcdefdhjk" 这种，当右指针移动到第二个d的时候，
    //             左指针可以直接到第一个d的下一个位置，即 e 开始.
    //             但如果重复字符出现在左指针之前，左指针就不能回去了，
    //             因为中间会有其他重复，所以还是保持为start */
    //             start = Math.max(start, map.get(c) + 1);
    //         }
    //         //即使map里面有c，put方法也会覆盖掉前面的
    //         map.put(c, i);
    //     }
    //     return Math.max(ans, s.length() - start); // 防止最后一轮是最长或者从头到尾没有重复
    // }
}

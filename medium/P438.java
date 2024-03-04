//438. 找到字符串中所有字母异位词
//https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.List;

public class P438 {
    // 滑动窗口但是不太懂，copilot标上注释
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[128]; // 创建一个数组，用于记录字符串p中每个字符的数量
        for (char c : p.toCharArray()) { // 遍历字符串p中的每个字符
            cnt[c]++; // 对应字符的数量加1
        }
        int low = 0, high = 0; // 定义滑动窗口的两个边界
        List<Integer> res = new ArrayList<>(); // 创建一个列表，用于保存结果
        while (high < s.length()) { // 当滑动窗口的右边界没有超过字符串s的长度时，继续循环
            if (cnt[s.charAt(high)] > 0) { // 如果字符串s中的当前字符在字符串p中存在
                cnt[s.charAt(high)]--; // 对应字符的数量减1
                high++; // 右边界向右移动
                if (high - low == p.length()) // 如果滑动窗口的大小等于字符串p的长度
                    res.add(low); // 将滑动窗口的左边界添加到结果中
            } else { // 如果字符串s中的当前字符在字符串p中不存在
                cnt[s.charAt(low)]++; // 对应字符的数量加1
                low++; // 左边界向右移动
            }
        }
        return res; // 返回结果
    }

    // 我的方法还是一组组字符串排序然后和p比较，性能低
    // public List<Integer> findAnagrams(String s, String p) {
    //     List<Integer> ans = new ArrayList();
    //     int n = p.length();
    //     char[] pArr = p.toCharArray();
    //     Arrays.sort(pArr);
    //     for (int i = 0; i < s.length() - n + 1; i++) {
    //         String str = s.substring(i, i + n);
    //         char[] strArr = str.toCharArray();
    //         Arrays.sort(strArr);
    //         if (Arrays.equals(pArr, strArr)) {
    //             ans.add(i);
    //         }
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        //System.out.println(new P438().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new P438().findAnagrams("eeebabacd", "abc"));
    }
}

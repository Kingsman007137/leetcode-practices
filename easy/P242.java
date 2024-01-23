//242.有效的字母异位词
//https://leetcode.cn/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class P242 {
    //另一种思维，只要把两个字符串排序看看是否相同就行，用封装好的方法比我的方法还快。。。
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    
    // 这种哈希玩法已经很熟练了，就是不知为啥速度慢了点
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     int[] lettersOfs = new int[26];
    //     int[] lettersOft = new int[26];
    //     for (int i = 0; i < s.length(); i++) {
    //         lettersOfs[s.charAt(i) - 'a'] ++;
    //         lettersOft[t.charAt(i) - 'a'] ++;
    //     }

    //     for (int i = 0; i < 26; i++) {
    //         if (lettersOfs[i] != lettersOft[i]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}

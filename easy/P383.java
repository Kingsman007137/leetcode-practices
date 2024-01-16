//P383.赎金信
//https://leetcode.cn/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150、

public class P383 {
    // 这个解法就把后两个循环合为一个了，而且也只用开一个数组，一加一减即可。
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] ret = new int[26];
        // 将字符串中的字符转换为字符数组
        for(char c : magazine.toCharArray()){
            // 26个字母 出现多少次
            ret[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()){
            if(--ret[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    // 我的解法的类似哈希表，思路很对了，但是还不够优化
    // public boolean canConstruct(String ransomNote, String magazine) {
    //     int[] ransom = new int[26];
    //     int[] maga = new int[26];
    //     for (int i = 0; i < ransomNote.length(); i++) {
    //         int index = ransomNote.charAt(i) - 'a';
    //         ransom[index]++;
    //     }
    //     for (int i = 0; i < magazine.length(); i++) {
    //         int index = magazine.charAt(i) - 'a';
    //         maga[index]++;
    //     }

    //     for (int i = 0; i < 26; i++) {
    //         if (ransom[i] > maga[i]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
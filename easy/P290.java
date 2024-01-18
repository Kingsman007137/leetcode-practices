//209.单词规律
//https://leetcode.cn/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;
import java.util.Map;

public class P290 {
    // 高赞答案，看着就是对集合的属性非常熟悉，比我的简洁多了，虽然运行时间似乎都是1ms
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        // 这个键值用Object很妙，这样就可以只创建一个Map了
        Map<Object, Integer> map = new HashMap<>();
        //用Integer操作字符串比用int更安全
        for (Integer i = 0; i < words.length; i++) {
            /*
                如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

                以pattern = "abba", str = "dog cat cat dog"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
                结果为 true。

                以pattern = "abba", str = "dog cat cat fish"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
                结果为 false。
            */
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }

    // 这道题其实和 P205 同构字符串 很像，用差不多的思路两头映射即可。（集合封装的方法还是比自己写的性能好啊）
    // public boolean wordPattern(String pattern, String s) {
    //     Map<Character, String> pattern2s = new HashMap<>();
    //     Map<String, Character> s2pattern = new HashMap<>();
    //     String[] str = s.split(" ");
    //     if (str.length != pattern.length()) {
    //         return false;
    //     }
    //     for (int i = 0; i < pattern.length(); i++) {
    //         char c = pattern.charAt(i);
    //         //不能两个相同字符映射到不同字符串上
    //         //忘了 != null 可以用 containsKey 这个方法
    //         if (pattern2s.containsKey(c) && !pattern2s.get(c).equals(str[i])) {
    //             return false;
    //         }
    //         pattern2s.put(c, str[i]);

    //         //不能两个不同字符映射到相同字符串上
    //         if (s2pattern.containsKey(str[i]) && !s2pattern.get(str[i]).equals(c)) {
    //             return false;
    //         }
    //         s2pattern.put(str[i], c);
    //     }

    //     return true;
    // }
}

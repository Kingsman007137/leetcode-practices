//205. 同构字符串
//https://leetcode.cn/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;
import java.util.Map;

public class P205 {
    // 下面这个做法和我的想法类似，但用了Map及其封装的方法，性能好点（也没有特别好）
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
            {
                if(map.get(s.charAt(i))!=t.charAt(i))
                {
                    return false;
                }
                continue;
            }
            if(map.containsValue(t.charAt(i))) return false;
            map.put(s.charAt(i),t.charAt(i));
        }

        return true;
    }

    // 这个做法更是逆天，但我实在是想不出来，也不明白为啥这样就对了。而且性能也不算特别好
    // public boolean isIsomorphic(String s, String t) {
    //     for (int i = 0; i < s.length(); i++) {
    //         //用indexOf取当前位置字符第一次出现的索引对比
    //         //情况1(一个字符映射多个): foo 与 bar, 处理第二个o时发现索引不同
    //         //情况2(多个字符映射同个): abc 与 ggl, 处理第二个g时发现索引不同
    //         if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // 嵌套循环，性能太低
    // public boolean isIsomorphic(String s, String t) {
    //     int[] ascii = new int[127];
    //     for (int i = 0; i < s.length(); i++) {
    //         //同一字符映射到不同字符的情况
    //         if (ascii[s.charAt(i)] != 0 && t.charAt(i) != ascii[s.charAt(i)]) {
    //             return false;
    //         }
    //         //不同字符映射到同一字符的情况
    //         for (int j = 0; s.charAt(j) != s.charAt(i) && j < s.length(); j++) {
    //             if (t.charAt(i) == ascii[s.charAt(j)]) {
    //                 return false;
    //             }
    //         }
    //         ascii[s.charAt(i)] = t.charAt(i); //数组中s各个字符对应的ascii码索引存储着t对应位置字符的ascii码
    //     }
    //     return true;
    // }
}

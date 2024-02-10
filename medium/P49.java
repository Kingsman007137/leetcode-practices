//49. 字母异位词分组
//https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

public class P49 {
    // 官方题解，和我的思路与性能一样，但简化了很多判断和循环，用了很多我么见过的方法
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] c1 = strs[i].toCharArray();
            Arrays.sort(c1);
            String str = new String(c1);
            List<String> list = map.getOrDefault(str, new ArrayList<String>());
            list.add(s);
            map.put(str, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    // 这个解法比我的快，但不保证有些不同字母hashcode之和相同，虽然通过的此题的全部测试
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     HashMap<Long,List<String>> map = new HashMap<>();
    //     //通过ascii值为索引给数组对应位置添加值
    //     long[] arr = new long[128];
    //     for(char c='a';c<='z';c++){
    //         Object o = new Object();
    //         arr[c] = o.hashCode();
    //     }
    //     //遍历字符串，将其各位字符在数组中对应值求和,判断其是否已出现过
    //     for(String s : strs){
    //         long sum = 0;
    //         for(int i=0;i<s.length();i++){
    //             char c = s.charAt(i);
    //             sum += arr[c];
    //         }
    //         if( map.containsKey(sum)){
    //             map.get(sum).add(s);
    //         }else{
    //             ArrayList<String> list = new ArrayList<>();
    //             list.add(s);
    //             map.put(sum,list);
    //         }
    //     }
    //     return new ArrayList<>(map.values());
    // }

    // 排序字符串来找同分异构体
    // public static List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String, List<String>> map = new HashMap<>();
    //     List<List<String>> res = new ArrayList<>();
    //     for (int i = 0; i < strs.length; i++) {
    //         String s = strs[i];
    //         char[] c1 = strs[i].toCharArray();
    //         Arrays.sort(c1);
    //         String str = new String(c1);
    //         if (!map.containsKey(str)) {
    //             List<String> list = new ArrayList<>();
    //             list.add(s);
    //             map.put(str, list);
    //         } else {
    //             List<String> list = map.get(str);
    //             list.add(s);
    //         }
    //     }

    //     for (String str: map.keySet()) {
    //         res.add(map.get(str));
    //     }
    //     return res;
    // }
}

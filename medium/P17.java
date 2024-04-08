//17. 电话号码的字母组合
//https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-100-liked

import java.util.*;

public class P17 {
    // 还是这个回溯法厉害，知道用回溯法，但是不知道怎么写，关键在递归前添加和递归后撤销的操作
    // 数字到号码的映射
    private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    // 路径
    private StringBuilder sb = new StringBuilder();
    // 结果集
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        backtrack(digits,0);
        return res;
    }

    // 回溯函数
    private void backtrack(String digits,int index) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String val = map[digits.charAt(index)-'2'];
        for(char ch:val.toCharArray()) {
            sb.append(ch);
            backtrack(digits,index+1);
            //撤销操作
            sb.deleteCharAt(sb.length()-1);
        }
    }

    // 暴力解法，非常幽默，性能感人
    // public List<String> letterCombinations(String digits) {
    //     int n = digits.length();
    //     if (n == 0) {
    //         return new ArrayList();
    //     }
    //     // 没想好怎么优化，先用蠢方法
    //     Map<Integer, String> map = new HashMap();
    //     map.put(2,"abc");
    //     map.put(3,"def");
    //     map.put(4,"ghi");
    //     map.put(5,"jkl");
    //     map.put(6,"mno");
    //     map.put(7,"pqrs");
    //     map.put(8,"tuv");
    //     map.put(9,"wxyz");
    //     List<String> res = new ArrayList();
    //     Set<String> temp = new HashSet();
    //     temp.add("");
    //     for (int i = 0; i < n; i++) {
    //         int num = Integer.valueOf(digits.charAt(i) + "");
    //         String str = map.get(num);
    //         for (char c: str.toCharArray()) {
    //             //不能在遍历temp集合过程中修改它，所以重新定义一个集合，最后再加上
    //             Set<String> temp2 = new HashSet();
    //             for (String s: temp) {
    //                 // i刚好是前一轮字符串长度
    //                 if (s.length() == i) {
    //                     String newStr = s + c + "";
    //                     temp2.add(newStr);
    //                     //到最后了也就是产生答案了
    //                     if (i == n - 1) {
    //                         res.add(newStr);
    //                     }
    //                 }
    //             }
    //             temp.addAll(temp2);
    //         }
    //     }
    //     return res;
    // }

    public static void main(String[] args) {
        P17 p17 = new P17();
        System.out.println(p17.letterCombinations("23"));
    }
}

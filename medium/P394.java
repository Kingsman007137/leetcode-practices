//394. 字符串解码
//https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&envId=top-100-liked

import java.util.LinkedList;

public class P394 {
    // 真正体现了栈的思想，从内而外解码，代码很简洁
    // https://leetcode.cn/problems/decode-string/solutions/19447/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>(); // 用来存储[之前的倍数
        LinkedList<String> stack_res = new LinkedList<>(); // 用来存储[之前的字符串
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                // 把[之前的字符串取出来，加上当前的倍数字符串，再append
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            // 如果是数字，要考虑多位数的情况，算倍数
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            // 如果是字母，直接append
            else res.append(c);
        }
        return res.toString();
    }

    // 要从内而外解码，所以要用栈，因为符合后进先出的特性
    // 这个解法思路清晰，可惜性能不足
    // public String decodeString(String s) {
    //     Deque<Character> stack = new LinkedList();
    //     for (char c : s.toCharArray()) {
    //         if (c != ']') {
    //             stack.push(c); // 把所有的字母push进去，除了]
    //         } else {
    //             // step 1: 取出[] 内的字符串
    //             StringBuilder sb = new StringBuilder();
    //             while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
    //                 sb.insert(0, stack.pop());
    //             }
    //             String sub = sb.toString(); // [ ]内的字符串
    //             stack.pop(); // 去除[

    //             // step 2: 获取倍数数字
    //             sb = new StringBuilder();
    //             while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
    //                 sb.insert(0, stack.pop());
    //             }
    //             int count = Integer.valueOf(sb.toString()); // 倍数

    //             // step 3: 根据倍数把字母再push回去 (最难想的一步)
    //             while (count > 0) {
    //                 for (char ch : sub.toCharArray())
    //                     stack.push(ch);
    //                 count--;
    //             }
    //         }
    //     }

    //     // 把栈里面所有的字母取出来，完事L('ω')┘三└('ω')｣
    //     StringBuilder retv = new StringBuilder();
    //     while (!stack.isEmpty()) {
    //         retv.insert(0, stack.pop());
    //     }
    //     return retv.toString();
    // }
}

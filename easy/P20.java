//20. 有效的括号
//https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150

public class P20 {
    // 逆天解法，只装右括号，0ms，但很难想到
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[++top] = ')';
            } else if (c == '{') {
                stack[++top] = '}';
            } else if (c == '[') {
                stack[++top] = ']';
            } else if (top == -1 || stack[top--] != c) {
                return false;
            }
        }
        return top == -1;
    }

    // 我的解法，很标准，就是if else用的有点多
    // public boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (c == ')' && !stack.isEmpty()) {
    //             if (stack.lastElement() == '(') {
    //                 stack.pop();
    //             } else {
    //                 return false;
    //             }
    //         } else if (c == '}' && !stack.isEmpty()) {
    //             if (stack.lastElement() == '{') {
    //                 stack.pop();
    //             } else {
    //                 return false;
    //             }
    //         } else if (c == ']' && !stack.isEmpty()) {
    //             if (stack.lastElement() == '[') {
    //                 stack.pop();
    //             } else {
    //                 return false;
    //             }
    //         } else {
    //             stack.push(c);
    //         }
    //     }
    //     return stack.isEmpty();
    // }
}

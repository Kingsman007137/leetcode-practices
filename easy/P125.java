//125.验证回文串
//https://leetcode.cn/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150

public class P125 {
    //直接头尾双指针遍历比较，不符合条件字符就跳过
    //这个题解我觉得已经很好了，没有新开空间，官方题解前两个都要新开空间
    public boolean isPalindrome(String s) {
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            //原来Character还有这种好方法
            if (!Character.isLetterOrDigit(s.charAt(head))) {
                head++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                return false;
            }
            head++;
            tail--;
        }

        return true;
    }
}

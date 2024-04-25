//22. 括号生成
//https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.*;

public class P22 {
    // 回溯的逻辑还是想不明白，比如何时该进入回溯，怎么判断，像这里就是以 n > left > right 为限制条件
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        generate(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    // left 和 right 分别代表目前的左括号数和右括号数
    private void generate(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            generate(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 左括号要大于右括号，不能等于，因为等于的话进入if语句里加一个")"左括号就小于右括号了
        if (left > right) {
            sb.append(")");
            generate(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

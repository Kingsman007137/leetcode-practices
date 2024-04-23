//46. 全排列
//https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P46 {
    // 回溯法，还是不太懂，可以看看题解：
    // https://leetcode.cn/problems/permutations/solutions/9914/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList();
        for (int num: nums) {
            list.add(num);
        }
        recursion(n, list, 0);
        return res;
    }

    public void recursion(int n, List<Integer> list, int first) {
        // 0到n-1的数已经排列好了，加入结果集
        if (first == n) {
            // 这里要new一个list，不然res里面的list都是同一个引用，list改变了，res里面的list也会改变
            res.add(new ArrayList(list));
            return;
        }
        // first后面每个数都要和first交换，这样又是一个新的排列
        for (int i = first; i < list.size(); i++) {
            Collections.swap(list, i, first);
            recursion(n, list, first + 1);
            Collections.swap(list, i, first); //撤销,变回原样
        }
    }
}

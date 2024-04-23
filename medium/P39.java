//39. 组合总和
//https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39 {
    // 递归回溯法，这里的回溯思路想是想明白了，但写不出来，可以看看题解
    // https://leetcode.cn/problems/combination-sum/solutions/14697/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> oneResult = new ArrayList();
        Arrays.sort(candidates);
        //别忘了还要设置搜索起点
        dfs(candidates, 0, target, oneResult, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int target, List<Integer> oneResult, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList(oneResult));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            oneResult.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, target - candidates[i], oneResult, res);
            oneResult.remove(oneResult.size() - 1);
        }
    }
}

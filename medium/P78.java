//78. 子集
//https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.List;

public class P78 {
    // 还有精彩的二进制标记解法，和看不懂的回溯法，可以看题解：
    // https://leetcode.cn/problems/subsets/solutions/420294/zi-ji-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
    // https://leetcode.cn/problems/subsets/solutions/2059409/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-8tkl

    // 类动态规划，每次遍历到一个新的元素，对res中现有的每个子集加上新的元素
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList()); // 肯定要加null
        for (int i = 0; i < n; i++) {
            int size = res.size();
            // 对res中现有的每个子集加上新的nums[i], 这样又多了size个子集
            for (int j = 0; j < size; j++) {
                //一定是复制一份List再改动，不然就会变成引用了，就改动原来已经在res里的集合了
                List<Integer> copy = new ArrayList(res.get(j));
                copy.add(nums[i]);
                res.add(copy);
            }
        }
        return res;
    }
}

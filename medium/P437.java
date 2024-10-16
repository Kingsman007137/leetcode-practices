//437. 路径总和 III
//https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.HashMap;
import java.util.Map;

public class P437 {
    // 可以用前缀和的方法，性能更高，具体思路可以参考P560.java
    // 也可以直接参照作者想法：https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&envId=top-100-liked
    private int ans;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>(); // 用于记录前缀和出现的次数
        cnt.put(0L, 1); // 前缀和为0的路径有1条，必须要加这个，防止漏掉根节点等于目标值的情况
        dfs(root, 0, targetSum, cnt);
        return ans;
    }

    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }
        s += node.val; // 更新当前路径的前缀和
        // 如果存在前缀和等于当前前缀和减去目标值的路径，则更新答案
        // 这里merge的用法：如果key存在，则它的value加1，否则设置为1
        ans += cnt.getOrDefault(s - targetSum, 0);
        cnt.merge(s, 1, Integer::sum); // 更新当前前缀和的出现次数
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        // 处理完这个节点后，要回溯，把当前节点的前缀和出现次数减1，因为要返回上一层了，
        // 要遍历其他路径，这个前缀和不应该再出现
        cnt.merge(s, -1, Integer::sum); 
    }

    // --------------------------------------------------------------
    // 二次递归，性能差
    // int count = 0;
    // public int pathSum(TreeNode root, long targetSum) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     long sum = 0;
    //     dfs(root, targetSum, sum);
    //     // 每个结点都以自己为起点来一次深搜
    //     pathSum(root.left, targetSum);
    //     pathSum(root.right, targetSum);
    //     return count;
    // }

    // private void dfs(TreeNode root, long targetSum, long sum) {
    //     if (root == null) {
    //         return;
    //     }
    //     sum += root.val;
    //     if (sum == targetSum) {
    //         count++;
    //     }
    //     dfs(root.left, targetSum, sum);
    //     dfs(root.right, targetSum, sum);
    // }
}
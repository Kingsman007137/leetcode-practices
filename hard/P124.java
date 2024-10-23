//124. 二叉树中的最大路径和
//https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked

public class P124 {
    /**
     * ！！！神人解法：
     * 只可能有如下6种情况：
     * 1.根 + 左 + 右
     * 2.根 + 左
     * 3.根 + 右
     * 4.根
     * 5.左
     * 6.右
     * 好了，分析上述6种情况， 只有 2,3,4 可以向上累加，而1,5,6不可以累加（这个很好想，情况1向上累加的话，
     * 必然出现分叉，情况5和6直接就跟上面的树枝断开的，没法累加），所以我们找一个全局变量存储1,5,6这三种
     * 不可累加的最大值， 另一方面咱们用遍历树的方法求2,3,4这三种可以累加的情况。 最后把两类情况得到的最大
     * 值再取一个最大值即可。
     */
    // 存储不可累加的三种情况最大值，初始化为提供的最小结点值
    int res1 = -1000;

    public int maxPathSum(TreeNode root) {
        // 存储递归可累加的三种情况最大值
        int res2 = dfs(root);
        return Math.max(res1, res2);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            // 返回最小值则不会参与max()方法的更新
            return -1000;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res1 = Math.max(res1, root.val + left + right); // case 1
        res1 = Math.max(res1, left); // case 5
        res1 = Math.max(res1, right);// case 6
        int ret = Math.max(root.val + right, root.val + left);// case 2, 3
        ret = Math.max(ret, root.val); // case 4
        return ret;
    }

    // 这个和P543的思想比较类似，也可以再那道题的基础上改一下，不过我觉得这个解法最好了
}
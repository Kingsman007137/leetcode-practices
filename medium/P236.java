//236. 二叉树的最近公共祖先
//https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked

public class P236 {
    // 深搜，想象不出，可以看看视频：https://www.bilibili.com/video/BV1UD4y1Y769/?vd_source=7dad1fb91342de946e45a4b84f0c2d0a
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果找到了p或q，就返回当前节点，因为假设另一个目标节点（比如说q）在p的子树中，
        // 那么答案就是p，加入不在，那也没必要再往下深搜了。
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 这里也包括了如果left和right都为null就返回null。
        // 上面那个判断是因为这种情况下这次的root的左右子树都没有p / q
        if (left == null) {
            return right;
        } else if (right == null) {
            // 如果left不为空，right为空，说明p和q都在左子树上，所以此时的最近公共祖先就是left
            // 所以left的祖先就一直返回left直到递归结束
            return left;
        }
        // 左右子树不为空，说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }
}
//104. 二叉树的最大深度
//https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked

public class P104 {
    // 还是递归好，但实际开发中，递归效率不高
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft + 1, maxRight + 1);
    }

    // BFS，一层层遍历，效率不高
    // public int maxDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
    //     int res = 0;
    //     while (!queue.isEmpty()) {
    //         tmp = new LinkedList<>();
    //         for(TreeNode node : queue) {
    //             if (node.left != null) tmp.add(node.left);
    //             if (node.right != null) tmp.add(node.right);
    //         }
    //         queue = tmp;
    //         res++;
    //     }
    //     return res;
    // }
}

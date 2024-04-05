//98. 验证二叉搜索树
//https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class P98 {
    // 没想到还有这么简洁的中序遍历解法，不需要额外集合存储，只需要一个变量记录前一个节点的值
    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 左子树不是二叉搜索树，就一直返回false
        if (!isValidBST(root.left)) return false;
        if (prev != Long.MIN_VALUE && prev >= root.val) return false;
        prev = root.val;
        return isValidBST(root.right);
    }

    // 这道题本质就是中序遍历是不是递增，以下是我的解法：
    // List<TreeNode> trees = new ArrayList();

    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     inorder(root);
    //     for (int i = 1; i < trees.size(); i++) {
    //         if (trees.get(i).val <= trees.get(i-1).val) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public void inorder(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     inorder(root.left);
    //     trees.add(root);
    //     inorder(root.right);
    // }
}

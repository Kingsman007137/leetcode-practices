//230. 二叉搜索树中第K小的元素
//https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked

public class P230 {
    // 这个解法使用了dfs，思路和我一样但性能好，不过感觉这样写不太美观啊。。。
    int res, k;
    void dfs(TreeNode root) {
        if (root == null || k == 0) return;
        dfs(root.left);
        if (--k == 0) res = root.val;
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    // 用了个奇技淫巧，二叉搜索树中序遍历结果就是从小到大的排序，再取第k-1个元素即可，但性能不佳
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> res = new ArrayList();
    //     inorder(root, res, k);
    //     return res.get(k-1);
    // }

    // private void inorder(TreeNode root, List<Integer> res, int k) {
    //     // 有k个元素了就不用再遍历了（中序遍历是从小到大的）
    //     if (root == null || res.size() == k) {
    //         return;
    //     }
    //     inorder(root.left, res, k);
    //     res.add(root.val);
    //     inorder(root.right, res, k);
    // }
}

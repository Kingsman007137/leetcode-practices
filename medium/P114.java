//114. 二叉树展开为链表
//https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked

public class P114 {
    // 反向前序遍历，从前序遍历的最后一个节点开始往反方向推
    // 解决了从正向推会破坏后面要遍历的二叉树结构的问题，不过空间复杂度是O(n)
    TreeNode preNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 这样可以逆前序遍历
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = preNode;
        preNode = root;
    }

    // 找前驱节点，空间复杂度O(1)，见方法三
    // https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/356853/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu
    // public void flatten(TreeNode root) {
    //     TreeNode curr = root;
    //     while (curr != null) {
    //         if (curr.left != null) {
    //             TreeNode next = curr.left;
    //             TreeNode predecessor = next;
    //             while (predecessor.right != null) {
    //                 predecessor = predecessor.right;
    //             }
    //             predecessor.right = curr.right;
    //             curr.left = null;
    //             curr.right = next;
    //         }
    //         curr = curr.right;
    //     }
    // }
    

    // 最蠢的方法就是用链表存储二叉树的前序遍历，再依次接上
}

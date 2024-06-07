//105. 从前序与中序遍历序列构造二叉树
//https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.Deque;
import java.util.LinkedList;

public class P105 {
    // 感觉非常困难，想不出解法，主要是对树的遍历方式特点理解不深
    // 用了方法二迭代法：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        // 根节点
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int pre = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) { // 证明是其左子树根节点
                node.left = new TreeNode(pre);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                // 不相等的前一个结点前序遍历pre的父节点，而且pre是他的右子树根节点
                node.right = new TreeNode(pre);
                stack.push(node.right);
            }
        }
        return root;
    }
}

//94. 二叉树的中序遍历
//https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.List;

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


public class P94 {
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode pre = null;
		while(root!=null) {
			//如果左节点不为空，就将当前节点连带右子树全部挂到, 左节点的最右子树下面
			if(root.left!=null) {
				pre = root.left;
				while(pre.right!=null) {
					pre = pre.right;
				}
				pre.right = root;
				//将root指向root的left
				TreeNode tmp = root;
				root = root.left;
				tmp.left = null;
			//左子树为空，则打印这个节点，并向右边遍历	
			} else {
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}

    // 递归, 比较简单，注意三句的顺序和递归出口，递归效率不高
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList();
    //     inorder(root, list);
    //     return list;
    // }

    // public void inorder(TreeNode root, List<Integer> list) {
    //     if (root == null) {
    //         return;
    //     }
    //     inorder(root.left, list);
    //     list.add(root.val);
    //     inorder(root.right, list);
    // }
}

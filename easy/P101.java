//101. 对称二叉树
//https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked

public class P101 {
    // 递归解法，实际上就是dfs
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return infer(root.left, root.right);
    }

    public boolean infer(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) { // 这里不能两个结点值相等就返回true，因为还要判断它们的子树
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
		//以及比较  左节点的右孩子 和 右节点的左孩子
        return infer(left.left, right.right) && infer(left.right, right.left);
    }

    // 迭代解法，用队列，一个道理
    // public boolean isSymmetric(TreeNode root) {
	// 	if(root==null || (root.left==null && root.right==null)) {
	// 		return true;
	// 	}
	// 	//用队列保存节点
	// 	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	// 	//将根节点的左右孩子放到队列中
	// 	queue.add(root.left);
	// 	queue.add(root.right);
	// 	while(queue.size()>0) {
	// 		//从队列中取出两个节点，再比较这两个节点
	// 		TreeNode left = queue.removeFirst();
	// 		TreeNode right = queue.removeFirst();
	// 		//如果两个节点都为空就继续循环，两者有一个为空就返回false
	// 		if(left==null && right==null) {
	// 			continue;
	// 		}
	// 		if(left==null || right==null) {
	// 			return false;
	// 		}
	// 		if(left.val!=right.val) {
	// 			return false;
	// 		}
	// 		//将左节点的左孩子， 右节点的右孩子放入队列
	// 		queue.add(left.left);
	// 		queue.add(right.right);
	// 		//将左节点的右孩子，右节点的左孩子放入队列
	// 		queue.add(left.right);
	// 		queue.add(right.left);
	// 	}
		
	// 	return true;
	// }
}

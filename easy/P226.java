//226. 翻转二叉树
//https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked

public class P226 {
    // 递归法，等于前序遍历一遍，交换左右子树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 迭代法，层序遍历一遍，交换左右子树
    // public TreeNode invertTree(TreeNode root) {
	// 	if(root==null) {
	// 		return null;
	// 	}
	// 	//将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
	// 	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	// 	queue.add(root);
	// 	while(!queue.isEmpty()) {
	// 		//每次都从队列中拿一个节点，并交换这个节点的左右子树
	// 		TreeNode tmp = queue.poll();
	// 		TreeNode left = tmp.left;
	// 		tmp.left = tmp.right;
	// 		tmp.right = left;
	// 		//如果当前节点的左子树不为空，则放入队列等待后续处理
	// 		if(tmp.left!=null) {
	// 			queue.add(tmp.left);
	// 		}
	// 		//如果当前节点的右子树不为空，则放入队列等待后续处理
	// 		if(tmp.right!=null) {
	// 			queue.add(tmp.right);
	// 		}
			
	// 	}
	// 	//返回处理完的根节点
	// 	return root;
	// }
}

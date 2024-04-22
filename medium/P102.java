//102. 二叉树的层序遍历
//https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.*;

public class P102 {
    // 广度优先搜索用队列，我比较困惑的点在于两个循环的使用，第一个循环是遍历当前层的结点，第二个循环是遍历每一层的结点
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList();
            // queue.size()作为起始条件递减遍历可以防止循环语句中改变了queue的大小造成循环次数改变
            for (int i = queue.size(); i > 0; i--) {
                // poll方法相当于队首出队
                TreeNode theNode = queue.poll();
                tmp.add(theNode.val);
                // 每个结点出队列都要把左右结点入队以便下一层的打印（下一次while循环）
                if (theNode.left != null) queue.add(theNode.left);
                if (theNode.right != null) queue.add(theNode.right);
            }
            res.add(tmp);
        }
        return res;
    }
}

//199. 二叉树的右视图
//https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199 {
    // 相同思路，更加简便的写法，而且还少开链表空间，关键在于最后添加到ans的逻辑
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if (i == count - 1) ans.add(node.val);
            }
        }
        return ans;
    }

    // 自己想的方法，层序遍历，然后取每一层的最后一个元素，就是右视图
    // public List<Integer> rightSideView(TreeNode root) {
    //     if (root == null) {
    //         return new ArrayList();
    //     }
    //     List<List<Integer>> layers = new ArrayList();
    //     List<Integer> res = new ArrayList();
    //     Deque<TreeNode> theLayer = new LinkedList();
    //     // 应该适应用offer和poll方法，不要用add和remove
    //     theLayer.offer(root);
    //     // 层序遍历
    //     while (!theLayer.isEmpty()) {
    //         int size = theLayer.size();
    //         List<Integer> layerNums = new ArrayList();
    //         while (size > 0) {
    //             TreeNode p = theLayer.poll();
    //             layerNums.add(p.val);
    //             if (p.left != null) theLayer.offer(p.left);
    //             if (p.right != null) theLayer.offer(p.right);
    //             size--;
    //         }
    //         layers.add(layerNums);
    //     }
    //     for (int i = 0; i < layers.size(); i++) {
    //         int n = layers.get(i).size() - 1;
    //         res.add(layers.get(i).get(n));
    //     }
    //     return res;
    // }
}

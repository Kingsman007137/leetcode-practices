//543. 二叉树的直径
//https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked

public class P543 {
    // 1. 求直径就是求左右子树的深度之和
    // 2. 递归函数要分清比较的最大值和返回值的关系，递归函数的返回值和max无关
    int maxd=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        depth(root);
        return maxd;
    }
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int Left = depth(node.left); //左儿子为根的子树的深度
        int Right = depth(node.right); //右儿子为根的子树的深度
        maxd=Math.max(Left+Right,maxd);//将每个节点最大直径(左子树深度+右子树深度)与当前最大值比较并取大者
        return Math.max(Left,Right)+1;//返回节点深度
    }
}

//108. 将有序数组转换为二叉搜索树
//https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked

public class P108 {
    // 看解答，其实递归方法不需要传入树节点作为参数，还有 begin == end 的判断也可以省略
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    // ----------------------------------------------------------------------------------------------
    // 自己写出递归了，但其实对递归的逻辑还是没有那么熟练，我的写法要创建新对象又让它变成引用其他对象，感觉有点多余
    // public TreeNode sortedArrayToBST(int[] nums) {
    //     int begin = 0, end = nums.length - 1;
    //     TreeNode root = new TreeNode();
    //     root = dfs(nums, begin, end, root);
    //     return root;
    // }

    // private TreeNode dfs(int[] nums, int begin, int end, TreeNode root) {
    //     if (begin > end) {
    //         return null;
    //     }
    //     int mid = (begin + end) / 2;
    //     if (begin == end) {
    //         return new TreeNode(nums[mid]);
    //     }
    //     // 这里还得创建新对象，感觉有点多余
    //     root.left = new TreeNode();
    //     root.right = new TreeNode();
    //     root.left = dfs(nums, begin, mid - 1, root.left);
    //     root.right = dfs(nums, mid + 1, end, root.right);
    //     // 这里最后发现可以用构造函数创建新对象，但之前创建的就没用了
    //     return new TreeNode(nums[mid], root.left, root.right);
    // }
}

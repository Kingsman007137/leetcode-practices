//287. 寻找重复数
//https://leetcode.cn/problems/find-the-duplicate-number/description/?envType=study-plan-v2&envId=top-100-liked

public class P287 {
    // 类似P142的解法，快慢指针，但是要想的到成环这个特点
    // 看方法三：https://leetcode.cn/problems/find-the-duplicate-number/solutions/261119/xun-zhao-zhong-fu-shu-by-leetcode-solution
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p1 = fast;
        int p2 = 0;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}
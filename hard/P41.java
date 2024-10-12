//41. 缺失的第一个正数
//https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked

public class P41 {
    // 在原数组中操作很简单，就是交换，只是一开始没想到那个while循环的处理
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int tmp;
        for (int i = 0; i < n; i++) {
            // 不过这里要改为while循环，否则可能略过交换后在i位置上的数
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) {
                return i;
            }
        }

        return n + 1;
    }

    // 根据评论想出来的方法，但是不是O(1)的空间复杂度，应该在原数组上操作
    // public int firstMissingPositive(int[] nums) {
    //     int n = nums.length;
    //     int[] copy = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         // 所有大于1小于等于数组长度的数放到对应的位置上（索引提前一位，不需要0）
    //         if (nums[i] > 0 && nums[i] <= n) {
    //             copy[nums[i] - 1] = nums[i];
    //         }
    //     }

    //     // 第一个不在对应位置上的数就是缺失的第一个正数
    //     for (int i = 1; i <= n; i++) {
    //         if (copy[i - 1] != i) {
    //             return i;
    //         }
    //     }

    //     // 如果都在对应位置上，那么缺失的就是数组长度+1
    //     return copy[n - 1] + 1;
    // }

    public static void main(String[] args) {
        P41 p41 = new P41();
        int[] nums1 = {3, 4, -1, 1};
        System.out.println(p41.firstMissingPositive(nums1)); // 2
    }
}

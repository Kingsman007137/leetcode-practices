//169.多数元素
//https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150

// 一开始想用Map,Set来搞一堆循环遍历，但感觉太麻烦了，经高人指点，发现排序后的中位数必定是多数元素啊。。。
// 那就用这个来复习一下各种排序算法吧
import java.util.Arrays;

public class P169 {
    // 还有一个 “Boyer-Moore 投票算法”，可以学习一下
    // public int majorityElement(int[] nums) {
    //     int count = 0;
    //     int candidate = 0;

    //     for (int num : nums) {
    //         if (count == 0) {
    //             candidate = num;
    //         }
    //         count += (num == candidate) ? 1 : -1;
    //     }

    //     return candidate;
    // }

    // 直接用Java自带的快速排序
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 插入排序，其他的再复习
    // public int majorityElement(int[] nums) {
    //     for (int i = 1; i < nums.length; i++) {
    //         for (int j = i; j - 1 >= 0 && nums[j] < nums[j - 1]; j--) {
    //             int temp = nums[j];
    //             nums[j - 1] = nums[j];
    //             nums[j] = temp;
    //         }
    //     }
    //     return nums[nums.length / 2];
    // }

    // 冒泡排序, 但好像在这里有点问题
    // public int majorityElement(int[] nums) {
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         for (int j = 0; j < nums.length - i - 1; j++) {
    //             if (nums[j] > nums[j + 1]) {
    //                 int temp = nums[j + 1];
    //                 nums[j + 1] = nums[j];
    //                 nums[j] = temp;
    //             }
    //         }
    //     }
    //     return nums[nums.length / 2];
    // }

    // 选择排序
    // public int majorityElement(int[] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] > nums[j]) {
    //                 int temp = nums[i];
    //                 nums[i] = nums[j];
    //                 nums[j] = temp;
    //             }
    //         }
    //     }
    //     return nums[nums.length / 2];
    // }
}

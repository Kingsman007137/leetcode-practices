//128. 最长连续序列
//https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.HashSet;
import java.util.Set;

public class P128 {
    // 这个就是真正符合O(n)要求的解法，先用set去重，然后找到集合中没有比它小1的元素，不断往上找连续的数
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // 这个解法和我的思路差不多，但比我的快多了。
    // public int longestConsecutive(int[] nums) {
    //     if (nums.length <= 1) {
    //         return nums.length;
    //     }
    //     Arrays.sort(nums);
    //     // 各个长度都是从1开始，避免了像我那样从0开始但到最后一位处理不了的情况
    //     int maxLength = 1;
    //     int currentLength = 1;
    //     int currentNum = nums[0];

    //     for(int i=1;i<nums.length;i++) {
    //         if(currentNum == nums[i]) {
    //             continue;
    //         }

    //         if(nums[i] == currentNum + 1) {
    //             currentLength++;
    //         } else {
    //             maxLength = Math.max(maxLength, currentLength);
    //             currentLength = 1;
    //         }

    //         currentNum = nums[i];
    //     }

    //     return Math.max(maxLength, currentLength);
    // }

    // 性能很低，又是各种加判断。
    // public static int longestConsecutive(int[] nums) {
    //     if (nums.length <= 1) {
    //         return nums.length;
    //     }
    //     Arrays.sort(nums);
    //     System.out.println(Arrays.toString(nums));
    //     int length = 0;
    //     int res = 0;
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] != nums[i-1]) {
    //             if (nums[i] - nums[i-1] == 1) {
    //                 length ++;
    //             }
    //         }

    //         if (nums[i] - nums[i-1] != 1 || i == nums.length - 1){
    //             if (length + 1 > res) {
    //                 res = length + 1;
    //             }
    //             //无论何时都要这步操作，而不是把它放在上面的if里面
    //             length = nums[i] == nums[i-1] ? length : 0;
    //         }
    //     }

    //     //肯定有1个
    //     return res == 0 ? 1 : res;
    // }
}

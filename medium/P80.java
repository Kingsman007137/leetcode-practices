//80. 删除有序数组中的重复项 II
//https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class P80 {
    // 更6的快慢指针，好好思考一下
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    // 我觉得我这种快慢指针的做法已经很不错了，是在P26基础上改进的，但判断还是稍微多了点，而且还有人想出了更逆天的做法
    // public static int removeDuplicates(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }

    //     int slow = 0, fast = 1;
    //     int time = 0;//记录相同了多少次
    //     while (fast < nums.length) {
    //         if (nums[slow] != nums[fast]) {
    //             if (time == 0) {
    //                 nums[++slow] = nums[fast];
    //             } else if (time >= 1) {
    //                 //因为else里对time为1时已经进行了递增操作，这时的slow指向两个相同元素的第二个，所以无论哪种情况只需要slow递增
    //                 nums[++slow] = nums[fast];
    //                 time = 0;
    //             }
    //         } else {
    //             time ++;
    //             //只有一次相同，那就继续递增
    //             if (time == 1) {
    //                 nums[++slow] = nums[fast];
    //             }
    //         }
    //         fast ++;
    //     }

    //     return slow + 1;
    // }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}

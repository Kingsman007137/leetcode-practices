//55.跳跃游戏
//https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150

public class P55 {
    // 还有逆天1ms做法，逆推，能跳过就赋值0给count，不能跳过就给count加一，把后面要跳过的位置加上自己一位
    // public boolean canJump(int[] nums) {
    //     int len = nums.length , count=0;
    //     for (int i = len - 2; i >= 0; i--) {
    //         count = nums[i] <= count ? count+1:0;
    //     }
    //     return count==0;
    // }

    // 双指针法成功了，就是永远让快指针跳到最大的位置，如果能比最后一个下标大那就可以，
    // 如果慢指针比快指针都大了就说明快指针遇到无法跳过的0停滞不前了。
    public static boolean canJump(int[] nums) {
        int slow = 0, fast = 0;
        while (slow <= fast) {
            // 其实就类似贪心算法，一直维护最大的跳跃距离
            if (nums[slow] + slow >= fast) {
                fast = nums[slow] + slow;
            }

            slow++;
            if (fast >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    // 双重循环法失败，还是有很多情况考虑不到
    // public static boolean canJump(int[] nums) {
    //     if (nums.length == 1) {
    //         return true;
    //     }

    //     int last = nums.length - 1;
    //     for (int i = 0; i < last; i++) {
    //         int val = nums[i];
    //         for (int j = i + 1; j <= last && j <= i + val; j++) {
    //             if (j + nums[j] >= last) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,0,8,2,0,0,1}));
    }
}

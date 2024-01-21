//45. 跳跃游戏 II
//https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150

public class P45 {
    // 这道题贪心算法应该还是需要每个元素都比对一下，找到当前可跳范围内最大的距离
    public static int jump(int[] nums) {
        int end = 0; // 这一跳可跳的范围边界
        int maxPosition = 0; //实时维护，当前可跳范围内下一跳能跳到的最大位置
        int times = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            //到达边界后，更新下一跳最大边界，这个不一定是从end下标的元素起跳的。
            //可以是以上一跳的范围内任何一个元素为起跳点，只要从它那起跳可以跳到最远(也就是maxPosition位置)
            if (i == end) {
                end = maxPosition;
                times++;
            }
        }
        return times;
    }

    // 还是没想出来，想用贪心算法，可是总有不符合条件的，判断不周全。根据上述题解，我的方法缺少了一个边界变量。
    // public static int jump(int[] nums) {
    //     if (nums.length == 1) {
    //         return 0;
    //     }

    //     int times = 0;
    //     int slow = 0, fast = 0;
    //     while (slow <= fast) {
    //         // 还是有问题，没能找到可跳跃范围中下一条最远的
    //         if (nums[slow] + slow > fast && nums[slow] + slow >= nums[fast] + fast) {
    //             fast = nums[slow] + slow;
    //             times++;
    //         }

    //         slow ++;
    //         if (fast >= nums.length - 1) {
    //             break;
    //         }
    //     }
    //     return times;
    // }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{5,4,0,1,3,6,8,0,9,4,9,1,8,7,4,8}));
    }
}

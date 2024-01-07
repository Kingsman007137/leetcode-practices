// 26. 删除有序数组中的重复项
// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class P26 {
    // 快慢指针，和P27很像
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast]; //将下一个不一样的元素赋值到前面一堆相同元素的第二个位置
            }
            fast++; //快指针一直走，省去了很多判断
        }

        return slow + 1; //注意这个，可带特殊情况得出
    }

    // if-else嵌套的实在太多没有必要，而且没有考虑到数组长度为0或者null的情况。
    // public static int removeDuplicates(int[] nums) {
    //     int p1 = 0, p2 = 1;
    //     if (nums.length == 1) { //有位高人曾说过尽量不写特殊情况，要在一般情况里包括特殊情况的处理。。。
    //         return 1;
    //     }

    //     while (p2 < nums.length) {
    //         if (nums[p1] != nums[p2]) {
    //             p1 ++;
    //             p2 ++;
    //             if (p2 == nums.length) { //这是刚好数组长度为2且互不相同的情况，硬加判断。。。
    //                 p1++;
    //                 break;
    //             }
    //         } else {
    //             if (p2 == nums.length - 1) { //p2为最大下标，说明后面没有不一样的元素了，加上这个元素的长度就break
    //                 p1 ++;
    //                 break;
    //             } else if (nums[p1] != nums[++p2]) {//注意这里p2递增，因为现在两个元素是相同的，要比较下一个
    //                 nums[++p1] = nums[p2]; //将下一个不一样的元素赋值到前面一堆相同元素的第二个位置
    //             } else {//递增后p2与p1下标所在元素依然相等
    //                 continue;
    //             }
    //         }
    //     }
    //     return p1;
    // }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}

//27.移除元素
//https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class P27 {
    //学习这种双指针写法。
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                //不必交换，也不必判断nums[right]是否为val，因为它会一直比较下去
                nums[left] = nums[right];
                right --;
            } else {
                left ++;
            }
        }
        //有没有发现left就是新数组长度
        return left;
    }

    // 第一版的想法还是太拉太复杂了，要注意题目根本不在乎超出返回长度值的那个部分，所以没必要搞交换那么复杂冗余
    // public static int removeElement(int[] nums, int val) {
    //     //想法是头尾双指针，如果遇到了指定值，就将它与从后开始第一个不是指定值的元素对换，然后减小该返回的长度。
    //     int p1 = 0, p2 = nums.length - 1;
    //     int length = nums.length;
    //     //这里的等于号是防止数组元素只有一个并且是指定值的情况，但下面哪个else里的while循环不用，否则会下标越界
    //     while (p1 <= p2) {
    //         if (nums[p1] != val) {
    //             p1 ++;
    //         } else if (nums[p2] != val) {
    //             int temp = nums[p1];
    //             nums[p1] = nums[p2];
    //             nums[p2] = temp;
    //             p1 ++;
    //             p2 --;
    //             length --;
    //         } else {
    //             while (nums[p2] == val && p1 < p2) {
    //                 p2 --;
    //                 length --;
    //             }
    //             int temp = nums[p1];
    //             nums[p1] = nums[p2];
    //             nums[p2] = temp;
    //             p1 ++;
    //             p2 --;
    //             length --;
    //         }
    //     }
    //     return length;
    // }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
}

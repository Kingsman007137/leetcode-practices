//31. 下一个排列
//https://leetcode.cn/problems/next-permutation/description/?envType=study-plan-v2&envId=top-100-liked

public class P31 {
    /*
     * 根据评论的想法写出来的：
     * 例如 2, 6, 3, 5, 4, 1 这个排列， 我们想要找到下一个刚好比他大的排列，
     * 于是可以从后往前看 我们先看后两位 4, 1 能否组成更大的排列，答案是不可以，
     * 同理 5, 4, 1也不可以 直到3, 5, 4, 1这个排列，因为 3 < 5， 我们可以通
     * 过重新排列这一段数字，来得到下一个排列 因为我们需要使得新的排列尽量小，
     * 所以我们从后往前找第一个比3更大的数字，发现是4 然后，我们调换3和4的位置，
     * 得到4, 5, 3, 1这个数列 因为我们需要使得新生成的数列尽量小，于是我们可以对
     * 5, 3, 1进行排序，可以发现在这个算法中，我们得到的末尾数字一定是倒序排列的，
     * 于是我们只需要把它反转即可 最终，我们得到了4, 1, 3, 5这个数列 完整的数列
     * 则是2, 6, 4, 1, 3, 5
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean sorted = true;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                // 在遍历过的数组中找到第一个大于nums[i - 1]的数字来交换
                for (int j = n - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        break; //别忘了这个
                    }
                }
                // 剩下后面的部分反转
                reverse(nums, i, n - 1);
                sorted = false;
                break;
            }
        }
        if (sorted) {
            reverse(nums, 0, n - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
}

//136. 只出现一次的数字
//https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked

public class P136 {
    // 牛逼解法：用异或，相同的数异或为0，0和任何数异或为该数，而且异或满足交换律
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }

    // 我的方法，用了set，但是性能不好
    // public int singleNumber(int[] nums) {
    //     Set<Integer> set = new HashSet();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (set.contains(nums[i])) {
    //             set.remove(nums[i]);
    //         } else {
    //             set.add(nums[i]);
    //         }
    //     }

    //     Integer[] array = set.toArray(new Integer[1]);
    //     return array[0];
    // }
}

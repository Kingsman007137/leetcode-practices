//152. 乘积最大子数组
//https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked

public class P152 {
    // 精彩解法：区分奇数个负数和偶数个负数和0的情况，其实就是争着和反正遍历一次来找
    // 看链接：https://leetcode.wang/leetcode-152-Maximum-Product-Subarray.html#%E8%A7%A3%E6%B3%95%E4%BA%8C
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max *= nums[i];
            res = Math.max(res, max);
            //如果遇到了0，那么就重新开始计算
            if (max == 0) {
                max = 1;
            }

        }
        max = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            max *= nums[i];
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }

        return res;
    }

    // 类似动态规划，一开始没想到要维护最小值来解决负数的问题。这个方法还是性能比较低
    // public int maxProduct(int[] nums) {
    //     int n = nums.length;
    //     int max = nums[0];
    //     int[] dpMax = new int[n];
    //     int[] dpMin = new int[n];
    //     dpMax[0] = nums[0];
    //     dpMin[0] = nums[0];
    //     //要维护最大最小值，需要在三个值当中来取，分别是当前值，当前值乘上前一个最大值，当前值乘上前一个最小值
    //     for (int i = 1; i < n; i++) {
    //         dpMax[i] = Math.max(nums[i], nums[i] * dpMax[i-1]);
    //         dpMax[i] = Math.max(dpMax[i], nums[i] * dpMin[i-1]);
    //         dpMin[i] = Math.min(nums[i], nums[i] * dpMin[i-1]);
    //         dpMin[i] = Math.min(dpMin[i], nums[i] * dpMax[i-1]);
    //         max = Math.max(max, dpMax[i]);
    //     }
    //     return max;
    // }
}

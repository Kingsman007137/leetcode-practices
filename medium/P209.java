//209. 长度最小的子数组
//https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150

public class P209 {
    // 这个思路和我完全一样，但是用了Integer.MAX_VALUE，省去了很多判断
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 性能低，可读性差，很多地方不懂得优化
    // public int minSubArrayLen(int target, int[] nums) {
    //     int slow = 0, fast = 0;
    //     int length = 100000;
    //     int sum = 0;
    //     while (slow <= fast ) {
    //         System.out.println(slow + " " + fast + " " + sum);
    //         while (sum >= target) {
    //             //因为fast在上一次循环已经递增1了，所以这里fast - slow就是符合的长度
    //             length = (fast - slow) <= length ? (fast - slow) : length;
    //             sum -= nums[slow];
    //             slow++;
    //             System.out.println("slow: " + slow + " length: " + length);
    //         }

               //这些判断就是因为我没想到用Integer.MAX_VALUE
    //         if (fast != nums.length) {
    //             sum += nums[fast];
    //             fast++;
    //         } else if (slow == 0) { //全部数组和都不满足
    //             length = 0;
    //             break;
    //         } else {
    //             slow++; //一直到与快指针相同
    //         }
            
    //     }
    //     return length;
    // }
}

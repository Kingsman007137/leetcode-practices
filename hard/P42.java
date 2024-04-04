//42. 接雨水
//https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked

public class P42 {
    // 最佳双指针解法，可能有点难懂，可以看：（3：10）开始
    // https://www.bilibili.com/video/BV1Qg411q7ia/?vd_source=7dad1fb91342de946e45a4b84f0c2d0a
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 左边比右边矮的时候，说明leftMax < rightMax了，否则height[left]应该不会有机会更新。
            // 所以这时候左边是“木桶”的短边，知道自己至少可以接多少，就向右看看能不能接更多
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else { // 逻辑同上，左后呼唤
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    // 双指针头尾往中间夹，写是写完了但代码比较臃肿，感觉最后那个阶梯形状的部分可以优化
    // public int trap(int[] height) {
    //     int n = height.length;
    //     // 两个指针，分别是左右两边最大值的下标
    //     int left = 0, right = n - 1;
    //     // 左右两边最大值
    //     int leftMax = 0, rightMax = 0;
    //     int cnt = 0;
    //     for (int i = 0; i <= n / 2; i++) {
    //         if (height[i] >= leftMax) {
    //             // 计算左边上一个最高到这里之间的雨水
    //             for (int j = left + 1; j < i; j++) {
    //                 cnt += leftMax - height[j];
    //             }
    //             // 更新左边最高值和下标
    //             leftMax = height[i];
    //             left = i;
    //         }
    //         if (height[n-1-i] >= rightMax) {
    //             for (int j = right - 1; j > n - 1 - i; j--) {
    //                 cnt += rightMax - height[j];
    //             }
    //             rightMax = height[n-1-i];
    //             right = n - 1 - i;
    //         }
    //     }

    //     int cnt1 = cnt, cnt2 = cnt;
    //     int leftMax1 = leftMax, leftMax2 = leftMax;
    //     int rightMax1 = rightMax, rightMax2 = rightMax;
    //     // 最后夹在左右最高值之间的部分
    //     // 但注意有可能中间呈阶梯分布还有比leftMax或rightMax大的值，所以需要加一个更新操作，而且要两方向遍历一次
    //     for (int i = left + 1; i < right; i++) {
    //         if (Math.min(leftMax1, rightMax1) > height[i]) {
    //             cnt1 += Math.min(leftMax1, rightMax1) - height[i];
    //         } else if (leftMax1 < rightMax1) { // 阶梯形状则更新最矮的为中间的
    //             leftMax1 = height[i];
    //         }
    //     }
    //     for (int i = right - 1; i > left; i--) {
    //         if (Math.min(leftMax2, rightMax2) > height[i]) {
    //             cnt2 += Math.min(leftMax2, rightMax2) - height[i];
    //         } else if (leftMax2 > rightMax2) {
    //             rightMax2 = height[i];
    //         }
    //     }

    //     return Math.max(cnt1, cnt2);
    // }
}

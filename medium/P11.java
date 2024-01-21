//11.盛最多水的容器
//https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150

public class P11 {
    // 一位大佬优化了一下代码，非常简洁，将两次对左右指针数值的判断合二为一提高了1ms，但可读性降低了
    // public int maxArea(int[] height) {
    //     int i = 0, j = height.length - 1, res = 0;
    //     while(i < j) {
    //         res = height[i] < height[j] ? 
    //             Math.max(res, (j - i) * height[i++]): 
    //             Math.max(res, (j - i) * height[j--]); 
    //     }
    //     return res;
    // }

    //一次通过，可惜性能不太好，可能可以加一些判断跳过一些循环
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            //短板才是盛水边界
            int theHeight = Math.min(height[left], height[right]);
            int theWidth = right - left;
            // 类似贪心算法
            maxWater = Math.max(maxWater, theHeight * theWidth);
            // 更新左右指针的条件很重要，其实根据题目图解可以看出来
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxWater;
    }
}

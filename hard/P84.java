//84. 柱状图中最大的矩形
//https://leetcode.cn/problems/largest-rectangle-in-histogram/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayDeque;
import java.util.Deque;

public class P84 {
    // 单调栈，有些忘记了。总是在想怎么记录各个情况最后求出最大值，其实只要每一次和自身用max()比较就行了
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 新数组前后多加两个0
        int[] tmp = new int[n + 2];
        // 又是没用过的方法
        System.arraycopy(heights, 0, tmp, 1, n);
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < n + 2; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」的下标；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」的下标。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积，这也是为啥要在原数组前后加各加一个0
            while (!stack.isEmpty() && tmp[stack.peek()] > tmp[i]) {
                int h = tmp[stack.pop()];
                int w = i - stack.peek() - 1;
                area = Math.max(area, w * h);
            }
            stack.push(i);
        }
        return area;
    }
}

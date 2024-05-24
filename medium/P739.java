//739. 每日温度
//https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.Deque;
import java.util.LinkedList;

public class P739 {
    // 单调栈，想法非常巧妙，栈中存放的是下标，栈中的下标对应的温度是递减的
    // 看方法二：https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
    // 优化：这个栈也可以用数组加指针来实现，性能更好
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() 
                && temperatures[stack.getFirst()] < temperatures[i]) { // LinkedList默认从前面进栈
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        P739 p739 = new P739();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        p739.dailyTemperatures(temperatures);
    }

    // 只想出了暴力法，超时
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int n = temperatures.length;
    //     if (n == 1) {
    //         return new int[]{0};
    //     }
    //     int[] res = new int[n];
    //     for (int i = n - 2; i >= 0; i--) {
    //         int first = i;
    //         for (int j = i; j < n; j++) {
    //             if (temperatures[j] > temperatures[i]) {
    //                 first = j;
    //                 break;
    //             }
    //         }
    //         res[i] = first - i;
    //     }
    //     return res;
    // }
}

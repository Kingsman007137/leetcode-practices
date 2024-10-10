//239. 滑动窗口最大值
//https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayDeque;
import java.util.Deque;

public class P239 {
    // 跳出思维框架，并不真正维护一个窗口
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // 根据值单调递减存储当前窗口的索引

        for (int i = 0; i < n; i++) {
            // 循环移除比当前元素小的索引，直到队列前面都是比nums[i]大的
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i); // 如果队列前面没有更大的，那么i就是在队首了

            // 如果队首的索引已经超出窗口最大值，移除队首元素
            if (i - q.getFirst() >= k) {
                q.removeFirst();
            }

            // 当窗口大小达到 k 之后，每次遍历都要记录当前窗口的最大值
            if (i >= k - 1) {
                ans[i - k + 1] = nums[q.getFirst()]; // 队首是当前窗口的最大值
            }
        }
        return ans;
    }

    // 作弊用了一些自带的方法，还是超时，应该想O(n)的方法
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     List<Integer> list = new ArrayList();
    //     int left = 0, right = 0;
    //     while (right < n) {
    //         if (right - left + 1 == k) {
    //             list.add(max(nums, left, right));
    //             left++;
    //         }
    //         right++;
    //     }
    //     // stream很有用但没有掌握，待学习
    //     return list.stream().mapToInt(i->i).toArray();
    // }

    // private int max(int[] nums, int left, int right) {
    //     int[] a = Arrays.copyOfRange(nums, left, right + 1);
    //     Arrays.sort(a);
    //     return a[right - left];
    // }
}

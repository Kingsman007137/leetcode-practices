//274. H 指数
//https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class P274 {
    // 计数排序，好好琢磨一下，时间复杂度O(n)
    public int hIndex(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

    // 1ms性能，但内存很多，不知为啥
    // public int hIndex(int[] citations) {
    //     //关键一步，先对这个数组排序
    //     Arrays.sort(citations);
    //     int n = citations.length;
    //     int h = 0;
    //     for (int i = 0; i < n; i++) {
    //         //这个元素的后面引用次数都比它大，那还要看看符合的论文篇数是不是小于等于这个元素
    //         int num = Math.min(citations[i], n - i);
    //         //符合条件的数字中取最大的
    //         h = Math.max(h, num);
    //     }
    //     return h;
    // }
}

//122.买股票的最佳时机II
//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150

public class P122 {
    // 换一种思想，不一定是要等到一波递增完了才计算，可以每天都计算一次。
    // 如果想象成是K线图，就是一天天地把所有上升部分加起来，不上升的部分就加0。
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    // 判断较多，性能还是不够快，还有更牛的解法
    // public int maxProfit(int[] prices) {
    //     if (prices.length == 0 || prices.length == 1) {
    //         return 0;
    //     }
    //     int maxProfit = 0;
    //     int slow = 0, fast = 1; 
    //     while (fast < prices.length) {
    //         int profit = 0;
    //         //只要fast指针发现有递减，就先算出前面一波的最大差价，然后给slow赋值到新的低点
    //         if (prices[fast] < prices[fast - 1]) {
    //             if (prices[fast - 1] > prices[slow]) {
    //                 profit = prices[fast - 1] - prices[slow]; 
    //             }
    //             slow = fast;
    //         }
    //         maxProfit += profit;
    //         fast++;
    //     }
    //     //这个是股价最后一波是顺序递增的情况
    //     if (prices[fast - 1] > prices[slow]) {
    //         maxProfit += prices[fast - 1] - prices[slow];
    //     }
    //     return maxProfit;
    // }
}

//121. 买卖股票的最佳时机
//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150

public class P121 {
    // 其实我们不用同时考虑最低价和最高价，只需要考虑最低价，然后看看最低价之后每一天卖出所得利润能否超过已算出的最高利润即可
    // 还是想得太多了，实际上出现了比以往更低的价格之后，就只会以这个价格为标准进行后续计算了。主要是这个if-else if关系没想到
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    // 注意是差值的最大值，而不是找出一前一后最大最小值就行了
    // 暴力大法，还是超时了。。
    // public int maxProfit(int[] prices) {
    //     if (prices.length == 0 || prices.length == 1) {
    //         return 0;
    //     }
    //     int maxProfit = 0;
    //     for (int i = 1; i < prices.length; i++) {
    //         for (int j = i - 1; j >= 0; j--) {
    //             if (prices[i] < prices[j] || prices[j] > prices[j + 1]) {
    //                 continue;
    //             } else if (prices[i] - prices[j] > maxProfit) {
    //                 maxProfit = prices[i] - prices[j];
    //             }
    //         }
    //     }
    //     return maxProfit;
    // }
}

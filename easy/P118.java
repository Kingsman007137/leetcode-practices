//118. 杨辉三角
//https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.List;

public class P118 {
    // 动态规划，重要的是发现第二层循环中if-else规律
    // dp几维数组，就要几层循环
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        //这样定义最后超出部分为0，则每行最后一个"1"也能正确计算出。
		int[][] dp = new int[numRows][numRows];
		dp[0][0] = 1;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		res.add(list);
		for (int i = 1; i < numRows; i++) {
			List<Integer> tmp = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
				tmp.add(dp[i][j]);
			}
			res.add(tmp);
		}
		return res;
    }

    // 我想的方法，每次先取上一行的list，新的list的第一个和最后一个都是1，中间的数是上一行的两个数相加
    // public List<List<Integer>> generate(int numRows) {
    //     List<List<Integer>> res = new ArrayList();
    //     //初始化第一个(匿名内部类方法)
    //     List<Integer> row1 = new ArrayList() {{
    //         add(1);
    //     }};
    //     res.add(row1);
    //     for (int i = 1; i < numRows; i++) {
    //         List<Integer> last = res.get(res.size() - 1);
    //         List<Integer> newRow = new ArrayList<>();
    //         newRow.add(1);
    //         for (int j = 0; j < last.size() - 1; j++) {
    //             newRow.add(last.get(j) + last.get(j + 1));
    //         }
    //         newRow.add(1); //每行前后都是1
    //         res.add(newRow);
    //     }
    //     return res;
    // }
}

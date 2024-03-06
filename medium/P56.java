//56. 合并区间
//https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56 {
    //主要就是纠结怎么更新条件，就没想到先排序，其实只要不需要连续的，一般可以排序
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 根据左端点排序？不会啊
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] a, int[] b) {
        //         return a[0] - b[0];
        //     }
        // });

        //这个是lambda表达式，更简洁，但不太会
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //这里是取出集合中最后一个，然后比较
            int[] last = res.get(res.size() - 1);
            if (last[1] >= intervals[i][0]) {
                //这里一定是选比较大的
                last[1] = Math.max(intervals[i][1], last[1]);
            } else {
                res.add(intervals[i]);
            }
        }
        //这里是把list转成数组，也不太会，学习一下
        return res.toArray(new int[res.size()][]);
    }
}

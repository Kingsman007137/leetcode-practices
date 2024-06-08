//347. 前 K 个高频元素
//https://leetcode.cn/problems/top-k-frequent-elements/?envType=study-plan-v2&envId=top-100-liked

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347 {
    // 优先队列来创建大小为k的小根堆，每个元素都只要和堆顶元素比较
    // 堆的数据结构和堆排序有些忘了，可以看看：
    // https://www.cnblogs.com/chengxiao/p/6129630.html
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    // 排序方法，性能不达标，不过可以学习一下有关map value排序的方法
    // public int[] topKFrequent(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] ret = new int[k];
    //     Map<Integer, Integer> map = new HashMap();
    //     for (int i = 0; i < n; i++) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //     }
    //     // 根据map的value进行排序
    //     List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
    //     Collections.sort(list, (a, b) -> {
    //         return b.getValue() - a.getValue();
    //     });

    //     for (int i = 0; i < k; i++) {
    //         ret[i] = list.get(i).getKey();
    //     }
    //     return ret;
    // }
}

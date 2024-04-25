//215. 数组中的第K个最大元素
//https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked

public class P215 {
    // 其实这道题是想让我们用堆排序，可以看看题解（方法三）
    // https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/19607/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-

    // 桶排序，非常的精妙，性能无敌
    public int findKthLargest(int[] nums, int k) {
        // 题目说了 -10^4 <= nums[i] <= 10^4
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }

    // -------------------------------------------------------------------------------
    // 我根据算法书写的，基于分治算法，类似于快速排序的快速选择，平均时间复杂度应该也算O(n)
    // public int findKthLargest(int[] nums, int k) {
    //     int res = quickSelect(nums, k, 0, nums.length - 1);
    //     return res;
    // }

    // private int quickSelect(int[] nums, int k, int begin, int end) {
    //     int i = begin, j = end;
    //     // 区间只剩一个元素，由于题目说明，肯定有答案，所以只能是第k-1个元素
    //     if (begin == end && begin == k-1) {
    //         return nums[begin];
    //     } else { // 根据题目输入的限制，除了上述情况，只剩下begin < end情况，所以这里写else方便有返回
    //         // 这分组第一个元素作为基准
    //         int base = nums[begin];
    //         while (i != j) {
    //             // 注意这两个if的判断条件，以及最好先从右往左再从左往右
    //             if (j > i && nums[j] <= base) {
    //                 j--;
    //             }
    //             nums[i] = nums[j];
    //             if (i < j && nums[i] >= base) {
    //                 i++;
    //             }
    //             nums[j] = nums[i];
    //         }
    //         nums[i] = base;
    //         if (i == k-1) return base;
    //         // 在左半区搜索
    //         if (i > k-1) return quickSelect(nums, k, begin, i - 1);
    //         // 在右半区搜索
    //         else return quickSelect(nums, k, i + 1, end);
    //     }
    // }
}

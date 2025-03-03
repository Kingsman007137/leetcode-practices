// 295. 数据流的中位数
// https://leetcode.cn/problems/find-median-from-data-stream/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.PriorityQueue;

public class P295 {
    // 堆的思想不熟
    // 题解：https://leetcode.cn/problems/find-median-from-data-stream/solutions/3015873/ru-he-zi-ran-yin-ru-da-xiao-dui-jian-ji-4v22k/?envType=study-plan-v2&envId=top-100-liked
    class MedianFinder {
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        PriorityQueue<Integer> right = new PriorityQueue<>(); // 最小堆

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (left.size() > right.size()) {
                left.add(num);
                right.add(left.poll());
            } else {
                right.add(num);
                left.add(right.poll());
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }
}

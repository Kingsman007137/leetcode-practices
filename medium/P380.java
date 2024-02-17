//380. O(1) 时间插入、删除和获取随机元素
//https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

//对于 insert 和 remove 使用「哈希表」来实现 O(1) 复杂度，但对于 getRandom 操作，比较理想的情况是能够在一个数组内随机下标进行返回。
//将两者结合，我们可以将哈希表设计为：以入参 val 为键，数组下标 loc 为值。
class RandomizedSet {
    static int[] nums = new int[200010];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int idx = -1;
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.remove(val);
        //如果删除的不是队尾元素，则把队尾的元素放到这个元素原来位置，map也要更新
        if (loc != idx) map.put(nums[idx], loc);
        //无论删除的是不是队尾元素，它都不再需要了
        nums[loc] = nums[idx--];
        return true;
    }
    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }
}

// 我的执行时间很长
// class RandomizedSet {
//     private Set<Integer> s = null;
//     public RandomizedSet() {
//         s = new HashSet();
//     }   
//     public boolean insert(int val) {
//         if (s.contains(val)) {
//             return false;
//         }
//         s.add(val);
//         return true;
//     }   
//     public boolean remove(int val) {
//         if (!s.contains(val)) {
//             return false;
//         }
//         s.remove(val);
//         return true;
//     }
//     public int getRandom() {
//         Object[] res = s.toArray();
//         //这里Random()要缺省才行，因为使用种子缺省是当前系统时间的毫秒数的Random对象
//         //用种子的话每次第一个随机数都是一样的
//         int randomIndex = new Random().nextInt(s.size());
//         return (Integer) res[randomIndex];
//     }
// }

public class P380 {
    static RandomizedSet r = new RandomizedSet();
    public static void main(String[] args) {
        r.insert(1);
        r.insert(10);
        r.insert(20);
        r.insert(30);
        for (int i = 0; i < 100; i++) {
            System.out.println(r.getRandom());
        }
    }
}

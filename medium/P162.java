//162.两数之和 II - 输入有序数组
//https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150

public class P162 {
    // 最后是逆天的双指针做法，因为一定有唯一解，所以我们也可以用类似二分法思想，一头一尾两个指针，根据和与目标值比较情况移动其中一个指针
    public int[] twoSum(int[] numbers, int target) {
        int front = 0, back = numbers.length - 1;
        while (front <= back) {
            if (numbers[front] + numbers[back] == target) {
                return new int[]{front + 1, back + 1};
            } else if (numbers[front] + numbers[back] >= target) {
                back--;
            } else {
                front++;
            }
        }
        return null;
    }

    // 就算是查找也不应该逐个查找，用二分查找性能多好啊
    // public int[] twoSum(int[] numbers, int target) {
    //     for (int i = 0; i < numbers.length; i++) {
    //         int low = i + 1, high = numbers.length - 1;
    //         //别忘了，仍然是两层循环
    //         while (low <= high) {
    //             int mid = (high + low) / 2;
    //             int last = target - numbers[i];
    //             if (numbers[mid] == last) {
    //                 return new int[]{i + 1, mid + 1};
    //             } else if (numbers[mid] > last) {
    //                 high = mid - 1;
    //             } else {
    //                 low = mid + 1;
    //             }
    //         }
    //     }
    //     return null;
    // }

    // 暴力解法，性能太差，学艺不精...
    // public int[] twoSum(int[] numbers, int target) {
    //     int index[] = new int[2];
    //     for (int i = 0; i < numbers.length; i++) {
    //         int last = target - numbers[i];
    //         for (int j = i + 1; j < numbers.length && numbers[j] <= last; j++) {
    //             if (numbers[j] == last) {
    //                 index[0] = i + 1;
    //                 index[1] = j + 1;
    //                 return index;
    //             }
    //         }
    //     }
    //     return null;
    // }
}

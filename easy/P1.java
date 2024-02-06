//1.两数之和
//https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;
import java.util.Map;

public class P1 {
    //哈希表，有点技巧，别想着两层循环了。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int index1 = 0, index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.containsKey(target - nums[i])) {
                numsMap.put(nums[i], i);
            } else {
                index1 = numsMap.get(target - nums[i]);
                index2 = i;
                break;
            }
        }
        return new int[]{index1, index2};
    }
}

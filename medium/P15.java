//15. 三数之和
//https://leetcode-cn.com/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.*;

public class P15 {
    // 排序 + 一前一后双指针。和大于0则右指针左移，和小于0则左指针右移
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果第一个数就大于0，那么后面的数肯定也大于0，不可能有和为0的三个数
            if (nums[i] > 0) {
                break;
            }
            // 如果和前一个数相同，那么肯定会有重复的结果，所以跳过
            if (i == 0 || nums[i] > nums[i-1]) {
                int j = i + 1;
                int k = nums.length -1;
                
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        results.add(result);
                        j++;
                        k--;
                        // 这两个while也是为了去重
                        while (j < k && nums[j] == nums[j-1]) {
                            j++;
                        }
                        while (j < k &&nums[k] == nums[k+1]) {
                            k--;
                        }
                    } else if (sum  > 0) {
                        k --;
                    } else {
                        j ++;
                    }
                }
                
            } 
        }
        return results;
    }

    // 大数据量会超时，想不出来更好的方法
    // public List<List<Integer>> threeSum(int[] nums) {
    //     // 一开始忘了排序，排序可以让有重复的List元素顺序也相同，可以用equals()
    //     Arrays.sort(nums);
    //     Map<Integer, Integer> map = new HashMap();
    //     List<List<Integer>> res = new ArrayList();
    //     for (int i = 0; i < nums.length - 2; i++) {
    //         int target = nums[i] * (-1);
    //         //从这里开始就像两数之和了
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (!map.containsKey(nums[j])) {
    //                 map.put(target - nums[j], nums[j]);
    //             } else {
    //                 List<Integer> list = new ArrayList();
    //                 boolean repeat = false;
    //                 list.add(nums[i]);
    //                 list.add(map.get(nums[j]));
    //                 list.add(nums[j]);
    //                 //判断有无重复
    //                 for (List<Integer> l: res) {
    //                     if (list.equals(l)) {
    //                         repeat = true;
    //                         break;
    //                     }
    //                 }
    //                 if (!repeat) {
    //                     res.add(list);
    //                 }
    //             }
    //         }
    //         map.clear();
    //     }

    //     return res;
    // }
}

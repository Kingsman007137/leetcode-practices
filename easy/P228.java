//228. 汇总区间
//https://leetcode.cn/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.ArrayList;
import java.util.List;

public class P228 {
    // 这个思路与我相同，但就是快，0ms，为什么呢？
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

    // 又是类双指针的胜利，应该注意一下如何在循环中考虑到“最后一组”的逻辑，并且想办法包括为空的情况
    // 但是这个性能一般
    // public List<String> summaryRanges(int[] nums) {
    //     int slow = 0, fast = 0;
    //     List<String> res = new ArrayList<>();
    //     while (fast < nums.length) {
    //         //首先最后一次逻辑别漏掉，其次这个long转换是因为有个阴险的测试样例：[-2147483648,-2147483647,2147483647]
    //         if (fast == nums.length - 1 || (long)nums[fast + 1] - (long)nums[fast] > 1) {
    //             String s = nums[slow] == nums[fast] ? nums[slow] + "" : nums[slow] + "->" + nums[fast];
    //             res.add(s);
    //             slow = fast + 1;
    //         }
    //         fast ++;
    //     }
    //     return res;
    // }
}

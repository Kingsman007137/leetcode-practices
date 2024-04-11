//763. 划分字母区间
//https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.List;

public class P763 {
    // 贪心，每次找到一个字母的最后出现位置，然后如果能遍历到这个位置就是一个分段
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] ends = new int[26];
        for (int i = 0; i < n; i++) {
            //记录每个字母最后出现的下标
            ends[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> res = new ArrayList();
        for (int i = 0; i < n; i++) {
            end = Math.max(end, ends[s.charAt(i) - 'a']);
            //到了一个分段的最后，这段中间每个字母都不会在后面出现
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}

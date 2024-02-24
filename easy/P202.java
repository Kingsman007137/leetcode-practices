//202. 快乐数
//https://leetcode.cn/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashSet;
import java.util.Set;

public class P202 {
    // 这题的题解很有趣，证明了为什么要不就到1要不就有环，而不是会一直增大。
    // https://leetcode.cn/problems/happy-number/solutions/224894/kuai-le-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-interview-150

    // 这就是正常做法，找有没有“环”，用快慢指针也可以找
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // 我的0ms做法，碰巧对了，bug在于我认定了他会达到只剩一位数的情况
    // public boolean isHappy(int n) {
    //     int num = n;
    //     int digit = 0;
    //     int sum = 0;
    //     while (num >= 10) {
    //         sum = 0;
    //         while (num > 0) {
    //             digit = num % 10;
    //             sum += digit * digit;
    //             num /= 10;
    //         }
    //         num = sum;
    //     }

    //     //非常抽象，7也可以
    //     return num == 1 || num == 7;
    // }
}

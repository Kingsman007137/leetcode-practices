package interview;
// Java算法题：给一个数字数组，例如a = {2， 4， 5， 9}，
// 再给一个数字k，例如22487，求由a里面数字组成的小于k的最大整数。
// 数组中的数字可以重复使用。

import java.util.Arrays;

public class ByteDance1 {
    private int[] a;
    private int k;
    private int max;

    public int findMaxNumber(int[] a, int k) {
        this.a = a;
        this.k = k;
        this.max = 0;
        Arrays.sort(a); // 对数组进行排序，以便优先使用较大的数字
        backtrack(0, 0);
        return max;
    }

    private void backtrack(int index, int current) {
        if (current > k) {
            return; // 如果当前组合已经大于k，直接返回
        }
        if (current > max) {
            max = current; // 更新最大值
        }
        for (int i = a.length - 1; i >= 0; i--) { // 从大到小尝试每个数字
            backtrack(index + 1, current * 10 + a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 5, 9};
        int k = 23478;
        ByteDance1 solution = new ByteDance1();
        int result = solution.findMaxNumber(a, k);
        System.out.println(result); // 输出结果
    }
}

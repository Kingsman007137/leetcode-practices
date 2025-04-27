package interview;

import java.util.Arrays;

public class DifferenceArray {
    private int[] diff; // 差分数组
    
    // 初始化差分数组
    public DifferenceArray(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    
    // 区间加减操作 [left, right] 闭区间
    public void increment(int left, int right, int val) {
        diff[left] += val;
        if (right + 1 < diff.length) {
            diff[right + 1] -= val;
        }
    }
    
    // 还原操作后的数组
    public int[] getResult() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public static void main(String[] args) {
        // 初始数组
        int[] nums = {1, 3, 2, 5, 8};
        DifferenceArray df = new DifferenceArray(nums);
        
        // 执行两次区间操作
        df.increment(1, 3, 2); // 第2-4位加2
        df.increment(0, 2, -1); // 第1-3位减1
        
        // 输出结果
        System.out.println("结果数组: " + Arrays.toString(df.getResult()));
    }
}

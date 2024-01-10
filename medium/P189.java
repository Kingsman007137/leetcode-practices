//189.轮转数组
//https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150

public class P189 {
    // 原地解法，原理示意图：
    // nums = "----->-->"; k =3
    // result = "-->----->";
    // reverse "----->-->" we can get "<--<-----"
    // reverse "<--" we can get "--><-----"
    // reverse "<-----" we can get "-->----->"
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    // 更简洁的解法，虽然想法差不多，但人家就是能一步到位。。。
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] newArr = new int[n];
    //     for (int i = 0; i < n; ++i) {
    //         newArr[(i + k) % n] = nums[i];
    //     }
    //     System.arraycopy(newArr, 0, nums, 0, n);
    // }
    
    // 艰难想出，但不够简洁
    // public static void rotate(int[] nums, int k) {
    //     int[] temp = new int[nums.length];
    //     //这个i的取值比较难想，多举几个特殊的例子试验一下即可
    //     int i = nums.length - (k % nums.length), j = 0;
    //     while (i < nums.length) {
    //         temp[j] = nums[i];
    //         i++;
    //         j++;
    //     }
    //     i = 0;
    //     while (j < nums.length) {
    //         temp[j] = nums[i];
    //         i++;
    //         j++;
    //     }
    //     //Arrays.copyOf()只是创建数组时赋值给新数组，要想改变原数组还得用这个方法
    //     System.arraycopy(temp, 0, nums, 0, nums.length);
    // }
}
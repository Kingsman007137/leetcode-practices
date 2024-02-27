//283.移动零
//https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked

public class P283 {
    // 前面想的太复杂了，其实fast位置只要不是0就和slow位置交换就行
    // fast和slow同时从零开始，则它们会一起走到第一个0位置，然后slow会留在0那里，fast就会去找第一个非零的然后交换
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int n = nums.length - 1;
        int slow = 0, fast = 0;
        while (fast <= n) {
            if (nums[fast] != 0) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
            fast++;
        }
    }

    // 还有这种方法，遇到非零的直接放到靠左，然后在遍历一次把后面的变为0
    // public void moveZeroes(int[] nums) {
    //     int count=0;
    //     for(int i=0;i<nums.length;i++)
    //         if(nums[i]!=0){
    //            nums[count++]=nums[i];
    //         }

    //     while(count<nums.length) {
    //         nums[count++]=0;
    //     }
    // }
}

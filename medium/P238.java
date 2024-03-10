//238. 除自身以外数组的乘积
//https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.Arrays;

public class P238 {
    // 还有神人合二为一，用双指针法，beforeSum表示前缀积，afterSum表示后缀积
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int beforeSum=1;
        int afterSum=1;
        for(int i=0,j=n-1;i<n;i++,j--){
            ans[i]*=beforeSum;
            ans[j]*=afterSum;
            beforeSum*=nums[i];
            afterSum*=nums[j];
        }
        return ans;
    }

    // 看了一点提示后想出来的，还不错
    // public int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int[] ans = new int[n];
    //     // 第一次循环不用到ans[0]，如果不赋为1则ans[0]会一直为0
    //     ans[0] = 1;
    //     // 先乘左边再乘右边
    //     int left = 1, right = 1;
    //     for (int i = 1; i < n; i++) {
    //         ans[i] = left * nums[i - 1];
    //         left *= nums[i - 1];
    //     }
    //     for (int i = n - 2; i >= 0; i--) {
    //         ans[i] *= right * nums[i + 1];
    //         right *= nums[i + 1];
    //     }
    //     return ans;
    // }
}

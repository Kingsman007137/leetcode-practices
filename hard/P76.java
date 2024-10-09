//76. 最小覆盖子串
//https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked

public class P76 {
    // t中可能有重复字符，我一开始用的集合判断是否包含错了，还得记录字符个数
    // 这个题解和我思路都是滑动窗口，但他巧妙地用了一个need数组来记录t中需要字符的个数，比集合好
    public static String minWindow(String s, String t) {
        //首先创建的是need数组表示每个字符在t中需要的数量，用ASCII码来保存，如果是负数表明当前字符在窗口中是多余的
        int[] need = new int[128];
        //按照字符串t的内容向need中添加元素
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        /*
        size: 窗口的长度
        count: 当次遍历中还需要几个字符才能够满足包含t中所有字符的条件，最大也就是t的长度
        start: 如果有效更新滑动窗口，记录这个窗口的起始位置
         */
        int left = 0, right = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            //表示t中包含当前遍历到的这个c字符，更新目前所需要的count数大小，应该减少一个
            if (need[c] > 0) {
                count--;
            }
            //无论这个字符是否包含在t中，need[]数组中对应那个字符的计数都减少1，利用正负区分这个字符是多余的还是有用的
            need[c]--;
            //count==0说明当前的窗口已经满足了包含t所需所有字符的条件
            if (count == 0) {
                //把左边所有t没有的字符去掉，直到这个状态的窗口是最小的
                while (need[s.charAt(left)] < 0) {
                    //在need[]数组中维护更新这个值，增加1
                    need[s.charAt(left)]++;
                    left++;
                }
                //如果当前的这个窗口值比之前维护的窗口值更小，需要进行更新
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                //先将左位置的字符计数重新加1
                need[s.charAt(left)]++;
                //重新维护左边界值和当前所需字符的值count，看看右边没有遍历到的字符是否还有符合条件的
                left++;
                count++;
            }
            //右移边界，开始下一次循环
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}

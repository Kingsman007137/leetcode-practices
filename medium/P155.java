//155. 最小栈
//https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.*;

public class P155 {
    // 还有一种方法是使用两个栈，一个栈记录元素，一个栈记录最小值
    // https://leetcode.cn/problems/min-stack/solutions/2378751/javapython3cshi-yong-fu-zhu-zhan-bu-shi-s1hr5

    // 不使用额外空间，用栈记录差值
    Stack<Long> diffs;    // 入栈值与其入栈时最小值的差值
    long minVal;          // 当前最小值
    public P155() {
        diffs = new Stack();
    }
    
    public void push(int val) {
        if(diffs.isEmpty()){
            diffs.push(0L);     // 当前栈内没有元素，差值为0入栈
            minVal = val;       // 最小值为当前入栈元素
        }else{
            diffs.push((long)val - minVal);     // 先记录差值
            minVal = Math.min(minVal, val);     // 再更新最小值
        }
    }
    
    public void pop() {
        // 弹出栈顶差值
        // 如果差值为负，表示在这个位置最小值发生改变，需要还原原来的最小值
        // minVal = minVal - diff，否则最小值不变
        minVal -= Math.min(diffs.pop(), 0); 
    }
    
    public int top() {
        // 根据差值还原当前元素
        // 如果差值为负，说明当前位置发生了最小值改变，入栈值为最小值，记录的是和原来最小值的差值
        // 否则记录的差值是入栈值和当前最小值的差值，相加还原
        return (int)(minVal + Math.max(diffs.peek(), 0));
    }
    
    public int getMin() {
        return (int)minVal;
    }

    // -------------------------------------------------------------------------------
    // 我的方法，使用一个栈，一直记录目前最小值，获取最小值时确实是O(1)，但是pop操作可能是O(n)
    // List<Integer> stack;
    // int min;

    // public MinStack() {
    //     stack = new LinkedList();
    //     min = Integer.MAX_VALUE;
    // }
    
    // public void push(int val) {
    //     stack.addLast(val);
    //     if (val < min) {
    //         min = val;
    //     }
    // }
    
    // public void pop() {
    //     if (stack.removeLast() == min) {
    //         min = Integer.MAX_VALUE;
    //         for (int i: stack) {
    //             if (i < min) {
    //                 min = i;
    //             }
    //         }
    //     }
    // }
    
    // public int top() {
    //     return stack.getLast();
    // }
    
    // public int getMin() {
    //     return min;
    // }
}

//234. 回文链表
//https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.List;

public class P234 {
    // O(1)空间复杂度，难想的是找到链表的中点，用的是快慢指针
    public boolean isPalindrome(ListNode head) {
        if (head == null) { 
            return true;
        }
    
        ListNode slow = head, fast = head.next;
        // 找到链表的中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针每次移动两步
            slow = slow.next; // 慢指针每次移动一步
        }
    
        ListNode second = slow.next, pre = null; // second指向链表的后半部分，pre用来反转链表
        slow.next = null; // 将链表切成两半
    
        // 反转链表的后半部分，用到P206的解法
        while (second != null) {
            ListNode next = second.next;
            second.next = pre;
            pre = second;
            second = next;
        }
    
        // 比较链表的前半部分和反转后的后半部分是否相同
        while (pre != null && pre.val == head.val) {
            pre = pre.next; // 移动反转后的后半部分的指针
            head = head.next; // 移动前半部分的指针
        }
    
        // 如果反转后的后半部分已经遍历完，那么链表是回文的
        return pre == null;
    }

    // 我自己的做法，偷懒用了集合，空间复杂度O(n)
    // public boolean isPalindrome(ListNode head) {
    //     List<Integer> nums = new ArrayList();
    //     while (head != null) {
    //         nums.add(head.val);
    //         head = head.next;
    //     }
    //     for (int i = 0, j = nums.size() - 1; i <= j; i++, j--) {
    //         if (nums.get(i) != nums.get(j)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}

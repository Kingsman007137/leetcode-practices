//141.环形链表
//https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
       val = x;
       next = null;
    }
 }
 
public class P141 {
    // 还是看看正经解法吧，快慢指针，又称Floyd判圈算法：快指针一次走两个，慢指针走一个，如果有圈快指针一定会套慢指针圈，然后相遇
    // https://zhuanlan.zhihu.com/p/105269431#:~:text=Floyd%E5%88%A4%E5%9C%88%E7%AE%97%E6%B3%95%20%28Floyd%20Cycle%20Detection%20Algorithm%29%EF%BC%8C%E5%8F%88%E7%A7%B0%E9%BE%9F%E5%85%94%E8%B5%9B%E8%B7%91%E7%AE%97%E6%B3%95,%28Tortoise%20and%20Hare%20Algorithm%29%EF%BC%8C%E6%98%AF%E4%B8%80%E4%B8%AA%E5%8F%AF%E4%BB%A5%E5%9C%A8%E6%9C%89%E9%99%90%E7%8A%B6%E6%80%81%E6%9C%BA%E3%80%81%E8%BF%AD%E4%BB%A3%E5%87%BD%E6%95%B0%E6%88%96%E8%80%85%E9%93%BE%E8%A1%A8%E4%B8%8A%E5%88%A4%E6%96%AD%E6%98%AF%E5%90%A6%E5%AD%98%E5%9C%A8%E7%8E%AF%EF%BC%8C%E6%B1%82%E5%87%BA%E8%AF%A5%E7%8E%AF%E7%9A%84%E8%B5%B7%E7%82%B9%E4%B8%8E%E9%95%BF%E5%BA%A6%E7%9A%84%E7%AE%97%E6%B3%95%E3%80%82%20%E8%AF%A5%E7%AE%97%E6%B3%95%E6%8D%AE%E9%AB%98%E5%BE%B7%E7%BA%B3%E7%A7%B0%E7%94%B1%E7%BE%8E%E5%9B%BD%E7%A7%91%E5%AD%A6%E5%AE%B6%E7%BD%97%E4%BC%AF%E7%89%B9%C2%B7%E5%BC%97%E6%B4%9B%E4%BC%8A%E5%BE%B7%E5%8F%91%E6%98%8E%E3%80%82
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) { // 两指针相遇说明有圈
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 逆天解法，但是给我搞对了，不过这会改变链表里的值
    // public boolean hasCycle(ListNode head) {
    //     if (head == null) {
    //         return false;
    //     }
    //     while (head.next != null) {
    //         if (head.val == 100001) { //提供的值最大是100000
    //             return true;
    //         }
    //         head.val = 100001;
    //         head = head.next;
    //     }
    //     return false;
    // }
}

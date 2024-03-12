//206. 反转链表
//https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked

public class P206 {
    // 自己想出，每轮循环记录前、中、后三个节点，将中节点的next指向前节点，三节点整体都向后移动
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode middle = head.next;
        ListNode front = head;
        head.next = null;
        while (middle != null) {
            ListNode behind = middle.next;
            middle.next = front;
            front = middle;
            middle = behind;
        }
        return front;
    }
}

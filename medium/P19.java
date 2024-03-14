//19. 删除链表的倒数第 N 个结点
//https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked

public class P19 {
    // 倒数的这种有差值的题目就适合用快慢指针，这个伪节点放在头部很难想到，它是考虑到了有可能删除头节点
    // 在对链表进行操作时，一种常用的技巧是添加一个哑节点（dummy node），它的 next 指针指向链表的头节点。
    // 这样一来，我们就不需要对头节点进行特殊的判断了
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode(0); // 伪节点
        p.next = head;
        ListNode fast = p;
        ListNode slow = p;
        while (n > 0)  { //快指针先走n步
            fast = fast.next;
            n--;
        }
        while (fast.next != null) { //快指针走到头，慢指针恰好走到要删的前一个结点
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return p.next; //头指针有可能被删除
    }
}

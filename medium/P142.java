//142. 环形链表 II
//https://leetcode.cn/problems/linked-list-cycle-ii/?envType=study-plan-v2&envId=top-100-liked

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class P142 {
    // 精彩绝伦的双指针解法：https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // a是链表头到环入口的距离（不包括入口节点），b是环长度
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next; 
            slow = slow.next;
            if (fast == slow) break; //此时f走了s + nb步，且是s两倍，所以s = nb
        }
        fast = head;
        // s走a + nb步就到了环入口，所以还需要再走a步，f从头走a步也到环入口，所以f和s相遇的地方就是环入口
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    // 用集合，性能低
    // public ListNode detectCycle(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return null;
    //     }
    //     Set<ListNode> set = new HashSet();
    //     while (head.next != null) {
    //         if (set.contains(head)) {
    //             return head;
    //         }
    //         head = head.next;
    //         set.add(head);
    //     }
    //     return null;
    // }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(new P142().detectCycle(head).val);
    }
}
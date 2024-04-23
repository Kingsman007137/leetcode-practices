//148. 排序链表
//https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked

public class P148 {
    // 自顶向下归并排序，非常牛，仔细琢磨一下
    // 还有自底向上的归并，可以看看https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        // 快慢指针找到中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 分割链表，变成头节点为head和tmp的两个链表，这里slow.next为null才是真正断开
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归分别对两个链表在分割，分割到只有一个节点为止，后面就会合并
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 合并两个有序链表
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        // 归并排序的特点，两个链表长度不一样，剩下的部分直接接到后面
        h.next = left != null ? left : right;
        return res.next;
    }

    // 我的解法类似冒泡排序，性能不佳，测试样例大就通过不了
    // 不过这可能也不算真正得冒泡，真正的冒泡是比较相邻的两个元素。
    // 可看https://blog.csdn.net/qq_43794633/article/details/121612149
    // public ListNode sortList(ListNode head) {
    //     ListNode p = head;
    //     while (p != null) {
    //         ListNode n = p.next;
    //         while (n != null) {
    //             if (n.val < p.val) {
    //                 int tmp = n.val;
    //                 n.val = p.val;
    //                 p.val = tmp;
    //             }
    //             n = n.next;
    //         }
    //         p = p.next;
    //     }
    //     return head;
    // }
}

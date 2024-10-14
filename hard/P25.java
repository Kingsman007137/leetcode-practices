//25. K 个一组翻转链表
//https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked

public class P25 {
    // 自己相处的迭代解法，感觉有点复杂，但是思路是对的
    // 还有递归解法。。。
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 1, times = 0;
        ListNode begin = head, node = head, last = null;
        while (node != null && count <= k) {
            if (count == k) {
                count = 1;
                reverse(begin, node);

                // 第一次翻转，head指向新的头结点node，last指向这一次翻转的尾结点
                if (times == 0) {
                    head = node;
                    last = begin;
                } else {
                    // 上一次翻转后的尾结点指向新的头结点node
                    last.next = node;
                    // 标记这一次翻转后的尾结点，便于下一次翻转时指向下一次的头结点
                    last = begin;
                }

                if (begin.next == null) {
                    break;
                }
                // begin和node继续向后移动至同一位置
                begin = begin.next;
                node = begin;
                times++;
            } else {
                count++;
                node = node.next;
            }
        }
        return head;
    }

    private void reverse(ListNode begin, ListNode end) {
        // 从begin到end翻转链表，轻松想出
        ListNode tmp = begin;
        while (!tmp.equals(end)) {
            tmp = tmp.next;
            begin.next = end.next;
            end.next = begin;
            begin = tmp;
        }
    }

    public static void main(String[] args) {
        P25 p25 = new P25();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode ret = p25.reverseKGroup(head, 2);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }
}

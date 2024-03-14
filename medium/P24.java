//24. 两两交换链表中的节点
//https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked

public class P24 {
    // 这个只需要维护一个指针，用它来指向下一次要交换的两个结点，而且写的比较简洁
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    // 学完P19之后用的双指针 + 哑巴结点，只是写的有点不够简洁
    // public ListNode swapPairs(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }
    //     ListNode p = new ListNode(0);
    //     p.next = head;
    //     ListNode odd = p.next; // 奇数指针
    //     ListNode even = p.next.next; // 偶数指针
    //     p.next = even; // 链表头节点是第二个节点
    //     int length = 0;
    //     while (head != null) {
    //         length ++;
    //         head = head.next;
    //     }
    //     for (int i = 1; i < length / 2; i++) {
    //         //先把下一次循环的结点暂存起来
    //         ListNode m = odd.next.next;
    //         ListNode n = even.next.next;

    //         odd.next = even.next.next;
    //         even.next = odd;
    //         odd = m;
    //         even = n;
    //     }
    //     //最后还有两个（奇数长度的话还有三个）
    //     odd.next = length % 2 == 1 ? odd.next.next : null;
    //     even.next = odd;
    //     return p.next;
    // }
}

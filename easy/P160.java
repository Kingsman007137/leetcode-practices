//160. 相交链表
//https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked

public class P160 {
    // 妙解，将两个指针都遍历两个链表，就算两个链表长度不同，两个指针遍历的总长度也是相同的，就能同时到达相交点或者同时为null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        if (pA == null || pB == null) {
            return null;
        }
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // failed！对集合方法的理解还不够深刻
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode pA = headA, pB = headB;
    //     Set<ListNode> set = new HashSet();
    //     while (pA != null) {
    //         // 这里本来用的是TreeSet，出错：class ListNode cannot be cast to class java.lang.Comparable
    //         set.add(pA);
    //         pA = pA.next;
    //     }
    //     while (pB != null) {
    //         if (set.contains(pB)) {
    //             return pB;
    //         }
    //         pB = pB.next;
    //     }
    //     return null;
    // }
}

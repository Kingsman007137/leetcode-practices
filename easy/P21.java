//21. 合并两个有序链表
//https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150

public class P21 {
    // 递归做法，真的很难想到
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 我的方法，0ms，就是merge的逻辑。
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     ListNode list = new ListNode();
    //     ListNode res = list;
    //     while (list1 != null && list2 != null) {
    //         if (list1.val >= list2.val) {
    //             list.next = new ListNode(list2.val);
    //             list2 = list2.next;
    //         } else {
    //             list.next = new ListNode(list1.val);
    //             list1 = list1.next;
    //         }
    //         list = list.next;
    //     }

    //     // 一个处理完了另一个还有没合并的，就全部合并
    //     if (list1 == null && list2 != null) {
    //         list.next = new ListNode(list2.val, list2.next);
    //     } else if (list2 == null && list1 != null) {
    //         list.next = new ListNode(list1.val, list1.next);
    //     }
        
    //     return res.next;
    // }
}

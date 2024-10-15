//23. 合并 K 个升序链表
//https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked

public class P23 {
    // 用递归类似归并排序的思想，但我一开始没想到怎么处理链表的归并
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    // 合并从 lists[i] 到 lists[j-1] 的链表
    private ListNode mergeKLists(ListNode[] lists, int i, int j) {
        int m = j - i;
        if (m == 0) {
            return null; // 注意输入的 lists 可能是空的
        }
        if (m == 1) {
            return lists[i]; // 无需合并，直接返回
        }
        ListNode left = mergeKLists(lists, i, i + m / 2); // 合并左半部分
        ListNode right = mergeKLists(lists, i + m / 2, j); // 合并右半部分
        return mergeTwoLists(left, right); // 合并两部分
    }

    // 21. 合并两个有序链表
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // 哨兵节点
        ListNode cur = dummy; // cur 指向新链表的末尾
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1; // 每次循环其实只将list1头节点加入新链表中
                list1 = list1.next;
            } else {
                cur.next = list2; // 同上
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
        return dummy.next;
    }

    // 暴力方法，毫无美感
    // public ListNode mergeKLists(ListNode[] lists) {
    //     List<ListNode> list = new ArrayList();
    //     for (ListNode node: lists) {
    //         while (node != null) {
    //             list.add(node);
    //             node = node.next;
    //         }
    //     }

    //     if (list.size() == 1) {
    //         return list.get(0);
    //     } else if (list.size() == 0) {
    //         return null;
    //     }
    //     //秀一手方法内部重写比较器
    //     Collections.sort(list, new Comparator<Object>() {
	// 		public int compare(Object o1, Object o2) {
	// 			ListNode n1 = (ListNode)o1;
    //             ListNode n2 = (ListNode)o2;
	// 			if (n1.val == n2.val) {
    //                 return 0;
    //             }
    //             return n1.val > n2.val ? 1 : -1;
	// 		}
    //     });
    //     ListNode head = new ListNode(list.get(0).val, list.get(1));
    //     for (int i = 1; i < list.size() - 1; i++) {
    //         list.get(i).next = list.get(i + 1);
    //     }

    //     return head;
    // }
}
//2.两数相加
//https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class P2 {
    //还得是递归做法，虽然我想不到。
    //我倒是想到了一个一个节点相加，可是觉得这样做太麻烦了，就转而走上了全部加起来的道路，一条路走到黑。。。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    /**
        返回两个链表相加的头部
     */
    public ListNode add(ListNode l1, ListNode l2, int bit) {
        if (l1 == null && l2 == null && bit == 0) {
            return null;
        }
        int val = bit;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(val % 10);
        node.next = add(l1, l2, val / 10);
        return node;
    }

    //------------------------------------------------------------------------------------
    // 过是过了，但是代码质量和性能都是逆天地垃圾，属于是落在坑里就不肯换方向了，但是可以学习BigInteger的使用方法。
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     // 测试用例太大了，还得转换为BigInteger
    //     BigInteger num1 = new BigInteger("0"), num2 = new BigInteger("0");
    //     BigInteger digit = new BigInteger("1");
    //     while (l1 != null && l1.next != null) {
    //         num1 = num1.add(digit.multiply(BigInteger.valueOf(l1.val))); // num1 += (long) l1.val * digit;
    //         l1 = l1.next;
    //         digit = digit.multiply(BigInteger.TEN); // digit *= 10;
    //     }
    //     if (l1 != null) {
    //         num1 = num1.add(digit.multiply(BigInteger.valueOf(l1.val)));// num1 += (long) l1.val * digit;
    //     }

    //     digit = BigInteger.ONE;
    //     while (l2 != null && l2.next != null) {
    //         num2 = num2.add(digit.multiply(BigInteger.valueOf(l2.val)));// num2 += (long) l2.val * digit;
    //         l2 = l2.next;
    //         digit = digit.multiply(BigInteger.TEN);// digit *= 10;
    //     }
    //     if (l2 != null) {
    //         num2 = num2.add(digit.multiply(BigInteger.valueOf(l2.val)));// num2 += (long) l2.val * digit;
    //     }

    //     //组装返回链表
    //     BigInteger sum = num1.add(num2);
    //     ListNode prevNode = new ListNode(0), lret = prevNode;
    //     while (sum.divide(BigInteger.TEN).compareTo(BigInteger.ZERO) > 0) { //sum / 10 > 0
    //         int val = sum.mod(BigInteger.TEN).intValue(); //sum % 10
    //         ListNode thisNode = new ListNode(val);
    //         prevNode.next = thisNode;
    //         prevNode = thisNode;
    //         sum = sum.divide(BigInteger.valueOf(10));// sum /= 10;
    //     }
    //     int val = sum.mod(BigInteger.TEN).intValue();
    //     ListNode thisNode = new ListNode(val);
    //     prevNode.next = thisNode;
    //     return lret.next;
    // }

    // -----------------------------------------------------------------------------
    // public static void main(String[] args) {
    //     int[] value1 = {1,1,1,1,1,1,1,1,1,1,1};
    //     int[] value2 = {1,1,1,1,1,1,1,1,1,1,1};
    //     ListNode l1 = createLinkedList(value1);
    //     ListNode l2 = createLinkedList(value2);
    //     printLinkedList(new P2().addTwoNumbers(l1, l2));
    // }

    // public static ListNode createLinkedList(int[] values) {
    //     if (values == null || values.length == 0) {
    //         return null;
    //     }

    //     ListNode dummy = new ListNode(0);
    //     ListNode current = dummy;

    //     for (int value : values) {
    //         current.next = new ListNode(value);
    //         current = current.next;
    //     }

    //     return dummy.next;
    // }

    // public static void printLinkedList(ListNode head) {
    //     ListNode current = head;

    //     while (current != null) {
    //         System.out.print(current.val + " ");
    //         current = current.next;
    //     }

    //     System.out.println();
    // }
}

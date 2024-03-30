//138. 随机链表的复制
//https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class P138 {
    //想到了要两次遍历，第二次再处理random，也想到要保存两个复制结点的关系，但map的key和value
    //分别是原结点和复制结点确实没想到，之样子完全可以对应两个链表的关系了
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap();
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);
        Node n = head.next;
        //先复制
        while (n != null) {
            Node copy = new Node(n.val);
            map.put(n, copy);
            n = n.next;
        }

        n = head;
        Node copy = copyHead;
        while (n != null) {
            //最精彩的两步，直接调用get方法获得对应的copy后的next和random节点
            copy.next = map.get(n.next);
            copy.random = map.get(n.random);
            copy = copy.next;
            n = n.next;
        }
        return copyHead;
    }
}

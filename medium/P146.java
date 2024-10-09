//146. LRU 缓存
//https://leetcode.cn/problems/lru-cache/description/

import java.util.HashMap;
import java.util.Map;

public class P146 {
    // 这个解法完全是模仿别人写的，但思路非常清晰
    // 没用各种封装好的类，用到了哈希+循环链表，哨兵结点。
    // 但题目可能想考你用双向链表
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map = new HashMap(); // 值储存结点的设计很巧妙
    Node dummpy = new Node(0, 0); // 哨兵结点
    int capacity;

    public P146(int capacity) {
        this.capacity = capacity;
        // 先造出循环链表
        dummpy.next = dummpy;
        dummpy.prev = dummpy;
    }
    
    public int get(int key) {
        Node n = getNode(key); // 此方法包括把它更新成最近使用过的结点
        return n == null ? -1 : n.value;
    }
    
    public void put(int key, int value) {
        Node n = getNode(key);
        if (n != null) {
            // 这里不需要更新map，因为map的value是Node对象，这一步已经更新它的值了
            n.value = value;
            return;
        }
        // 还没有缓存过这个
        Node newNode = new Node(key, value);
        pushToFront(newNode);
        map.put(key, newNode);
        if (map.size() > capacity) {
            Node lastNode = dummpy.prev; // 最久未使用，在末尾，也就是哨兵的前一个
            map.remove(lastNode.key); // 差点忘了这一步，而多做了删除尾节点方法的工作
            remove(lastNode);
        }
    }

    private Node getNode(int key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        // 还得把它更新成最近使用过的结点
        remove(node);
        pushToFront(node);
        return node;
    }

    private void remove(Node n) {
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }

    private void pushToFront(Node n) {
        n.next = dummpy.next;
        n.prev = dummpy;
        dummpy.next = n;
        n.next.prev = n;
    }
}

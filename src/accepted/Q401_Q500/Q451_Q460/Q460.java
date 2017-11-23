package accepted.Q401_Q500.Q451_Q460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem,
 * when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class Q460 {

    private int capacity, seq;
    private Map<Integer, Item> m;
    private PriorityQueue<Item> pq;

    private Q460(int capacity) {
        this.capacity = capacity;
        this.seq = 0;
        this.m = new HashMap<>();
        this.pq = new PriorityQueue<>((o1, o2) -> (o1.hitCount == o2.hitCount ? o1.seq - o2.seq : o1.hitCount - o2.hitCount));
    }

    public int get(int key) {
        if (!m.containsKey(key)) {
            return -1;
        }
        this.seq++;
        Item item = m.get(key);
        incrHitCount(item);
        return item.value;
    }

    public void set(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        this.seq++;

        if (m.containsKey(key)) {
            Item item = m.get(key);
            item.value = value;
            incrHitCount(item);
            return;

        } else if (m.size() == capacity) {
            Item leastUsedItem = pq.poll();
            m.remove(leastUsedItem.key);
        }

        Item item = new Item(key, value, this.seq, 1);
        m.put(key, item);
        pq.offer(item);
    }

    private void incrHitCount(Item item) {
        item.seq = this.seq;
        item.hitCount++;
        pq.remove(item);
        pq.offer(item);
    }

    public static void main(String[] args) {
        Q460 cache = new Q460(0 /* capacity */);

        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));    // returns 1
        cache.set(3, 3);    // evicts key 2
        System.out.println(cache.get(2));    // returns -1 (not found)
        System.out.println(cache.get(3));    // returns 3.
        cache.set(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));    // returns -1 (not found)
        System.out.println(cache.get(3));    // returns 3
        System.out.println(cache.get(4));    // returns 4
    }
}

class Item {
    int key;
    int value;
    int seq;
    int hitCount;

    Item(int key, int value, int seq, int hitCount) {
        this.key = key;
        this.value = value;
        this.seq = seq;
        this.hitCount = hitCount;
    }
}

class LFUCache {

    int capacity;
    Map<Integer, Integer> m;
    Map<Integer, Node> m2;
    Node head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.m = new HashMap<>();
        this.m2 = new HashMap<>();
        this.head = null;
    }

    public int get(int key) {
        if (!m.containsKey(key)) {
            return -1;
        }

        incrCount(key);
        return m.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (capacity == m.size() && !m2.containsKey(key)) {
            deleteOld();
        }
        m.put(key, value);

        if (!m2.containsKey(key)) {
            Node node = new Node(0);
            node.keys.add(key);

            if (head == null) {
                head = node;
            } else if (head.count > 0) {
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                head.keys.add(key);
            }
            m2.put(key, node);
        }

        incrCount(key);
    }

    private void deleteOld() {
        int oldKey = head.keys.iterator().next();
        head.keys.remove(oldKey);

        if (head.keys.size() == 0) {
            deleteNode(head);
        }

        m.remove(oldKey);
        m2.remove(oldKey);
    }


    private void incrCount(int key) {
        Node node = m2.get(key);
        node.keys.remove(key);

        Node next = node.next;
        if (next == null || next.count != node.count + 1) {
            next = new Node(node.count + 1);

            next.prev = node;
            next.next = node.next;

            if (node.next != null) {
                node.next.prev = next;
            }
            node.next = next;
        }

        if (node.keys.size() == 0) {
            deleteNode(node);
        }

        next.keys.add(key);
        m2.put(key, next);
    }

    private void deleteNode(Node node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

}

class Node {

    int count;
    Set<Integer> keys;
    Node prev;
    Node next;

    public Node(int count) {
        this.count = count;
        this.keys = new LinkedHashSet<>();
        this.prev = null;
        this.next = null;
    }
}

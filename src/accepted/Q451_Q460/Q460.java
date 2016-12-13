package accepted.Q451_Q460;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
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
        System.out.println(cache.get(1)  );    // returns 1
        cache.set(3, 3);    // evicts key 2
        System.out.println(cache.get(2)  );    // returns -1 (not found)
        System.out.println(cache.get(3) );    // returns 3.
        cache.set(4, 4);    // evicts key 1.
        System.out.println(cache.get(1)  );    // returns -1 (not found)
        System.out.println(cache.get(3)  );    // returns 3
        System.out.println(cache.get(4)  );    // returns 4
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

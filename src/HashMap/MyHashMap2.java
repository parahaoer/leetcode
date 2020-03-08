package HashMap;


public class MyHashMap2 {
    /** Initialize your data structure here. */
    ListNode[] nodes = new ListNode[10000];
    public MyHashMap2() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = idx(key);
        if(nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        ListNode pre = find(nodes[i], key);
        if(pre.next != null) pre.next.value = value;
        else pre.next = new ListNode(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = idx(key);
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = idx(key);
        ListNode node = find(nodes[i], key);
        if(node != null && node.next != null)
            node.next = node.next.next;
    }

    public int idx(int key) {
        return key % nodes.length;
    }

    public ListNode find(ListNode bucket, int key) {
        ListNode node = bucket;
        ListNode pre = null;
        while(node != null && node.key != key) {
            pre = node;
            node = node.next;
        }
        return pre;
    }


    class ListNode {
        int key, value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap2 hashMap = new MyHashMap2();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)
    }
}

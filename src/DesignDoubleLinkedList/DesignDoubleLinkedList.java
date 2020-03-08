package DesignDoubleLinkedList;
class DesignDoubleLinkedList {

    class Node {
        int data;
        Node next;
        Node pre;
        Node(int data, Node pre,Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    Node head;
    Node tail;
    int len;
    /** Initialize your data structure here. */
    public DesignDoubleLinkedList() {
        head = null;
        tail = head;
        len = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index>-1 && index<len) {
            Node iNode = head;
            for(int i=0; i<index; i++) {

                iNode = iNode.next;
            }
            return iNode.data;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val, null, head);
        head = cur;
        if(len==0) tail = cur;
        len++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(len==0) {
            addAtHead(val);
            return;
        }
        Node cur = new Node(val, tail,null);
        tail.next = cur;
        tail = cur;
        len++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index==0) {
            addAtHead(val);
            return;
        }
        if(index==len) {
            addAtTail(val);
            return;
        }
        if(index>0 && index<len) {
            Node cur = new Node(val, null,null);
            Node pre = head;
            for(int i=0; i<index-1; i++) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next.pre = cur;
            cur.pre = pre;
            pre.next = cur;
            len++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(index==0 && len==1) {
            head =null;
            tail =null;
            len--;
        }

        if(index>-1 && index<len) {

            Node iNode =head;
            for(int i=0; i<index; i++) {
                iNode = iNode.next;
            }
            iNode.next.pre = iNode.pre;
            iNode.pre.next = iNode.next;
            len--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
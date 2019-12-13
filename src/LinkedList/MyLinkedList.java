package LinkedList;

class MyLinkedList {

    class Node {
        int val;
        Node next;
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    Node tail;
    //记录链表的长度
    int len =0;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 || index>=len) return -1;
        Node cur = head;
        if(index==0) return cur.val;
        for(int j=0; j<index;j++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val, head);
        head = cur;

        //当给链表插入第一个元素时，让链首和链尾都指向第一个元素，从而形成链表（必要）
        if( len == 0) {
            tail = head;
        }
        len++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(len == 0) {
            addAtHead(val);
            return;
        }
        Node cur =new Node(val, null);
        tail.next = cur;
        tail = cur;


        len++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index>=0) {
            addAtHead(val);
            return;
        }
        //当index大于链表长度时，在链尾插入元素
        if(index >= len) {
            addAtTail(val);
            return;
        }

        Node cur = new Node(val,null);
        Node pre = head;
        for(int i=0; i<index-1; i++ ){
            pre = pre.next;
        }
        //pre指向index位置上一个的节点
        cur.next = pre.next;
        pre.next = cur;

        len++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(index==0 && len==1) {
            head = null;
            tail = head;
            return;
        }

        if(index>=len) return;
        Node pre = head;
        for(int i=0; i<index-1; i++){
            pre = pre.next;
        }
        //pre指向index前一个节点
        pre.next = pre.next.next;

        len--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(0,2);
//        System.out.println(myLinkedList.get(0));
//        myLinkedList.addAtIndex(1,2);
        myLinkedList.deleteAtIndex(0);
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

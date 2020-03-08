package DesignLinkedList;

public class DesignLinkedList {

    SingleNode head;
    SingleNode tail;
    int len;
    /** Initialize your data structure here. */
    public DesignLinkedList() {
        head = null;
        tail = head;
        len = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index>-1 && index<len) {
            SingleNode iSingleNode = head;
            for(int i=0; i<index; i++) {

                iSingleNode = iSingleNode.next;
            }
            return iSingleNode.data;
        }
        return 0;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new Node will be the first node of the linked list. */
    public void addAtHead(int val) {
        SingleNode cur = new SingleNode(val, head);
        head =cur;
        if(len==0) tail = cur;
        len++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(len==0) {
            addAtHead(val);
            return;
        }
        SingleNode cur = new SingleNode(val, null);
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
            SingleNode cur = new SingleNode(val,null);
            SingleNode pre = head;
            for(int i=0; i<index-1; i++) {
                pre = pre.next;
            }
            cur.next = pre.next;
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

            //删除头结点
            if(index ==0) {
                head = head.next;
            }

            SingleNode pre =head;
            for(int i=0; i<index-1; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            //删除尾节点,需要将尾指针指向尾节点前一个节点。需要放在len--上面，因为会改变len的值
            if(index == len-1) {
                tail = pre;
            }
            len--;
        }
    }

    public static void main(String[] args) {
        DesignLinkedList designLinkedList = new DesignLinkedList();
        designLinkedList.addAtHead(8);
        designLinkedList.deleteAtIndex(0);
//        designLinkedList.get(1);
//        designLinkedList.addAtTail(81);
//        designLinkedList.deleteAtIndex(2);
//        designLinkedList.addAtHead(26);
//        designLinkedList.deleteAtIndex(2);
//        designLinkedList.get(1);
//        designLinkedList.addAtTail(24);
//        designLinkedList.addAtHead(15);
//        designLinkedList.addAtTail(0);
//        designLinkedList.addAtTail(13);
//        designLinkedList.addAtTail(1);
//        designLinkedList.addAtIndex(6,33);
//        designLinkedList.get(6);
//        designLinkedList.addAtIndex(2,91);
//        designLinkedList.addAtHead(82);
//        designLinkedList.deleteAtIndex(6);
//        designLinkedList.addAtIndex(4,11);
//        designLinkedList.addAtHead(3);
//        designLinkedList.addAtIndex(7,14);
//        designLinkedList.deleteAtIndex(1);
//        designLinkedList.get(6);
//        designLinkedList.addAtTail(99);
//        designLinkedList.deleteAtIndex(11);
//        designLinkedList.deleteAtIndex(7);
//        designLinkedList.addAtTail(5);
//        designLinkedList.addAtTail(92);
//        designLinkedList.addAtIndex(7,92);
//        designLinkedList.addAtHead(57);
//        designLinkedList.get(2);
//        designLinkedList.get(6);
//        designLinkedList.addAtTail(39);
//        designLinkedList.addAtTail(51);
//        designLinkedList.addAtTail(3);
//        designLinkedList.addAtTail(22);
//        designLinkedList.addAtIndex(5,26);
//        designLinkedList.addAtIndex(9,52);
//        designLinkedList.addAtHead(69);
//        designLinkedList.addAtIndex(5,58);
//        designLinkedList.addAtTail(79);
//        designLinkedList.addAtHead(7);
//        designLinkedList.addAtHead(41);
//        designLinkedList.addAtHead(33);
//        designLinkedList.addAtHead(88);
//        designLinkedList.addAtHead(44);
//        designLinkedList.addAtHead(8);
//        designLinkedList.addAtTail(72);
//        designLinkedList.addAtHead(93);
//        designLinkedList.deleteAtIndex(18);
//        designLinkedList.addAtHead(1);
//        designLinkedList.get(9);
//        designLinkedList.addAtHead(46);
//        designLinkedList.get(9);
//        designLinkedList.addAtHead(92);
//        designLinkedList.addAtHead(71);
//        designLinkedList.addAtHead(69);
//        designLinkedList.addAtIndex(11,54);
//        designLinkedList.deleteAtIndex(27);
//        designLinkedList.addAtTail(83);
//        designLinkedList.deleteAtIndex(12);
//        designLinkedList.get(20);
//        designLinkedList.addAtIndex(19,97);
//        designLinkedList.addAtHead(77);
//        designLinkedList.addAtTail(36);
//        designLinkedList.deleteAtIndex(3);
//        designLinkedList.addAtHead(35);
//        designLinkedList.addAtIndex(16,68);
//        designLinkedList.deleteAtIndex(22);
//        designLinkedList.deleteAtIndex(36);
//        designLinkedList.deleteAtIndex(17);
//        designLinkedList.addAtHead(62);
//        designLinkedList.addAtTail(89);
//        designLinkedList.addAtTail(61);
//        designLinkedList.addAtHead(6);
//        designLinkedList.addAtTail(92);
//        designLinkedList.addAtIndex(28,69);
//        designLinkedList.deleteAtIndex(23);
//        designLinkedList.deleteAtIndex(28);
//        designLinkedList.addAtIndex(7,4);
//        designLinkedList.addAtHead(0);
//        designLinkedList.addAtHead(24);
//        designLinkedList.addAtTail(52);
//        designLinkedList.get(1);
//        designLinkedList.addAtIndex(23,3);
//        designLinkedList.get(7);
//        designLinkedList.addAtHead(6);
//        designLinkedList.addAtHead(68);
//        designLinkedList.addAtHead(79);
//        designLinkedList.addAtIndex(45,90);
//        designLinkedList.addAtIndex(41,52);
//        designLinkedList.get(28);
//        designLinkedList.addAtHead(25);
//        designLinkedList.get(9);
//        designLinkedList.get(32);
//        designLinkedList.addAtTail(11);
//        designLinkedList.addAtHead(90);
//        designLinkedList.addAtHead(24);
//        designLinkedList.addAtTail(98);
//        designLinkedList.addAtTail(36);
//        designLinkedList.get(34);
//        designLinkedList.addAtTail(26);




    }
}

class SingleNode {
    int data;
    SingleNode next;
    SingleNode(int data, SingleNode next) {
        this.data = data;
        this.next = next;
    }
}

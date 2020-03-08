package LinkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        fast = fast.next.next;
        slow = slow.next;

        while(fast != null && fast != slow) {
            if(fast.next != null) fast = fast.next.next;
            // 当 fast.next == null时， fast指向链表的最后一个元素。如果不返回， 循环会继续运行下去，直到fast == slow时退出循环
            else
                return false;
            slow = slow.next;
        }


        return fast == slow ? true : false;
    }
}


class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
     val = x;
      next = null;
 }
}
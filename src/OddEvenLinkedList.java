public class OddEvenLinkedList<main> {

    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.next!= null) {
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = tmp;
            cur = cur.next;
            pre = pre.next;
        }
        return head;
    }

    public ListNode createList(){
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList obj = new OddEvenLinkedList();
        ListNode head = obj.createList();
        ListNode listNode = obj.oddEvenList(head);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode h1 = l1;
//        ListNode h2 = l2;
//        ListNode head1 = h1;
//        ListNode head2 = h2;
//        while(head1.next!=null || head2.next !=null) {
//            head2.next = head1.next;
//            head1.next = head2;
//            head1 = h1.next;
//            head2 = h2.next;
//        }
//        return l1;
//        ListNode cur = null;
        ListNode dummy  = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
//            if(l1.val >l2.val) {
//                cur.next = l2;
//                cur = cur.next;
//                cur.next = l1;
//                cur = cur.next;
//
//            } else {
//                cur.next = l1;
//                cur = cur.next;
//                cur.next = l2;
//                cur = cur.next;
//            }
//            l1 = l1.next;
//            l2 = l2.next;

            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
//        if(cur.next == l1) {
//            cur.next = l1;
//        } else {
//            cur.next = l2;
//        }
        cur.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    public ListNode createList1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        return  node1;
    }

    public ListNode createList2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        return  node1;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = mergeTwoSortedLists.createList1();
        ListNode l2 = mergeTwoSortedLists.createList2();
        mergeTwoSortedLists.mergeTwoLists(l1, l2);
    }
}

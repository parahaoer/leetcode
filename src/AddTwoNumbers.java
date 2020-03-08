public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int jinwei = 0;
        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + jinwei;
            if(val>=10) {
                val = val-10;
                jinwei = 1;
            }

            cur.next = new ListNode(val);
            cur = cur.next;
            if(l1.next == null && l2.next == null) {
                cur.next = new ListNode(1);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}

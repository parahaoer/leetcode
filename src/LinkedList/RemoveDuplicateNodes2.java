/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet();
        ListNode q = new ListNode(-1);
        q.next = head;
        ListNode p = head;

        while(p != null) {
            if(set.contains(p.val)) {
                if(p.next !=null) {
                    p.val = p.next.val;
                    p.next = p.next.next;
                    continue;
                } else {
                    q.next = null;
                }
            } else {
                set.add(p.val);
            }
            p = p.next;
            q = q.next;
        }
        return head;
    }
}
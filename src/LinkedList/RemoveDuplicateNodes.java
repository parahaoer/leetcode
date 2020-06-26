/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
    双指针
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) return null;

        ListNode pos = head;
        
        Set<Integer> set = new HashSet();
        set.add(pos.val);
        while( pos.next != null) {


            ListNode cur = pos.next;
            if(set.contains(cur.val)) {
                pos.next = cur.next;
            } else {
                set.add(cur.val);
                pos = pos.next;
            }

            
        }
        return head;

    }
}
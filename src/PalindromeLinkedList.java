import java.util.Stack;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack s = new Stack();
        s.push(head.val);
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            s.push(slow.val);
        }
        if(fast.next == null) s.pop();
        while(slow.next != null) {
            slow = slow.next;
            int tmp = (int) s.peek();
            s.pop();
            if( tmp != slow.val) return false;
        }
        return true;
    }

    public  ListNode createList(){
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);

        head.next = head2;
        head2.next = null;

        return head;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode head = palindromeLinkedList.createList();
        System.out.println(palindromeLinkedList.isPalindrome(head));

    }

}

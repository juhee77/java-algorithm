package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class DoubleANumber_2816 {
    public ListNode doubleIt(ListNode head) {
        ListNode reversedHead = reverseLinkedList(head);
        int carry = 0;
        ListNode prev = null;
        ListNode curr = reversedHead;
        while (curr != null) {
            int doubledValue = 2 * curr.val + carry;
            curr.val = doubledValue % 10;
            carry = doubledValue / 10;
            prev = curr;
            curr = curr.next;
        }

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return reverseLinkedList(reversedHead);
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
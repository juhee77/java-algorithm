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
class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        
        ListNode beforeNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (beforeNode.val != nextNode.val) {
                beforeNode.next = nextNode;
                beforeNode = beforeNode.next;
            }
            nextNode = nextNode.next;
        }
        beforeNode.next = null;
        return head;
    }
}
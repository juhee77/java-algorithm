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
class MergeNodesinBetweenZeros_2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode();
        ListNode hold = ans;
        int temp = 0;
        while (head.next != null) {
            if (head.val == 0) {
                if (temp != 0) {
                    hold.next = new ListNode(temp);
                    hold = hold.next;
                    temp = 0;
                }
            } else {
                temp += head.val;
            }
            head = head.next;
        }

        if (temp != 0) {
            hold.next = new ListNode(temp);
        }

        return ans.next;
    }
}
package leetcode;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode tempHead = front;

        while (tempHead != null) {
            int sum = 0;

            ListNode temptempHead = tempHead.next;
            while (temptempHead != null) {
                sum += temptempHead.val;

                if (sum == 0) {
                    tempHead.next = temptempHead.next;
                }

                temptempHead = temptempHead.next;
            }
            tempHead = tempHead.next;
        }

        return front.next;
    }
}

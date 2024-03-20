package leetcode;

public class MergeInBetweenLinkedLists {
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = null;
        ListNode next = null;
        ListNode now = list1;
        for (int i = 0; i < a; i++) {
            prev = now;
            now = now.next;
        }

        for (int i = a; i <= b; i++) {
            next = now.next;
            now = now.next;
        }

        prev.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = next;
        return list1;
    }
}

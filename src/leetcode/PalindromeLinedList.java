package leetcode;

public class PalindromeLinedList {
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
//    public boolean isPalindrome(ListNode head) {
//        StringBuilder sb = new StringBuilder();
//
//        while (head != null) {
//            sb.append(head.val);
//            head = head.next;
//        }
//
//        return sb.toString().contentEquals(sb.reverse());
//    }
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();

        ListNode tail = head;
        ListNode now = new ListNode(0);
        int cnt = 0;
        while (tail != null) {
            cnt++;
            ListNode hold = now;
            now = new ListNode(tail.val);
            now.next = hold;

            tail = tail.next;
        }

        for (int i = 0; i <= cnt / 2; i++) {
            if (head.val != now.val) return false;

            now = now.next;
            head = head.next;
        }
        return true;
    }
}

package leetcode;

public class DeleteTheMiddleNodeOfALinkedList_2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) return null;
        ListNode now = head;
        int count = 0;
        while (now != null) {
            now = now.next;
            count++;
        }

        ListNode real = head;

        for (int i = 0; i < count / 2 - 1; i++) {
            real = real.next;
        }

        real.next = real.next.next;
        return head;
    }
}

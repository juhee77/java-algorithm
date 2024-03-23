package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RecorderList {
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
    public void reorderList(ListNode head) {
        List<Integer> total = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            total.add(temp.val);
            temp = temp.next;
        }

        int lf = 0, rt = total.size() - 1;
        ListNode hhole = new ListNode(0);
        ListNode hold = hhole;
        System.out.println(total);
        for (int j = 0; j < total.size() / 2 + 1; j++) {
            System.out.println(total.get(lf) + " " + total.get(rt));
            hold.next = new ListNode(total.get(lf++));
            hold = hold.next;
            hold.next = new ListNode(total.get(rt--));
            hold = hold.next;
        }

        head = hhole.next;
    }
}

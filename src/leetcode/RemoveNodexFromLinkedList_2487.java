package leetcode;

import java.util.ArrayList;
import java.util.List;

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
class RemoveNodexFromLinkedList_2487 {
    public ListNode removeNodes(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode now = head;
        while (now != null) {
            arr.add(now.val);
            now = now.next;
        }

        int hold = 0;
        for (int i = arr.size() - 1; 0 <= i; i--) {
            if (hold > arr.get(i)) {
                arr.remove(i);
            } else {
                hold = arr.get(i);
            }
        }

        ListNode ans = new ListNode(0);
        ListNode next = ans;
        for (int i = 0; i < arr.size(); i++) {
            next.next = new ListNode(arr.get(i));
            next = next.next;
        }
        return ans.next;
    }
}
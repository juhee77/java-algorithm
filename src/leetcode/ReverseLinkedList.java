package leetcode;

import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        //find endNode
        ListNode end = head;
        Stack<Integer> stack = new Stack<>();

        while (end != null) {
            stack.push(end.val);
            end = end.next;
        }

        ListNode ans = new ListNode(0);
        ListNode hold = ans;
        while (!stack.isEmpty()) {
            hold.next = new ListNode(stack.pop());
            hold = hold.next;
        }
        return ans.next;

    }
}

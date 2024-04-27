package leetcode;

import java.util.Stack;

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
class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Nums = getNum(l1);
        Stack<Integer> l2Nums = getNum(l2);

        Stack<Integer> s = new Stack<>();

        int remain = 0;
        while (!l1Nums.isEmpty() && !l2Nums.isEmpty()) {
            int temp1 = l1Nums.pop();
            int temp2 = l2Nums.pop();
            int temp = (remain + temp1 + temp2);
            s.push(temp % 10);
            remain = temp / 10;
        }

        remain = addSingleListNode(l1Nums, s, remain);
        remain = addSingleListNode(l2Nums, s, remain);

        ListNode ans = new ListNode();
        ListNode hold = ans;
        if (remain != 0) {
            s.push(remain);
        }

        while (!s.isEmpty()) {
            ListNode tempNext = new ListNode(s.pop());
            hold.next = tempNext;
            hold = tempNext;
        }

        return ans.next;
    }

    private static Stack<Integer> getNum(ListNode l1) {
        Stack<Integer> nums = new Stack<>();
        while (l1 != null) {
            nums.add(l1.val);
            l1 = l1.next;
        }
        return nums;
    }

    private static int addSingleListNode(Stack<Integer> nums, Stack<Integer> s, int remain) {
        while (!nums.isEmpty()) {
            int temp = (remain + nums.pop());
            s.push(temp % 10);
            remain = temp / 10;
        }
        return remain;
    }
}
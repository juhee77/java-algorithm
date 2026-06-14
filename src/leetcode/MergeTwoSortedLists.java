package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedLists {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> all = new ArrayList<>();
        while (list1 != null) {
            all.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            all.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(all);
        if (all.size() == 0) return null;

        ListNode ans = new ListNode();
        ListNode now = ans;
        for (int i = 0; i < all.size(); i++) {
            now.val = all.get(i);

            if (i + 1 < all.size()) {
                now.next = new ListNode();
                now = now.next;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solver = new MergeTwoSortedLists();

        // TC1
        test(
                solver,
                createList(1, 2, 4),
                createList(1, 3, 4),
                "TC1"
        );

        // TC2 - 한쪽이 비어있는 경우
        test(
                solver,
                null,
                createList(0),
                "TC2"
        );

        // TC3 - 둘 다 비어있는 경우
        test(
                solver,
                null,
                null,
                "TC3"
        );

        // TC4 - 길이가 다른 경우
        test(
                solver,
                createList(1, 2, 3, 10),
                createList(4, 5),
                "TC4"
        );

        // TC5 - 중복이 많은 경우
        test(
                solver,
                createList(1, 1, 1),
                createList(1, 1, 1),
                "TC5"
        );

        // TC6 - 음수 포함
        test(
                solver,
                createList(-10, -5, 0),
                createList(-7, -3, 2),
                "TC6"
        );
    }

    private static void test(
            MergeTwoSortedLists solver,
            ListNode list1,
            ListNode list2,
            String testName
    ) {
        System.out.println("==== " + testName + " ====");

        ListNode result = solver.mergeTwoLists(list1, list2);

        printList(result);
        System.out.println();
    }

    private static ListNode createList(int... values) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);

            if (node.next != null) {
                System.out.print(" -> ");
            }

            node = node.next;
        }

        System.out.println();
    }
}

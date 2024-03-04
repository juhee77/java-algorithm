package leetcode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        ListNode ans = head;
        for (int i = 0; i < size - n - 1; i++) {
            ans = ans.next;
        }

        if (size == n) //head삭제
            return head = ans.next;

        ans.next = ans.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();
        System.out.println(removeNthNodeFromEndofList.removeNthFromEnd(ListNode.arrayToLinkedList(new int[]{1, 2, 3, 4, 5}),2));
        System.out.println(removeNthNodeFromEndofList.removeNthFromEnd(ListNode.arrayToLinkedList(new int[]{1}),1));
        System.out.println(removeNthNodeFromEndofList.removeNthFromEnd(ListNode.arrayToLinkedList(new int[]{1,2}),1));
    }
}

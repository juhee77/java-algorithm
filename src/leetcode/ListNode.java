package leetcode;

public class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next=next;}

    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return val +" " + ((next==null)?"":next);
    }
}
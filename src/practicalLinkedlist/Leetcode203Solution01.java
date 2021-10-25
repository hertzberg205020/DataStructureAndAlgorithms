package practicalLinkedlist;

public class Leetcode203Solution01 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 6, 3, 4, 5, 6});
        System.out.println(head);
        ListNode res = (new Leetcode203Solution01().removeElements(head, 6));
        System.out.println(res);
    }
}

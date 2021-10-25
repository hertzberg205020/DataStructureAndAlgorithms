package practicalLinkedlist;

public class Leetcode203Solution02 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 6, 3, 4, 5, 6});
        System.out.println(head);
        ListNode res = (new Leetcode203Solution02().removeElements(head, 6));
        System.out.println(res);
    }
}

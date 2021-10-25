package practicalLinkedlist;
//刪除鏈表中節點val為指定值的所有節點
public class Leetcode203Solution {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call remove: " + val + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + null);
            return null;
        }
        ListNode res = removeElements(head.next, val, depth+1);
        System.out.print(depthString);
        System.out.println("After remove " + val + " : " + res);
        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return :" + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        if (depth != 0) {
            res.append(String.format("%02d", depth));
        }
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(new int[] {1, 2, 6, 3, 4, 5, 6});
        System.out.println(head);
        ListNode res = (new Leetcode203Solution().removeElements(head, 6, 0));
        System.out.println(res);
    }
}

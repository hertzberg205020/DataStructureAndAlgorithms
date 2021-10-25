package practicalQueue;

public class LinkedlistQueue<E> implements Queue<E>{
    private class Node {
        public E e;
        public Node next;
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head, tail;
    private int size;

    public LinkedlistQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    //從tail加入元素複雜度為O(1)刪除元素為O(n)，從haed加入或刪除元素複雜度皆為O(1)
    public void enqueue(E e) {
        if (size == 0) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deque() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot deque from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next =null;
        if (head == null) {
            tail =null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: head: ");
        Node cur = head;
        while (cur != null) {
            res.append(cur);
            res.append("->");
            cur = cur.next;
        }
        res.append("null tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedlistQueue<Integer> queue = new LinkedlistQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.deque();
                System.out.println(queue);
            }
        }
    }
}

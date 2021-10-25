package practicalLinkedlist;

import javafx.util.Pair;

public class LinkedListR<E> {
    private class Node {
        public E val;
        public Node next;
        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }
        public Node(E val) {
            this(val, null);
        }
        public Node() {
            this(null, null);
        }
        public String toString() {
            return val.toString();
        }
    }
    private Node head;
    private int size;
    public LinkedListR() {
        head = null;
        size = 0;
    }
    public LinkedListR(E[] arr) {
        size = arr.length;
        head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        return get(head, index);
    }

    private E get(Node head, int index) {
        if (index == 0) {
            return head.val;
        }
        return get(head.next, index-1);
    }
    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size-1);
    }

    public void add(int index, E val) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        head = add(head, index, val);
        size++;
    }

    private Node add(Node head, int index, E val) {
        if (index == 0) {
            return new Node(val, head);
        }
        head.next = add(head.next, index-1, val);
        return head;
    }
    public void addFirst(E val) {
        add(0, val);
    }
    public void addLast(E val) {
        add(size, val);
    }
    public boolean contains(E val) {
         return contains(head, val);
    }
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        size--;
        Pair<Node,E> res = remove(head, index);
        head = res.getKey();
        return res.getValue();
    }

    private Pair<Node, E> remove(Node head, int index) {
        if (index == 0) {
            return new Pair<Node, E>(head.next, head.val);
        }
        Pair<Node, E> res = remove(head.next, index-1);
        head.next = res.getKey();
        return new Pair<>(head, res.getValue());
    }
    public void removeElement(E val) {
        head = removeElement(head, val);
    }
    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size-1);
    }

    private Node removeElement(Node head, E val) {
        if (head == null) {
            return null;
        }
        if (head.val.equals(val)) {
            size--;
            return head.next;
        }
        head.next = removeElement(head.next, val);
        return head;
    }

    private boolean contains(Node head, E val) {
        if (head == null) {
            return false;
        }
        return head.val.equals(val) || contains(head.next, val);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 5, 5, 4, 7};
        LinkedListR<Integer> list = new LinkedListR<>(arr);
        System.out.println(list);
        System.out.println(list.contains(5));
        System.out.println(list.remove(2));
        System.out.println(list);
        list.removeElement(5);
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}

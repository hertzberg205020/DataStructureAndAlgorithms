package practicalLinkedlist;

public class Linkedlist<E> {
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
        public String toString() {
            return e.toString();
        }
    }
    private int size;
    private Node dummyHead;

    public Linkedlist() {
        dummyHead = new Node();
        size = 0;
    }
    public Linkedlist(E[] arr) {
        dummyHead = new Node();
        Node prev = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            prev.next = new Node(arr[i]);
            prev = prev.next;
        }
        size = arr.length;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(int index, E e) {
        if (index < 0 || index >size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }
    public void addFirst(E e) {
        add(0, e);
    }
    public void addLast(E e) {
        add(size-1, e);
    }
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }
    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size-1);
    }
    public void removeElement(E e) {
        Node prev = dummyHead;
        while(!(prev.next.e.equals(e)) && prev.next != null) {
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i =0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size-1);
    }
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur !=null && !(cur.e.equals(e))) {
            cur = cur.next;
        }
        return cur == null ? false : true;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;

        while (cur != null) {
            res.append(cur);
            res.append("->");
            cur= cur.next;
        }
        res.append("null");
        return res.toString();
    }

    public static void main(String[] args) {
//        Linkedlist<Integer> list = new Linkedlist<>();
//        for (int i = 0; i < 10; i++) {
//            list.addFirst(i);
//        }
        Integer[] arr = {1, 2, 3, 4, 5};
        Linkedlist<Integer> list = new Linkedlist<>(arr);
        System.out.println(list);
//        list.removeElement(5);
//        System.out.println(list);
//        System.out.println(list.getSize());
    }
}

package practicalStack;

import practicalLinkedlist.Linkedlist;

public class LinkedlistStack<E> implements Stack<E> {
    private Linkedlist<E> list;
    public LinkedlistStack() {
        list = new Linkedlist<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: Top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedlistStack<Integer> stack = new LinkedlistStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}

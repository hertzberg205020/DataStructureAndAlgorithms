package binarysearchtree;

import practicalLinkedlist.Linkedlist;

import java.util.ArrayList;

public class LinkedListSet <E> implements Set<E> {
    private Linkedlist<E> list;
    public LinkedListSet() {
        list = new Linkedlist<>();
    }
    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    public static void main(String[] args) {
        System.out.println("A Tale of Two Cities");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt", words1);
        System.out.println("Total words: " + words1.size());
        LinkedListSet<String> set1 = new LinkedListSet<>();
        for(String word : words1) {
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());
        System.out.println();

        System.out.println("Pride and Prejudice");

        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", words2);
        System.out.println("Total words: " + words2.size());
        LinkedListSet<String> set2 = new LinkedListSet<>();
        for(String word : words1) {
            set2.add(word);
        }
        System.out.println("Total different words: " + set2.getSize());
    }
}

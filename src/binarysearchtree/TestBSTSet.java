package binarysearchtree;

import java.util.ArrayList;

public class TestBSTSet {
    public static void main(String[] args) {
        System.out.println("A Tale of Two Cities");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words1)) {
            System.out.println("Total words: " + words1.size());
            BSTSet<String> set1 = new BSTSet<>();
            for(String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());
            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word : words1) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}

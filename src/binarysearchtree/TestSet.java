package binarysearchtree;

import java.util.ArrayList;

public class TestSet {
    public static void main(String[] args) {
        String fileName = "a-tale-of-two-cities.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, fileName);
        System.out.println("BST Set: " + time1 + " s");
        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, fileName);
        System.out.println("LinkedList Set: " + time2 + " s");
    }

    private static double testSet(Set<String> set, String fileName) {
        long startTime = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();

        if(FileOperation.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());
            for(String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}

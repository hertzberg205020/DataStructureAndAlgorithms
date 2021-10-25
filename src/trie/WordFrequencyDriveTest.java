package trie;

import binarysearchtree.FileOperation;
import map.BSTMap;

import java.util.ArrayList;

public class WordFrequencyDriveTest {
    public static void main(String[] args) {
        BSTMap<String, Integer> bstMap = new BSTMap<>();


        System.out.println("pride-and-prejudice.txt");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            System.out.println("BSTMap");
            long startTime = System.nanoTime();
            for(String word : words) {
                if (bstMap.contains(word)) {
                    bstMap.set(word, bstMap.get(word) + 1);
                } else {
                    bstMap.add(word, 1);
                }
            }
            System.out.println("Total different words: " + bstMap.getSize());
            System.out.println("Frequency of Pride: " + bstMap.get("pride"));
            System.out.println("Frequency of Prejudice: " + bstMap.get("prejudice"));
            bstMap.remove("pride");
            bstMap.remove("prejudice");
            System.out.println("Frequency of Pride: " + bstMap.get("pride"));
            System.out.println("Frequency of Prejudice: " + bstMap.get("prejudice"));
            long endTime = System.nanoTime();
            double time = (endTime-startTime) / 1000000000.0;
            System.out.println("Time: " + time);
            System.out.println();
            // ---
            System.out.println("Trie");
            startTime = System.nanoTime();
            WordFrequency trie = new WordFrequency();
            for(String word : words) {
                trie.insert(word);
            }
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Frequency of Pride: " + trie.getFrequency("pride"));
            System.out.println("Frequency of Prejudice: " + trie.getFrequency("prejudice"));
            trie.remove("pride");
            trie.remove("prejudice");
            System.out.println("Frequency of Pride: " + trie.getFrequency("pride"));
            System.out.println("Frequency of Prejudice: " + trie.getFrequency("prejudice"));
            System.out.println("Total different words: " + trie.getSize());
            endTime = System.nanoTime();
            time = (endTime-startTime) / 1000000000.0;
            System.out.println("Time: " + time);
        }

    }
}

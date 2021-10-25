package hashtable;

import avlTree.AVLTree;
import binarysearchtree.FileOperation;
import map.BSTMap;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total word: " + words.size());

            // Test BST
            long startTime = System.nanoTime();
            BSTMap<String, Integer> bstMap = new BSTMap<>();
            for(String word : words) {
                if(bstMap.contains(word)) {
                    bstMap.set(word, bstMap.get(word) + 1);
                } else {
                    bstMap.add(word, 1);
                }
            }
            for(String word : words) {
                bstMap.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " sec");

            // Test AVL
            startTime = System.nanoTime();
            AVLTree<String, Integer> avl = new AVLTree<>();
            for(String word : words) {
                if(avl.contains(word)) {
                    avl.set(word, avl.get(word) + 1);
                } else {
                    avl.add(word, 1);
                }
            }
            for(String word : words) {
                avl.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " sec");

            // Test HashTable
            startTime = System.nanoTime();
            HashTable<String, Integer> ht = new HashTable<>();
//            HashTable<String, Integer> ht = new HashTable<>(131071);
            for(String word : words) {
                if(ht.contains(word)) {
                    ht.set(word, ht.get(word) + 1);
                } else {
                    ht.add(word, 1);
                }
            }
            for(String word : words) {
                ht.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " sec");
        }
    }
}

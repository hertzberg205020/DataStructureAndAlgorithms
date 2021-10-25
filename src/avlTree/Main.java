package avlTree;

import binarysearchtree.FileOperation;
import map.BSTMap;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total word: " + words.size());
            // 因為BST退化成linked list 所以要調整stack大小，否則會報錯
            // -Xss20m
            // https://stackoverflow.com/questions/3700459/how-to-increase-the-java-stack-size

            Collections.sort(words);
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
        }
    }
}

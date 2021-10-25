package map;

import java.util.ArrayList;

public class TestMapMain {
    public static double testMap(Map<String, Integer> map, String fileName) {
        long startTime = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(fileName, words)) {
            System.out.println("Total word: " + words.size());

            for(String word : words) {
                if(map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE:" + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        long endTime = System.nanoTime();
        double time = (endTime-startTime) / 1000000000.0;
        return time;
    }

    public static void main(String[] args) {
        String fileName = "pride-and-prejudice.txt";
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, fileName);
        System.out.println("BSTMap: " + time1 + " s");

        System.out.println();

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time2 = testMap(avlMap, fileName);
        System.out.println("avlMap: " + time2 + " s");
    }
}

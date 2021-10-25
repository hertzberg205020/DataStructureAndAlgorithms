package trie;

import java.util.Map;
import java.util.TreeMap;

public class WordFrequency {
    private class Node {
        public int frequency;
        public Map<Character, Node> next;
        public Node() {
            frequency = 0;
            next = new TreeMap<>();
        }
    }
    private Node root = new Node();
    private int size;
    public WordFrequency() {
        root = new Node();
        size = 0;
    }
    public void insert(String word) {
        Node cur = root;
        char c;
        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if(cur.frequency == 0) {
            size++;
        }
        cur.frequency++;
    }
    public int getSize() {
        return size;
    }
    public int getFrequency(String word) {
        Node cur = root;
        char c;
        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        return cur.frequency;
    }
    public boolean contains(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.frequency != 0;
    }
    public void remove(String word) {
        if (contains(word)) {
            remove(root, word, 0);
        }
    }
    private Node remove(Node node, String word, int index) {
        if (index == word.length()) {
            size--;
            node.frequency = 0;
            return (node.next.size() == 0) ? null : node;
        }
        char c = word.charAt(index);
        node.next.put(c, remove(node.next.get(c), word, index+1));
        if (node.next.get(c) == null) {
            node.next.remove(c);
        }
        return node;
    }
}

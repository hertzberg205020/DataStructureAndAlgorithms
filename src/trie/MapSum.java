package trie;

import java.util.Map;
import java.util.TreeMap;

public class MapSum {
    private class Node {
        public int value;
        public Map<Character, Node> next;
        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }
        public Node() {
            this(0);
        }
    }
    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String word, int val) {
        Node cur = root;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        char c;
        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }
    private int sum(Node node) {
//        if(node.next.size() == 0) {
//            return node.value;
//        }
        int res = node.value;
        for(char nextChar : node.next.keySet()) {
            res += sum(node.next.get(nextChar));
        }
        return res;
    }
}

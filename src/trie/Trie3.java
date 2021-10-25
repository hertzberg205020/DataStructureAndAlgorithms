package trie;

public class Trie3 {
    private class Node {
        public boolean isWord;
        public Node[] next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new Node[26];
        }
        public Node() {
            this(false);
        }
    }
    private Node root;
    private int size;
    public Trie3() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }
    public void add(String word) {
        Node cur = root;
        char c;
        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (cur.next[c-'a'] == null) {
                cur.next[c-'a'] = new Node();
            }
            cur = cur.next[c-'a'];
        }
        if(!cur.isWord) {
            size++;
            cur.isWord = true;
        }
    }
    public boolean contains(String word) {
        Node cur = root;
        char c = 0;
        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (cur.next[c-'a'] == null) {
                return false;
            }
            cur = cur.next[c-'a'];
        }
        return cur.isWord;
    }
}

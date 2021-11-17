package trie;

import java.util.Map;
import java.util.TreeMap;

public class Trie {
    private class Node {
        public boolean isWord;
        public Map<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node() {
            this(false);
        }
    }
    private Node root;
    private int size;
    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
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
        return cur.isWord;
    }
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for(int i=0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
    public void remove(String word) {
        root = remove(root, word, 0);
    }
    // 刪除trie中的word字串
    // 返回刪除word字串後，trie的根結點
    private Node remove(Node node, String word, int index) {
        if (index == word.length()) {
            if(node.isWord) {
                size--;
                node.isWord = false;
            }
            return (node.next.size() == 0) ? null : node;
        }
        char c = word.charAt(index);
        // 先刪節點
        // 接住刪除節點後的變化trie
        node.next.put(c, remove(node.next.get(c), word, index+1));
        // 假如返回節點為空值，則刪除指向
        if (node.next.get(c) == null) {
            node.next.remove(c);
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("panda");
        trie.add("pan");
        System.out.println(trie.getSize());
        trie.remove("pan");
        System.out.println(trie.getSize());
        System.out.println(trie.contains("apple"));
        System.out.println(trie.contains("pan"));
        System.out.println(trie.contains("panda"));
    }
}

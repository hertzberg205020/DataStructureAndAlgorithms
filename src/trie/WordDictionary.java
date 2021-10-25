package trie;

import java.util.Map;
import java.util.TreeMap;

public class WordDictionary {
    private class Node{
        public boolean isWord;
        public Map<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
        public Node() {
            this(false);
        }
    }
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }
    private boolean match(Node node, String word, int index) {
        // next������п���next[i] == null
        // ��'.'ģ��ƥ���^���Е����F��ָᘮ���
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index+1);
        } else {
            for(char nextChar : node.next.keySet()) {
                if(match(node.next.get(nextChar), word, index+1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

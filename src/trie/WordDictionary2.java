package trie;

import java.util.Map;
import java.util.TreeMap;

public class WordDictionary2 {
    private class Node{
        public boolean isWord;
        public Node[] next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new Node[26];
        }
        public Node() {
            this(false);
        }
    }
    private Node root;

    public WordDictionary2() {
        root = new Node();
    }
    public void addWord(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c-'a'] == null) {
                cur.next[c-'a'] = new Node();
            }
            cur = cur.next[c-'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }
    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            if (node.next[c-'a'] == null) {
                return false;
            }
            return match(node.next[c-'a'], word, index+1);
        } else {
            for(int i = 0; i < node.next.length; i++) {
                if(match(node.next[i], word, index+1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

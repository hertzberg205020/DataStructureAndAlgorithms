package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST01<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;
        public Node(E e) {
            this.e = e;
            left = right = null;
        }
    }
    private Node root;
    private int size;
    public BST01() {
        root = null;
        size = 0;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(E e) {
        root = add(root, e);
    }
    // 向以node為根的二分搜索樹中插入元素e
    private Node add(Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else { // e.compareTo(node.e) > 0
            node.right = add(node.right, e);
        }
        return node;
    }
    public void add2(E e) {
        if(root == null) {
            root = new Node(e);
            size++;
            return;
        }
        Node p = root;
        while(p != null) {
            if(e.compareTo(p.e) < 0) {
                if(p.left == null) {
                    p.left = new Node(e);
                    size++;
                    return;
                }
                p = p.left;
            } else if(e.compareTo(p.e) > 0) {
                if(p.right == null) {
                    p.right = new Node(e);
                    size++;
                    return;
                }
                p = p.right;
            } else {
                return;
            }
        }

    }
    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }
        if(e.equals(node.e)) {
            return true;
        } else if(e.compareTo(node.e) < 0 ) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    public void preOrderNR() {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }

    }
    public void levelOrder() {
        if(root == null) {
            return;
        }
        Node cur = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
    public E minimum() {
        if(isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minNode = minimum(root);
        return minNode.e;
    }
    private Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    // 刪除掉以node為根的二分搜索樹中的最小節點
    // 返回刪除節點後新的二分搜索樹的根
    private Node removeMin(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    public E maximum() {
        if(isEmpty()) {
            throw new IllegalArgumentException("BST is empty.");
        }
        Node maxNode = minimum(root);
        return maxNode.e;
    }
    private Node maximum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maximum(node.right);
    }
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node) {
        if(node.right == null) {
            Node leftNode = node.right;
            node = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }
    public void remove(E e) {
        root = remove(root, e);
    }
    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        }
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // node.e.compareTo(e) == 0
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }
    public static void main(String[] args) {
        BST01<Integer> bst01 = new BST01<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst01.add(num);
//        bst01.preOrder();
//        System.out.println();
        bst01.levelOrder();
        System.out.println();
        bst01.remove(8);
        bst01.levelOrder();
    }
}

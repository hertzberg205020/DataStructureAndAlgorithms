package binarysearchtree;

public class BSTPractice<E extends Comparable<? super E>> {
    private class Node{
        E e;
        Node left;
        Node right;
        public Node(E e) {
            this.e = e;
            left = right = null;
        }
        public Node() {
            this(null);
        }
    }
    Node root;
    int size;
    public BSTPractice() {
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

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        Node retNode = minimum(root);
        return retNode.e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E removeMinimum() {
        E retVal = minimum();
        root = removeMinimum(root);
        return retVal;
    }

    private Node removeMinimum(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMinimum(node.left);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            Node successor = removeMinimum(node);
            // size++;
            successor.left = node.left;
            successor.right = node.right;
            node.left = node.right = null;
            // size--;
            return successor;
        }

    }

}

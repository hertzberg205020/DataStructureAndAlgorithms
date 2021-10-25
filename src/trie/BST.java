package trie;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<? super E>> {
    private class Node {
        public E e;
        public Node left, right;
        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    private int size;

    public BST() {
        this.root =null;
        this.size = 0;
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

    //向以root為根的二分搜索樹中插入元素e，遞歸算法
    //返回插入新節點後二分搜索樹的根

    private Node add(Node root, E e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        //為了使二分搜索樹的狀態發生改變
        //以root.left為根結點的左子樹 或者 以root.right為根結點的右子樹中插入元素e
        //其返回的結果可能是變化的，所以要讓root的左或者是右子樹接住這個變化，進行狀態更新
        //使加入的節點能與鏈接結構產生連結(關聯)
        //例如: root.left一開始為null，經過遞歸調用add(root.left, e)會返回新插入的節點
        //root.left要發生狀態變更，才能使二分搜索樹產生狀態的改變
        if (e.compareTo(root.e) < 0) {
           root.left = add(root.left, e);
        } if (e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        }
        //依據函式的語意須返回根結點，再插入新的節點元素後，root依然是以root為根結點的二分搜索樹
        //相應的根結點
        return root;
    }
    //以循環的方式在二分搜索樹中添加元素
    public void add2(E e) {
        if (root == null) {
            size++;
            root = new Node(e);
            return;
        }

        Node prevNode = null;
        Node curNode = root;
        boolean isLarger = true;

        while(curNode != null) {
            if (curNode.e.compareTo(e) == 0) {
                return;
            }

            prevNode = curNode;

            if (e.compareTo(curNode.e) < 0) {
                isLarger = false;
                curNode = curNode.left;
            } else {
                isLarger = true;
                curNode = curNode.right;
            }
        }
        size++;
        if (isLarger) {
            prevNode.right = new Node(e);
        } else {
            prevNode.left = new Node(e);
        }

    }
    //以循環的方式在二分搜索樹中添加元素
    public void add3(E e) {
        //二分搜索樹為null時，要進行特殊處理
        //讓root指向新的節點即可
        if (root == null) {
            size++;
            root = new Node(e);
            return;
        }
        //用node來跟蹤待插入節點的上一個節點
        //node的作用相當於鏈表插入節點時，prevNode的作用
        Node node = root;
        while (node != null) {
            //若待插入的值小於當前node的值
            //說明插入的值要放在node的左子樹
            if (e.compareTo(node.e) < 0) {
                //若node的左子樹為空，則在node.left上放入新的節點
                if(node.left == null) {
                    size++;
                    node.left = new Node(e);
                    return; //完成插入操作後，注意要return
                }

                node = node.left;
            }
            //若待插入的值大於當前node的值
            //說明插入的值要放在node的右子樹
            else if (e.compareTo(node.e) > 0) {
                //若node的右子樹為空，則在node.right上放入新的節點
                if (node.right == null) {
                    size++;
                    node.right = new Node(e);
                    return; //完成插入操作後，注意要return
                }

                node = node.right;
            }
            //若待插入的值等於當前node節點的值，說明二分搜索樹中已有這個值
            //直接return
            else {
                return;
            }
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        } else { //e.compareTo(root.e) > 0
            return contains(root.right, e);
        }
    }

    //二分搜索樹的前序遍歷
    public void preOrder() {
        preOrder(root);
    }

    //前序遍歷以node為根結點的二分搜索樹，遞歸算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //以非遞歸的方式前序遍歷以node為根結點的二分搜索樹
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    //二分搜索樹的中序遍歷
    public void inOrder() {
        inOrder(root);
    }

    //中序遍歷以node為根結點的二分搜索樹，遞歸算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索樹的後序遍歷
    public void postOrder() {
        postOrder(root);
    }
    //二分搜索樹的後續遍歷，遞歸算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    //二分搜索樹的層序遍歷
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    //尋找二分搜索樹的最小值
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minNode = minimum(root);
        return minNode.e;
    }

    //返回以node為根結點的二分搜索樹的最小值所在的節點
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //從二分搜索樹中刪除最小值所在節點，返回最小值
    public E removeMin() {
        E retVal = minimum();
        root = removeMin(root);
        return retVal;
    }

    //刪除以node為根的二分搜索樹中的最小值所在的節點
    //返回刪除節點後，新的二分搜索樹的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    //尋找二分搜索樹的最大值
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        Node maxNode = maximum(root);
        return maxNode.e;
    }

    //返回以node為根結點的二分搜索樹的最大值所在的節點
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //從二分搜索樹中刪除最大值所在節點，返回最小值
    public E removeMax() {
        E maxVal = maximum();
        root = removeMax(root);
        return maxVal;
    }

    //刪除以node為根的二分搜索樹中的最大值所在的節點
    //返回刪除節點後，新的二分搜索樹的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //從二分搜索數中刪除元素為e的節點
    public void remove(E e) {
        root = remove(root, e);
    }

    //刪除掉以node為根的二分搜索樹中值為e的節點，遞歸算法
    //返回刪除節點後二分搜索樹的根
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else { //e.compareTo(node.e) == 0
            //待刪除的節點左子樹為空的情況
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //待刪除的節點右子樹為空的情況
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待刪除節點左右子樹均不為空

            //找到比待刪除節點大的最小節點，即待刪除節點右子樹的最小節點
            //用這個節點替待刪除節點的位置
            Node successor = removeMin(node.right);
            //size++; //並沒有要刪除右子樹中的最小節點，只是此節點取代待刪除節點的位置
            successor.right = node.right;
            successor.left =node.left;

            node.left = node.right = null;
            //size--; //刪除掉node節點
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTstring(root, 0, res);
        return res.toString();
    }

    //生成以node為根結點，深度為depth 用來描述二元樹的字串
    private void generateBSTstring(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTstring(node.left, depth+1, res);
        generateBSTstring(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}

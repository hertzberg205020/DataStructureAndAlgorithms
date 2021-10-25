package UnionFind;

public class UnionFind3 implements UF {
    private int[] parent; // parent[i]表示一元素所指向的父親節點
    private int[] sz; // sz[i]表示以i為根的集合中元素個數
    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        // 初始化每一個parent[i]指向自己，表示每一個元素自己自成一個集合
        for(int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
    // 查找過程，查詢元素p所對應的集合編號，根結點編號
    // O(h)的複雜度，h為樹的高度
    private int find(int p) {
        if(p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        // 不斷去查找自己的父親節點，直到根結點為止
        // 根結點的特點: parent[p] = p
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合併元素p與元素q所屬的集合
    // O(h)的複雜度，h為樹的高度
    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根據2個元素所在樹的元素個數不同判斷合併方向
        // 將元素個數少的集合合併到元素個數多的集合上
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else { // sz[pRoot] >= sz[qRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}

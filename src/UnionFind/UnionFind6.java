package UnionFind;

public class UnionFind6 implements UF{
    private int[] parent; // parent[i]表示一元素所指向的父親節點
    private int[] rank; // rank[i]表示以i為根的集合所表示樹的層數
    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        // 初始化每一個parent[i]指向自己，表示每一個元素自己自成一個集合
        for(int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        // 根結點的特點: parent[p] = p
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
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

        // 根據2個元素所在樹的rank不同判斷合併的方向
        // 將rank低的集合合併到rank高的的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        } else { // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1; // 此時，維護rank的值
        }
    }
}

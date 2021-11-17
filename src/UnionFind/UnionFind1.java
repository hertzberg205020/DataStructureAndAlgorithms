package UnionFind;

// 第一版的union-find
public class UnionFind1 implements UF{
    private int[] id; // 第一版的union-find本質就是一個數組

    public UnionFind1(int size) {
        id = new int[size];

        // 初始化，每一個id指向自己，沒有合併的元素
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
    // 查找元素p所對應的集合編號
    // O(1)複雜度
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        return id[p];
    }

    // 查找元素p所對應的集合編號
    // O(1)複雜度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合併元素p與元素q所屬集合
    // O(n)複雜度
    @Override
    public void unionElement(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID) {
            return;
        }
        // 合併過程需要循環遍歷所有元素，將兩個元素所屬的集合編號合併
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}

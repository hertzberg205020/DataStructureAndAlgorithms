package UnionFind;

public class UnionFind6 implements UF{
    private int[] parent; // parent[i]��ʾһԪ����ָ��ĸ��H���c
    private int[] rank; // rank[i]��ʾ��i����ļ�������ʾ��ČӔ�
    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        // ��ʼ��ÿһ��parent[i]ָ���Լ�����ʾÿһ��Ԫ���Լ��Գ�һ������
        for(int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
    // �����^�̣���ԃԪ��p�������ļ��Ͼ�̖�����Y�c��̖
    // O(h)���}�s�ȣ�h���ĸ߶�
    private int find(int p) {
        if(p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        // ���Y�c�����c: parent[p] = p
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // �ρ�Ԫ��p�cԪ��q���ٵļ���
    // O(h)���}�s�ȣ�h���ĸ߶�
    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // ����2��Ԫ�����ژ��rank��ͬ�Д�ρ�ķ���
        // ��rank�͵ļ��Ϻρ㵽rank�ߵĵļ�����
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        } else { // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1; // �˕r���S�orank��ֵ
        }
    }
}

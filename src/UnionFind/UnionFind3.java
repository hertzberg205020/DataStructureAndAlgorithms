package UnionFind;

public class UnionFind3 implements UF {
    private int[] parent; // parent[i]��ʾһԪ����ָ��ĸ��H���c
    private int[] sz; // sz[i]��ʾ��i����ļ�����Ԫ�؂���
    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        // ��ʼ��ÿһ��parent[i]ָ���Լ�����ʾÿһ��Ԫ���Լ��Գ�һ������
        for(int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        // ����ȥ�����Լ��ĸ��H���c��ֱ�����Y�c��ֹ
        // ���Y�c�����c: parent[p] = p
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
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

        // ����2��Ԫ�����ژ��Ԫ�؂�����ͬ�Д�ρ㷽��
        // ��Ԫ�؂����ٵļ��Ϻρ㵽Ԫ�؂�����ļ�����
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else { // sz[pRoot] >= sz[qRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}

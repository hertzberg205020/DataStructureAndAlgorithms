package UnionFind;
// �ڶ����Union-Find
public class UnionFind2 implements UF {
    // �ڶ����Union-Find��ʹ��һ�����M����һ��ָ���H���c�Ę�
    // parent[i]��ʾһԪ����ָ��ĸ��H���c
    private int[] parent;
    public UnionFind2(int size) {
        parent = new int[size];

        // ��ʼ��ÿһ��parent[i]ָ���Լ�����ʾÿһ��Ԫ���Լ��Գ�һ������
        for(int i = 0; i < size; i++) {
            parent[i] = i;
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
        parent[pRoot] = qRoot;
    }
}

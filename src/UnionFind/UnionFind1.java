package UnionFind;

// ��һ���union-find
public class UnionFind1 implements UF{
    private int[] id; // ��һ���union-find���|����һ�����M

    public UnionFind1(int size) {
        id = new int[size];

        // ��ʼ����ÿһ��idָ���Լ����]�кρ��Ԫ��
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
    // ����Ԫ��p�������ļ��Ͼ�̖
    // O(1)�}�s��
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        return id[p];
    }

    // ��ԃԪ��p�cԪ��q�Ƿ��һ������
    // O(1)�}�s��
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // �ρ�Ԫ��p�cԪ��q���ټ���
    // O(n)�}�s��
    @Override
    public void unionElement(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID) {
            return;
        }
        // �ρ��^����Ҫѭ�h��v����Ԫ�أ����ɂ�Ԫ�����ٵļ��Ͼ�̖�ρ�
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}

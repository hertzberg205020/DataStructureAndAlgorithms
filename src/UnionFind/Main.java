package UnionFind;

import java.util.Random;

public class Main {
    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElement(a, b);
        }
        for(int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;

//        UF uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1: " + testUF(uf1, m) + " sec");
//
//        UF uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2: " + testUF(uf2, m) + " sec");

//        UF uf3 = new UnionFind3(size);
//        System.out.println("UnionFind3: " + testUF(uf3, m) + " sec");

//        UF uf4 = new UnionFind4(size);
//        System.out.println("UnionFind4: " + testUF(uf4, m) + " sec");

        UF uf5 = new UnionFind5(size);
        System.out.println("UnionFind5: " + testUF(uf5, m) + " sec");

        UF uf6 = new UnionFind6(size);
        System.out.println("UnionFind6: " + testUF(uf6, m) + " sec");
    }
}

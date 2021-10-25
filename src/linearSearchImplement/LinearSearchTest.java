package linearSearchImplement;

public class LinearSearchTest {
    public static void main(String[] args) {
        //測試用數據規模的陣列
        int[] dataSize = {1000000, 10000000};
        for(int n : dataSize) {
            Integer[] data = ArrayGenerator.GenerateOrderArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();

            //程序運作時間 nanosecond->second 並轉型為double
            double time = (endTime - startTime)/1000000000.0;
            System.out.println("n = " + n + ", 100 runs:" + time + "s");
        }
    }
}

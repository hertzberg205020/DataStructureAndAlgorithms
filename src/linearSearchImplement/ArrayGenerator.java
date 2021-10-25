package linearSearchImplement;

//創造測試用陣列
public class ArrayGenerator {
    private ArrayGenerator() {

    }

    public static Integer[] GenerateOrderArray(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }
}

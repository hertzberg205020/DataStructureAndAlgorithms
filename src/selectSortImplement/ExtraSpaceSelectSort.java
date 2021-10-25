package selectSortImplement;

import java.util.ArrayList;
import java.util.List;

//這種方法會多用額外空間，且算法的時間性能並未改善
public class ExtraSpaceSelectSort {
    private ExtraSpaceSelectSort() {

    }
    public static void sort(int[] array) {
        //使用額外空間(sorted)寫入排序後的陣列
        List<Integer> sorted = new ArrayList<>(array.length);
        //將陣列轉換為ArrayList形式，因為陣列不能直接刪除陣列中取走的元素
        List<Integer> original = new ArrayList<>(array.length);
        for(int element : array) {
            original.add(element);
        }
        //每次循環都將原陣列中最小值的元素拿到新陣列中，並在原陣列中刪除取走的元素
        while(original.size() > 0) {
            Integer element = ExtraSpaceSelectSort.ExtractMin(original);
            sorted.add(element);
        }
        //將排列好順序的ArrayList寫到array陣列
        for (int i = 0; i < array.length; i++) {
            array[i] = sorted.get(i);
        }
    }
    //取出ArrayList中最小的元素，取完後並刪除該元素
    private static Integer ExtractMin(List<Integer> original) {
        int index = 0;
        int min = original.get(0);
        for (int i = 0; i < original.size(); i++) {
            if (min > original.get(i)) {
                min = original.get(i);
                index = i;
            }
        }
        original.remove(index);
        return min;
    }


}

package linearSearchImplement;

public class LinearSearch {
    //工具類，不希望用戶創建對象
    private LinearSearch() {

    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            //比較內容，而不是引用
            if(data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}

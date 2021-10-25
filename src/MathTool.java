import java.util.Random;

public class MathTool {
    private MathTool() {}

    //find highest common factor(HCF)
    public static int HCF(int a, int b) {
        if (b > a) {
            swap(a, b);
        }
        return GCD(a, b);
    }
    //greatest common divisor(GCD)，遞歸算法
    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b= temp;
    }
    public static void dice(int k) {
        Random rnd = new Random();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = rnd.nextInt(6)+1;
        }
        System.out.print("[");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]);
            if (i != k-1) {
                System.out.print(", ");
            }
        }
        System.out.print(']');
    }

    public static void main(String[] args) {
        dice(20);
    }
}

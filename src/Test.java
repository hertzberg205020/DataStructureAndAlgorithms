import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    private Test() {}
    public static void multiplicationTable() {
        multiplicationTable(1, 1);
    }

    private static void multiplicationTable(int i, int j) {
        if (i > 9) {
            return;
        }
        else {
            if (j > 9) {
                System.out.println();
                multiplicationTable(i+1, 1);;
            }
            else {
                System.out.print(String.format("%d x %d = %2d  ", j, i, j*i));
                multiplicationTable(i, j+1);
            }
        }
    }
    public static int fibonacci(int n) {
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 1;
        if (n == 0 || n == 1) {
            return n;
        }
        int i;
        for (i = 2; i <= n; i++) {

            temp[i%2] = temp[(i-1)%2] + temp[(i-2)%2];
        }

        return temp[n%2];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(3));;
    }
}

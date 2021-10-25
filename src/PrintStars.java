public class PrintStars {
    //      *
    //     ***
    //    *****
    //     ***
    //      *
    public static void printDiamond(int layers) {
        int n = layers;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n + i; j++) {
                if(i + j < n-1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < n + i; j++) {
                if(i + j < n-1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printDiamond(3);
    }
}

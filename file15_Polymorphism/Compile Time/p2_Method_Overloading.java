import java.util.Arrays;

public class p2_Method_Overloading {
    // change method
    public static void change(int num) {
        num = 100;
    }

    // change method
    public static void change(int[] arr) {
        arr[0] = 100;
        arr[1] = 200;
    }

    public static void main(String[] args) {

        // changing an integer
        int a = 10;
        System.out.println("\nBefore changing an Integer : " + a);
        change(a);
        System.out.println("After changing an Integer : " + a);

        // changing an Array
        int b[] = { 1, 2, 3, 4, 5 };
        System.out.println("\nBefore changing an Array : " + Arrays.toString(b));
        change(b);
        System.out.println("\nAfter changing an Array : " + Arrays.toString(b));

    }
}

import java.util.Arrays;

public class Main {
    public static int findDuplicate (int [] a) {
        int temp = a[a[0]];
        while (temp != a[0]) {
            a[a[0]] = a[0];
            a[0] = temp;
            temp = a[a[0]];
        }
        return a[0];
    }
    public static void main(String[] args) {
        int[] a1 = {2, 4, 5, 3, 5, 1};
        int[] a2 = {1, 5, 4, 6, 6, 3, 2};
        System.out.println(findDuplicate(a1));
        System.out.println(findDuplicate(a2));
    }
}
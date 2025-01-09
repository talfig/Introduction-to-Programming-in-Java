import java.util.Arrays;

public class Main {
    public static int count (int sum) {
        return count (sum, 1);
    }
    private static int count (int sum, int num) {
        if (sum == 0)
            return 1;
        if (sum < 0 || sum < num)
            return 0;
        return count (sum - num, num + 1)
                + count(sum, num + 1);
    }
    public static void minNumWithSum (int[] arr, int s) {
        if (s < arr.length)
            return;
        for (int i = 0; i < arr.length; i++) {
            for (int num = 1; num <= 9; num++) {
                if (s - num <= 9 * (arr.length - i - 1)) {
                    arr[i] = num;
                    s -= num;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(count(7));
        int[] arr = {0, 0, 0, 0};
        minNumWithSum(arr, 3);
        System.out.println(Arrays.toString(arr));
        StringList list = new StringList("abbcdcabc");
        System.out.println(list.what('d', 4));
    }
}
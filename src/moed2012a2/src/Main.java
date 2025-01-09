public class Main {
    private static boolean isSumOf (int[] s, int n, int i, String sol) {
        if (n == 0) {
            System.out.println(sol);
            return true;
        }
        if (i == s.length || n < 0)
            return false;
        return isSumOf(s, n - s[i], i, sol + s[i] + " ")
                || isSumOf(s, n, i + 1, sol);
    }
    public static boolean isSumOf (int[] s, int n) {
        return isSumOf (s, n, 0, "");
    }
    public static int binarySearch (int[] arr, double x) {
        int low = 0, high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
    public static int count (int[] arr, int x) {
        return binarySearch(arr, x + 0.25) - binarySearch(arr, x - 0.25);
    }
    public static void main(String[] args) {
        int[] s = {4, 5};
        int[] a = {-5, -5, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 67, 67, 99};
        //System.out.println(isSumOf(s, 135));
        System.out.println(count(a, 2));
    }
}
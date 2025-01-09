public class Main {
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
        int[] arr = {1, 2, 4, 4, 4, 5, 5, 5, 5, 6, 6, 9};
        System.out.println(count(arr, 5));
    }
}
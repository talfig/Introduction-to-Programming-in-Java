public class Main {
    private static boolean isPalindrome (int[] arr, int low, int high, int count) {
        if (count > 1)
            return false;
        if (low >= high)
            return true;
        if (arr[low] != arr[high])
            count++;
        return isPalindrome (arr, low + 1, high - 1, count);
    }
    private static int longestAlmostPalindrome (int [] arr, int low, int high, int maxPol) {
        if (isPalindrome(arr, low, high, 0) && arr[low] == arr[high])
            return maxPol;
        int left = longestAlmostPalindrome (arr, low + 1, high, maxPol - 1);
        int right = longestAlmostPalindrome (arr, low, high - 1, maxPol - 1);
        return Math.max(left, right);
    }
    public static int longestAlmostPalindrome (int [] arr) {
        return longestAlmostPalindrome (arr, 0, arr.length - 1, arr.length);
    }
    public static int findNumber (int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (arr[mid] + 1 < arr[mid - 1])
                return arr[mid] + 1;
            if (arr[mid] - 1 > arr[mid + 1])
                return arr[mid] - 1;
            if (arr[low] - arr[mid] > high - mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return (arr[low] - 1 > arr[high]) ? arr[low] - 1 : Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        int[] arr1 = {4, 10, 10, 3};
        int[] arr2 = {8, 7, 6, 5, 4, 3, 1};
        System.out.println(longestAlmostPalindrome(arr1));
        System.out.println(findNumber(arr2));
    }
}
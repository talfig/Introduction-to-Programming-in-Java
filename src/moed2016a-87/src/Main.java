public class Main {
    private static int minDiff (int[] arr, int i, int sum1, int sum2) {
        if (i == arr.length)
            return Math.abs(sum2 - sum1);
        return Math.min(minDiff(arr, i + 1, sum1 + arr[i], sum2),
                minDiff(arr, i + 1, sum1, sum2 + arr[i]));
    }
    public static int minDiff (int[] arr) {
        return minDiff(arr, 0, 0, 0);
    }
    public static int passingCars (int [] a) {
        int countWest = 0;
        int count = 0;
        for (int i=0; i<a.length;i++) {
            if (a[i] == 0)
                countWest++;
            else
                count += countWest;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 17, 6};
        int[] a = {0, 1, 0, 1, 1};
        System.out.println(minDiff(arr));
        System.out.println(passingCars(a));
    }
}
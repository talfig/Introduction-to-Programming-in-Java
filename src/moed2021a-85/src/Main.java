public class Main {
    private static int minPrice (int[][] mat, int i, int j) {
        if (j == mat.length - 1)
            return mat[i][j];
        return Math.min(minPrice(mat, i, j + 1), mat[i][j] + minPrice(mat, j, j + 1));
    }
    public static int minPrice (int[][] mat) {
        return minPrice (mat, 0, 1);
    }
    public static int sum (int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }
    public static boolean findAverage (int[] arr, double x) {
        int low = 0, high = arr.length - 1;
        int sum = sum(arr);
        while (low <= high) {
            if (sum == x * (high - low + 1)) {
                System.out.println("Subarray was found between the indexes " + low + " --- " + high);
                return true;
            }
            if (sum < x * (high - low + 1)) {
                sum -= arr[low];
                low++;
            }
            else {
                sum -= arr[high];
                high--;
            }
        }
        System.out.println("No subarray was found");
        return false;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {0, 15, 80, 90},
                {-1, 0, 40, 50},
                {-1, -1, 0, 70},
                {-1, -1, -1, 0}
        };
        int[] arr = {2, 3, 8, 14, 15, 35};
        System.out.println(minPrice(mat));
        System.out.println(findAverage(arr, 10));
    }
}
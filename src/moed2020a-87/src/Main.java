public class Main {
    private static int totalWays (int[][] mat, int k, int i, int j, int prev) {
        if (i >= mat.length || j >= mat[0].length)
            return 0;
        if (k == 0 && i == mat.length - 1 && j == mat[0].length - 1)
            return 1;
        if (prev == 0)
            return totalWays(mat, k, i + 1, j, 0) + totalWays(mat, k - 1, i, j + 1, 1);
        if (prev == 1)
            return totalWays(mat, k - 1, i + 1, j, 0) + totalWays(mat, k, i, j + 1, 1);
        return totalWays(mat, k, i + 1, j, 0) + totalWays(mat, k, i, j + 1, 1);
    }
    public static int totalWays (int[][] mat, int k) {
        return totalWays (mat, k, 0, 0, -1);
    }
    // Time - O(n^2)
    // Space - O(1)
    public static void printTriplets (int[] a, int num) {
        for (int k = 0; k < a.length; k++) {
            int i = k + 1, j = a.length - 1;
            while (i < j) {
                if (a[i] * a[j] * a[k] == num) {
                    System.out.println(a[i] + "\t" + a[j] + "\t" + a[k]);
                    i++;
                }
                else if (a[i] * a[j] * a[k] > num)
                    j--;
                else
                    i++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        //System.out.println(totalWays(mat, 2));
        int[] a = {1, 2, 3, 4, 5, 7, 8, 9};
        printTriplets(a, 40);
    }
}